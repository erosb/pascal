// Generated from Pascal.g4 by ANTLR 4.0
package pascal.parser;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class PascalBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements PascalVisitor<T> {
	@Override public T visitRet(PascalParser.RetContext ctx) { return visitChildren(ctx); }

	@Override public T visitCall(PascalParser.CallContext ctx) { return visitChildren(ctx); }

	@Override public T visitAssign(PascalParser.AssignContext ctx) { return visitChildren(ctx); }

	@Override public T visitParens(PascalParser.ParensContext ctx) { return visitChildren(ctx); }

	@Override public T visitIfStruct(PascalParser.IfStructContext ctx) { return visitChildren(ctx); }

	@Override public T visitArgList(PascalParser.ArgListContext ctx) { return visitChildren(ctx); }

	@Override public T visitLiteral(PascalParser.LiteralContext ctx) { return visitChildren(ctx); }

	@Override public T visitAddSub(PascalParser.AddSubContext ctx) { return visitChildren(ctx); }

	@Override public T visitVarDecl(PascalParser.VarDeclContext ctx) { return visitChildren(ctx); }

	@Override public T visitStmt(PascalParser.StmtContext ctx) { return visitChildren(ctx); }

	@Override public T visitLoopStruct(PascalParser.LoopStructContext ctx) { return visitChildren(ctx); }

	@Override public T visitBlock(PascalParser.BlockContext ctx) { return visitChildren(ctx); }

	@Override public T visitVarRef(PascalParser.VarRefContext ctx) { return visitChildren(ctx); }

	@Override public T visitFunctionCall(PascalParser.FunctionCallContext ctx) { return visitChildren(ctx); }

	@Override public T visitFunction(PascalParser.FunctionContext ctx) { return visitChildren(ctx); }

	@Override public T visitFormPar(PascalParser.FormParContext ctx) { return visitChildren(ctx); }

	@Override public T visitCtrlStruct(PascalParser.CtrlStructContext ctx) { return visitChildren(ctx); }

	@Override public T visitDivMul(PascalParser.DivMulContext ctx) { return visitChildren(ctx); }

	@Override public T visitProgram(PascalParser.ProgramContext ctx) { return visitChildren(ctx); }

	@Override public T visitPredicate(PascalParser.PredicateContext ctx) { return visitChildren(ctx); }

	@Override public T visitFormParList(PascalParser.FormParListContext ctx) { return visitChildren(ctx); }

	@Override public T visitDecl(PascalParser.DeclContext ctx) { return visitChildren(ctx); }
}