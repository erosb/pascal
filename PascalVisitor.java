// Generated from Pascal.g4 by ANTLR 4.0
package pascal.parsers;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface PascalVisitor<T> extends ParseTreeVisitor<T> {
	T visitRet(PascalParser.RetContext ctx);

	T visitCall(PascalParser.CallContext ctx);

	T visitAssign(PascalParser.AssignContext ctx);

	T visitParens(PascalParser.ParensContext ctx);

	T visitIfStruct(PascalParser.IfStructContext ctx);

	T visitArgList(PascalParser.ArgListContext ctx);

	T visitLiteral(PascalParser.LiteralContext ctx);

	T visitAddSub(PascalParser.AddSubContext ctx);

	T visitVarDecl(PascalParser.VarDeclContext ctx);

	T visitStmt(PascalParser.StmtContext ctx);

	T visitLoopStruct(PascalParser.LoopStructContext ctx);

	T visitBlock(PascalParser.BlockContext ctx);

	T visitVarRef(PascalParser.VarRefContext ctx);

	T visitFunctionCall(PascalParser.FunctionCallContext ctx);

	T visitFunction(PascalParser.FunctionContext ctx);

	T visitFormPar(PascalParser.FormParContext ctx);

	T visitCtrlStruct(PascalParser.CtrlStructContext ctx);

	T visitDivMul(PascalParser.DivMulContext ctx);

	T visitProgram(PascalParser.ProgramContext ctx);

	T visitPredicate(PascalParser.PredicateContext ctx);

	T visitFormParList(PascalParser.FormParListContext ctx);

	T visitDecl(PascalParser.DeclContext ctx);
}