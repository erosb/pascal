package pascal;

import java.util.HashMap;
import java.util.Map;

import pascal.parser.PascalBaseVisitor;
import pascal.parser.PascalParser;
import pascal.parser.PascalParser.AddSubContext;
import pascal.parser.PascalParser.AssignContext;
import pascal.parser.PascalParser.FunctionContext;
import pascal.parser.PascalParser.IfStructContext;
import pascal.parser.PascalParser.LoopStructContext;
import pascal.parser.PascalParser.StmtContext;
import pascal.parser.PascalParser.VarDeclContext;
import pascal.symbol.FunctionSignature;
import pascal.symbol.SymbolTable;
import pascal.symbol.Variable;

public class ExecutorVisitor extends PascalBaseVisitor<Void>{

	private final SymbolTable globalScope = new SymbolTable(null);
	
	private SymbolTable currentScope = globalScope;
	
	private final Map<String, Type> types;
	
	private final Map<FunctionSignature, PascalParser.FunctionContext> functions;
	
	private final Type returnType;
	
	public ExecutorVisitor(Map<String, Type> types,
			Map<FunctionSignature, FunctionContext> functions) {
		super();
		if (types == null) {
			throw new IllegalArgumentException("types cannot be null");
		}
		if (functions == null) {
			throw new IllegalArgumentException("functions cannot be null");
		}
		this.types = types;
		this.functions = functions;
		returnType = null;
	}

	@Override
	public Void visitVarDecl(VarDeclContext ctx) {
		Type type;
		if (ctx.type.getText().equals("integer")) {
			type = Type.INTEGER;
		} else if (ctx.type.getText().equals("string")) {
			type = Type.STRING;
		} else if (ctx.type.getText().equals("boolean")) {
			type = Type.BOOLEAN;
		} else {
			throw new SemanticException("unknown type " + ctx.type.getText(), ctx.getStart().getLine());
		}
		currentScope.add(new Variable(ctx.varName.getText(), type, null));
		return null;
	}

	@Override
	public Void visitAssign(AssignContext ctx) {
		String varName = ctx.ID().getText();
		Variable var = currentScope.get(varName);
		if (var == null) {
			throw new SemanticException("variable " + varName + " not found", ctx.getStart().getLine());
		}
		Value value = createExprEvalVisitor().visit(ctx.expr());
		if (var.getType().equals(value.getType())) {
			currentScope.add(new Variable(var.getName(), value.getType(), value.getValue()));
		} else {
			throw new SemanticException("type mismatch: cannot convert from " + value.getType() + " to " + var.getType(), ctx.getStop().getLine());
		}
		return super.visitAssign(ctx);
	}
	
	

	@Override
	public Void visitIfStruct(IfStructContext ctx) {
		Value pred = createExprEvalVisitor().visit(ctx.expr());
		if ( ! pred.getType().equals(Type.BOOLEAN)) {
			throw new SemanticException("predicate expected, " + pred.getType() + " expression found", ctx.expr().getStart().getLine());
		}
		if (pred.getValue().equals("true")) {
			return super.visitIfStruct(ctx);
		}
		return null;
	}
	
	

	@Override
	public Void visitLoopStruct(LoopStructContext ctx) {
		if (ctx.preCond != null && ctx.postCond != null) {
			throw new SemanticException("a loop cannot have both pre-condition and post-condition", ctx.getStart().getLine());
		}
		Value exCondVal;
		if (ctx.preCond != null) {
			while ( (exCondVal = createExprEvalVisitor().visit(ctx.preCond)).getValue().equals("true")) {
				for (StmtContext stmtCtx: ctx.stmt()) {
					visitStmt(stmtCtx);
				}
			}
		} else {
			do {
				for (StmtContext stmtCtx: ctx.stmt()) {
					visitStmt(stmtCtx);
				}
			} while ( (exCondVal = createExprEvalVisitor().visit(ctx.postCond)).getValue().equals("true"));
		}
		return null;
	}

	public SymbolTable getGlobalScope() {
		return globalScope;
	}
	
	private ExprEvalVisitor createExprEvalVisitor() {
		return new ExprEvalVisitor(currentScope, types, functions);
	}

}
