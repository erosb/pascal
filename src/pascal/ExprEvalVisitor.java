package pascal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pascal.parser.PascalBaseVisitor;
import pascal.parser.PascalParser;
import pascal.parser.PascalParser.AddSubContext;
import pascal.parser.PascalParser.CallContext;
import pascal.parser.PascalParser.DivMulContext;
import pascal.parser.PascalParser.ExprContext;
import pascal.parser.PascalParser.FunctionContext;
import pascal.parser.PascalParser.LiteralContext;
import pascal.parser.PascalParser.PredicateContext;
import pascal.parser.PascalParser.VarRefContext;
import pascal.symbol.FunctionSignature;
import pascal.symbol.Parameter;
import pascal.symbol.SymbolTable;
import pascal.symbol.Variable;

public class ExprEvalVisitor extends PascalBaseVisitor<Value> {

    private final SymbolTable scope;

    private final Map<String, Type> types;

    private final Map<FunctionSignature, PascalParser.FunctionContext> functions;

    public ExprEvalVisitor(final SymbolTable scope,
            final Map<String, Type> types,
            final Map<FunctionSignature, FunctionContext> functions) {
        super();
        this.scope = scope;
        this.types = types;
        this.functions = functions;
    }

    private Value createIntComparisonPredicate(final int lval, final String op, final int rval) {
        String val;
        if (op.equals("=")) {
            val = String.valueOf(lval == rval);
        } else if (op.equals(">")) {
            val = String.valueOf(lval > rval);
        } else if (op.equals(">=")) {
            val = String.valueOf(lval >= rval);
        } else if (op.equals("<=")) {
            val = String.valueOf(lval <= rval);
        } else if (op.equals("<")) {
            val = String.valueOf(lval < rval);
        } else {
            throw new IllegalStateException("illegal operator: " + op);
        }
        return new Value(Type.BOOLEAN, val);
    }

    @Override
    public Value visitAddSub(final AddSubContext ctx) {
        Value leftOp = visit(ctx.expr(0));
        Value rightOp = visit(ctx.expr(1));
        Type leftType = leftOp.getType();
        Type rightType = rightOp.getType();
        String leftVal = leftOp.getValue();
        String rightVal = rightOp.getValue();
        if (ctx.op.getText().equals("+")) {
            if (leftType.equals(Type.INTEGER) && rightType.equals(Type.INTEGER)) {
                return new Value(Type.INTEGER, String.valueOf(Integer.valueOf(leftVal).intValue()
                        + Integer.valueOf(rightVal).intValue()));
            }
            if (leftType.equals(Type.STRING) && rightType.equals(Type.STRING)) {
                return new Value(Type.STRING, leftVal + rightVal);
            }
            throw new SemanticException("cannot perform '+' on " + leftType + " and " + rightType, ctx.getStart()
                    .getLine());
        } else {
            if (leftType.equals(Type.INTEGER) && rightType.equals(Type.INTEGER)) {
                return new Value(Type.INTEGER, String.valueOf(Integer.valueOf(leftVal).intValue()
                        - Integer.valueOf(rightVal).intValue()));
            }
            throw new SemanticException("cannot perform '-' on " + leftType + " and " + rightType, ctx.getStart()
                    .getLine());
        }
    }

    @Override
    public Value visitCall(final CallContext ctx) {
        String fnName = ctx.ID().getText();
        System.out.println("executing " + fnName);
        List<Type> argTypes = new ArrayList<Type>(ctx.argList().expr().size());
        List<Value> argVals = new ArrayList<Value>(ctx.argList().expr().size());
        for (ExprContext exprCtx : ctx.argList().expr()) {
            Value val = visit(exprCtx);
            argTypes.add(val.getType());
            argVals.add(val);
        }
        FunctionContext function = null;
        FunctionSignature fnSig = null;
        for (FunctionSignature sig : functions.keySet()) {
            if (!fnName.equals(sig.getName())) {
                continue;
            }
            List<Parameter> formalParams = sig.getParams();
            if (argTypes.size() != formalParams.size()) {
                continue;
            }
            boolean typesMatched = true;
            for (int i = 0; i < argTypes.size() && typesMatched; i++) {
                if (!formalParams.get(i).getType().equals(argTypes.get(i))) {
                    typesMatched = false;
                }
            }
            if (typesMatched) {
                function = functions.get(sig);
                fnSig = sig;
                break;
            }
        }
        if (function == null) {
            throw new SemanticException("function " + fnName + "(" + argTypes + ") is not defined", ctx.getStart()
                    .getLine());
        }
        SymbolTable scope = new SymbolTable(this.scope);
        Iterator<Value> argValIt = argVals.iterator();
        for (Parameter param : fnSig.getParams()) {
            if (!argValIt.hasNext()) {
                throw new IllegalStateException("argVals should have " + ctx.argList().expr().size()
                        + " elements, it has " + argVals.size() + " instead");
            }
            Value currArgVal = argValIt.next();
            scope.add(new Variable(param.getName(), param.getType(), currArgVal.getValue()));
        }
        ExecutorVisitor functionExecutor = new ExecutorVisitor(types, functions, types.get(function.retType.getText()),
                scope);
        functionExecutor.visit(function.block());
        return functionExecutor.getRetVal();
    }

    @Override
    public Value visitDivMul(final DivMulContext ctx) {
        Value leftOp = visit(ctx.expr(0));
        Value rightOp = visit(ctx.expr(1));
        Type leftType = leftOp.getType();
        Type rightType = rightOp.getType();
        String leftVal = leftOp.getValue();
        String rightVal = rightOp.getValue();
        String operator = ctx.op.getText();
        if (!(leftType.equals(Type.INTEGER) && rightType.equals(Type.INTEGER))) {
            throw new SemanticException("cannot perform '" + operator + "' on " + leftType + " and " + rightType, ctx
                    .getStart().getLine());
        }
        if (operator.equals("*")) {
            return new Value(Type.INTEGER, String.valueOf(Integer.valueOf(leftVal).intValue()
                    * Integer.valueOf(rightVal).intValue()));
        } else {
            try {
                return new Value(Type.INTEGER, String.valueOf(Integer.valueOf(leftVal).intValue()
                        / Integer.valueOf(rightVal).intValue()));
            } catch (ArithmeticException ex) {
                throw new SemanticException("division by zero", ctx.getStart().getLine());
            }
        }
    }

    @Override
    public Value visitLiteral(final LiteralContext ctx) {
        String lit = ctx.LITERAL().getText();
        if (lit.charAt(0) == '"') {
            return new Value(Type.STRING, lit.substring(1, lit.length() - 2));
        } else {
            return new Value(Type.INTEGER, lit);
        }
    }

    @Override
    public Value visitPredicate(final PredicateContext ctx) {
        Value leftOp = visit(ctx.expr(0));
        Value rightOp = visit(ctx.expr(1));
        Type leftType = leftOp.getType();
        Type rightType = rightOp.getType();
        String leftVal = leftOp.getValue();
        String rightVal = rightOp.getValue();
        String operator = ctx.op.getText();
        if (!leftType.equals(rightType)) {
            throw new SemanticException("cannot compare " + leftType + " to " + rightType, ctx.getStart().getLine());
        }
        if (leftType.equals(Type.INTEGER)) {
            return createIntComparisonPredicate(Integer.valueOf(leftVal), operator, Integer.valueOf(rightVal));
        }
        return super.visitPredicate(ctx);
    }

    @Override
    public Value visitVarRef(final VarRefContext ctx) {
        String varName = ctx.ID().getText();
        Variable var = scope.get(varName);
        if (var == null) {
            throw new SemanticException("cannot find variable '" + varName + "'", ctx.getStart().getLine());
        }
        return new Value(var.getType(), var.getValue());
    }

}
