package pascal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import pascal.parser.PascalBaseVisitor;
import pascal.parser.PascalParser.AssignContext;
import pascal.parser.PascalParser.BlockContext;
import pascal.parser.PascalParser.CallContext;
import pascal.parser.PascalParser.ExprContext;
import pascal.parser.PascalParser.FunctionCallContext;
import pascal.parser.PascalParser.StmtContext;
import pascal.parser.PascalParser.VarRefContext;

public class OptimizerVisitor extends PascalBaseVisitor<Void> {

    private static class RemovalMarker {

        private final AssignContext assignCtx;

        private final ParserRuleContext parentCtx;

        public RemovalMarker(final AssignContext assignCtx, final ParserRuleContext parentCtx) {
            super();
            this.assignCtx = assignCtx;
            this.parentCtx = parentCtx;
        }

        public AssignContext getAssignCtx() {
            return assignCtx;
        }

        public ParserRuleContext getParentCtx() {
            return parentCtx;
        }

    }

    private Map<String, RemovalMarker> unreadWrites;

    @Override
    public Void visitAssign(final AssignContext ctx) {
        unreadWrites.put(ctx.ID().getText(), new RemovalMarker(ctx, ctx.getParent()));
        return super.visitAssign(ctx);
    }

    @Override
    public Void visitBlock(final BlockContext ctx) {
        unreadWrites = new HashMap<String, RemovalMarker>();
        super.visitBlock(ctx);
        for (String unreadAssignVar : unreadWrites.keySet()) {
            RemovalMarker marker = unreadWrites.get(unreadAssignVar);
            AssignContext assignCtx = marker.getAssignCtx();
            List<ParseTree> childList = marker.getParentCtx().children;
            int assignIdx = childList.indexOf(assignCtx);
            childList.remove(assignCtx);
            ExprContext rval = assignCtx.expr();
            if (rval instanceof FunctionCallContext) {
                FunctionCallContext call = (FunctionCallContext) rval;
                StmtContext stmtCtx = new StmtContext(ctx, 0);
                CallContext callContext = new CallContext(marker.getParentCtx(), 0);
                callContext.addChild(call);
                stmtCtx.addChild(callContext);
                childList.add(assignIdx, stmtCtx);
                System.out.println(marker.getParentCtx().getParent().getText());
            }
        }
        return null;
    }

    @Override
    public Void visitVarRef(final VarRefContext ctx) {
        unreadWrites.remove(ctx.ID().getText());
        return super.visitVarRef(ctx);
    }

}
