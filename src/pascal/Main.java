package pascal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import pascal.parser.PascalLexer;
import pascal.parser.PascalParser;
import pascal.parser.PascalParser.ProgramContext;
import pascal.symbol.FunctionSignature;
import pascal.symbol.SymbolTable;
import pascal.symbol.Variable;

public class Main {

    private static void dumpSymbolTable(final SymbolTable globScope) {
        for (String varName : globScope.keySet()) {
            Variable var = globScope.get(varName);
            System.out.println(varName + " (" + var.getType() + "): "
                    + var.getValue());
        }
    }

    private static Map<String, Type> getBuiltinTypes() {
        Map<String, Type> rval = new HashMap<String, Type>(3);
        rval.put(Type.INTEGER.getName(), Type.INTEGER);
        rval.put(Type.STRING.getName(), Type.STRING);
        rval.put(Type.BOOLEAN.getName(), Type.BOOLEAN);
        return rval;
    }

    /**
     * @param args
     */
    public static void main(final String[] args) throws IOException {
        InputStream is = args.length == 0 ? System.in : new FileInputStream(args[0]);
        ANTLRInputStream input = new ANTLRInputStream(is);
        PascalLexer lexer = new PascalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PascalParser parser = new PascalParser(tokens);
        ProgramContext tree = parser.program();
        try {
            Map<FunctionSignature, PascalParser.FunctionContext> functions = new HashMap<FunctionSignature, PascalParser.FunctionContext>();
            Map<String, Type> types = getBuiltinTypes();
            for (PascalParser.FunctionContext ctx : tree.function()) {
                FunctionSignature sig = new FunctionSignatureLoader(types).visitFunction(ctx);
                functions.put(sig, ctx);
            }
            new OptimizerVisitor().visit(tree.block());
            ExecutorVisitor executor = new ExecutorVisitor(types, functions, null);
            executor.visit(tree.decl());
            executor.visit(tree.block());
            SymbolTable globScope = executor.getGlobalScope();
            dumpSymbolTable(globScope);
        } catch (SemanticException ex) {
            System.out.println("line " + ex.getLineNumber() + ": "
                    + ex.getMessage());
        }
    }

}
