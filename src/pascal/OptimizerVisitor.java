package pascal;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

import pascal.parser.PascalBaseVisitor;
import pascal.parser.PascalParser.AssignContext;
import pascal.parser.PascalParser.BlockContext;
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
        System.out.println("assign: " + ctx.ID().getText());
        unreadWrites.put(ctx.ID().getText(), new RemovalMarker(ctx, ctx.getParent()));
        return super.visitAssign(ctx);
    }

    @Override
    public Void visitBlock(final BlockContext ctx) {
        unreadWrites = new HashMap<String, RemovalMarker>();
        super.visitBlock(ctx);
        for (String unreadAssignVar : unreadWrites.keySet()) {
            RemovalMarker parent = unreadWrites.get(unreadAssignVar);
            System.out.println("removing " + unreadAssignVar + "? "
                    + parent.getParentCtx().children.remove(parent.getAssignCtx()));
        }
        return null;
    }

    @Override
    public Void visitVarRef(final VarRefContext ctx) {
        unreadWrites.remove(ctx.ID().getText());
        return super.visitVarRef(ctx);
    }

}
