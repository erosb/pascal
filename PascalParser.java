// Generated from Pascal.g4 by ANTLR 4.0
package pascal.parsers;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		LITERAL=17, IF=18, THEN=19, DO=20, WHILE=21, LOOP=22, RETURN=23, WS=24, 
		BEGIN=25, END=26, LET=27, ID=28, INT=29, STRING=30, BOOLEAN=31;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "','", "'+'", "'-'", "'*'", "'('", "':'", "'<'", "'program'", 
		"'='", "';'", "'<='", "'var'", "'>'", "'/'", "'>='", "LITERAL", "'if'", 
		"'then'", "'do'", "'while'", "'loop'", "'return'", "WS", "'begin'", "'end'", 
		"':='", "ID", "INT", "STRING", "BOOLEAN"
	};
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_stmt = 2, RULE_assign = 3, RULE_call = 4, 
		RULE_expr = 5, RULE_argList = 6, RULE_decl = 7, RULE_varDecl = 8, RULE_ctrlStruct = 9, 
		RULE_ifStruct = 10, RULE_loopStruct = 11, RULE_ret = 12, RULE_function = 13, 
		RULE_formParList = 14, RULE_formPar = 15;
	public static final String[] ruleNames = {
		"program", "block", "stmt", "assign", "call", "expr", "argList", "decl", 
		"varDecl", "ctrlStruct", "ifStruct", "loopStruct", "ret", "function", 
		"formParList", "formPar"
	};

	@Override
	public String getGrammarFileName() { return "Pascal.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public PascalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); match(9);
			setState(33); match(ID);
			setState(34); decl();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(35); function();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41); block();
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(42); function();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public TerminalNode END() { return getToken(PascalParser.END, 0); }
		public TerminalNode BEGIN() { return getToken(PascalParser.BEGIN, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(BEGIN);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << DO) | (1L << RETURN) | (1L << ID))) != 0)) {
				{
				{
				setState(49); stmt();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public CtrlStructContext ctrlStruct() {
			return getRuleContext(CtrlStructContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57); assign();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58); call();
				setState(59); match(11);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61); ret();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(62); ctrlStruct();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LET() { return getToken(PascalParser.LET, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(ID);
			setState(66); match(LET);
			setState(67); expr(0);
			setState(68); match(11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); match(ID);
			setState(71); match(6);
			setState(72); argList();
			setState(73); match(1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralContext extends ExprContext {
		public TerminalNode LITERAL() { return getToken(PascalParser.LITERAL, 0); }
		public LiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivMulContext extends ExprContext {
		public Token op;
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public DivMulContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitDivMul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public Token op;
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PredicateContext extends ExprContext {
		public Token op;
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public PredicateContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarRefContext extends ExprContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public VarRefContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitVarRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends ExprContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public FunctionCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(76); call();
				}
				break;

			case 2:
				{
				_localctx = new VarRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77); match(ID);
				}
				break;

			case 3:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78); match(LITERAL);
				}
				break;

			case 4:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79); match(6);
				setState(80); expr(0);
				setState(81); match(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(94);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new DivMulContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(85);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(86);
						((DivMulContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==5 || _la==15) ) {
							((DivMulContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(87); expr(8);
						}
						break;

					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(88);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(89);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==3 || _la==4) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(90); expr(7);
						}
						break;

					case 3:
						{
						_localctx = new PredicateContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(91);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(92);
						((PredicateContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 8) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 16))) != 0)) ) {
							((PredicateContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(93); expr(6);
						}
						break;
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << LITERAL) | (1L << ID))) != 0)) {
				{
				setState(99); expr(0);
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(100); match(2);
					setState(101); expr(0);
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); match(13);
			setState(110); varDecl();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(111); match(2);
				setState(112); varDecl();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118); match(11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public Token varName;
		public Token type;
		public TerminalNode ID(int i) {
			return getToken(PascalParser.ID, i);
		}
		public List<TerminalNode> ID() { return getTokens(PascalParser.ID); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); ((VarDeclContext)_localctx).varName = match(ID);
			setState(121); match(7);
			setState(122); ((VarDeclContext)_localctx).type = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtrlStructContext extends ParserRuleContext {
		public IfStructContext ifStruct() {
			return getRuleContext(IfStructContext.class,0);
		}
		public LoopStructContext loopStruct() {
			return getRuleContext(LoopStructContext.class,0);
		}
		public CtrlStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctrlStruct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitCtrlStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtrlStructContext ctrlStruct() throws RecognitionException {
		CtrlStructContext _localctx = new CtrlStructContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ctrlStruct);
		try {
			setState(126);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(124); ifStruct();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 2);
				{
				setState(125); loopStruct();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStructContext extends ParserRuleContext {
		public TerminalNode THEN() { return getToken(PascalParser.THEN, 0); }
		public TerminalNode IF(int i) {
			return getToken(PascalParser.IF, i);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public TerminalNode END() { return getToken(PascalParser.END, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> IF() { return getTokens(PascalParser.IF); }
		public IfStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStruct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitIfStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStructContext ifStruct() throws RecognitionException {
		IfStructContext _localctx = new IfStructContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifStruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(IF);
			setState(129); expr(0);
			setState(130); match(THEN);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << DO) | (1L << RETURN) | (1L << ID))) != 0)) {
				{
				{
				setState(131); stmt();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137); match(END);
			setState(138); match(IF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopStructContext extends ParserRuleContext {
		public ExprContext preCond;
		public ExprContext postCond;
		public TerminalNode DO() { return getToken(PascalParser.DO, 0); }
		public List<TerminalNode> WHILE() { return getTokens(PascalParser.WHILE); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode WHILE(int i) {
			return getToken(PascalParser.WHILE, i);
		}
		public TerminalNode LOOP() { return getToken(PascalParser.LOOP, 0); }
		public LoopStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStruct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitLoopStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStructContext loopStruct() throws RecognitionException {
		LoopStructContext _localctx = new LoopStructContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_loopStruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140); match(DO);
			setState(143);
			_la = _input.LA(1);
			if (_la==WHILE) {
				{
				setState(141); match(WHILE);
				setState(142); ((LoopStructContext)_localctx).preCond = expr(0);
				}
			}

			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << DO) | (1L << RETURN) | (1L << ID))) != 0)) {
				{
				{
				setState(145); stmt();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151); match(LOOP);
			setState(154);
			_la = _input.LA(1);
			if (_la==WHILE) {
				{
				setState(152); match(WHILE);
				setState(153); ((LoopStructContext)_localctx).postCond = expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(PascalParser.RETURN, 0); }
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ret);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); match(RETURN);
			setState(158);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << LITERAL) | (1L << ID))) != 0)) {
				{
				setState(157); expr(0);
				}
			}

			setState(160); match(11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public Token retType;
		public Token fnName;
		public TerminalNode ID(int i) {
			return getToken(PascalParser.ID, i);
		}
		public List<TerminalNode> ID() { return getTokens(PascalParser.ID); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FormParListContext formParList() {
			return getRuleContext(FormParListContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); ((FunctionContext)_localctx).retType = match(ID);
			setState(163); ((FunctionContext)_localctx).fnName = match(ID);
			setState(164); formParList();
			setState(166);
			_la = _input.LA(1);
			if (_la==13) {
				{
				setState(165); decl();
				}
			}

			setState(168); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormParListContext extends ParserRuleContext {
		public List<FormParContext> formPar() {
			return getRuleContexts(FormParContext.class);
		}
		public FormParContext formPar(int i) {
			return getRuleContext(FormParContext.class,i);
		}
		public FormParListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formParList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFormParList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormParListContext formParList() throws RecognitionException {
		FormParListContext _localctx = new FormParListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_formParList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170); match(6);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(171); formPar();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177); match(1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormParContext extends ParserRuleContext {
		public Token type;
		public Token name;
		public ExprContext defaultVal;
		public TerminalNode ID(int i) {
			return getToken(PascalParser.ID, i);
		}
		public List<TerminalNode> ID() { return getTokens(PascalParser.ID); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LET() { return getToken(PascalParser.LET, 0); }
		public FormParContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formPar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFormPar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormParContext formPar() throws RecognitionException {
		FormParContext _localctx = new FormParContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_formPar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); ((FormParContext)_localctx).type = match(ID);
			setState(180); ((FormParContext)_localctx).name = match(ID);
			setState(183);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(181); match(LET);
				setState(182); ((FormParContext)_localctx).defaultVal = expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 7 >= _localctx._p;

		case 1: return 6 >= _localctx._p;

		case 2: return 5 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3!\u00bc\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\3\2\3\2\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\7\2.\n\2\f"+
		"\2\16\2\61\13\2\3\3\3\3\7\3\65\n\3\f\3\16\38\13\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4B\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7V\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\7\7a\n\7\f\7\16\7d\13\7\3\b\3\b\3\b\7\bi\n\b\f\b\16\bl\13\b\5\bn\n\b"+
		"\3\t\3\t\3\t\3\t\7\tt\n\t\f\t\16\tw\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\5\13\u0081\n\13\3\f\3\f\3\f\3\f\7\f\u0087\n\f\f\f\16\f\u008a\13"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u0092\n\r\3\r\7\r\u0095\n\r\f\r\16\r\u0098"+
		"\13\r\3\r\3\r\3\r\5\r\u009d\n\r\3\16\3\16\5\16\u00a1\n\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\5\17\u00a9\n\17\3\17\3\17\3\20\3\20\7\20\u00af\n\20"+
		"\f\20\16\20\u00b2\13\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u00ba\n\21"+
		"\3\21\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\5\4\7\7\21\21\3\5"+
		"\6\7\n\n\f\f\16\16\20\20\22\22\u00c3\2\"\3\2\2\2\4\62\3\2\2\2\6A\3\2\2"+
		"\2\bC\3\2\2\2\nH\3\2\2\2\fU\3\2\2\2\16m\3\2\2\2\20o\3\2\2\2\22z\3\2\2"+
		"\2\24\u0080\3\2\2\2\26\u0082\3\2\2\2\30\u008e\3\2\2\2\32\u009e\3\2\2\2"+
		"\34\u00a4\3\2\2\2\36\u00ac\3\2\2\2 \u00b5\3\2\2\2\"#\7\13\2\2#$\7\36\2"+
		"\2$(\5\20\t\2%\'\5\34\17\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+"+
		"\3\2\2\2*(\3\2\2\2+/\5\4\3\2,.\5\34\17\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2"+
		"\2/\60\3\2\2\2\60\3\3\2\2\2\61/\3\2\2\2\62\66\7\33\2\2\63\65\5\6\4\2\64"+
		"\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3"+
		"\2\2\29:\7\34\2\2:\5\3\2\2\2;B\5\b\5\2<=\5\n\6\2=>\7\r\2\2>B\3\2\2\2?"+
		"B\5\32\16\2@B\5\24\13\2A;\3\2\2\2A<\3\2\2\2A?\3\2\2\2A@\3\2\2\2B\7\3\2"+
		"\2\2CD\7\36\2\2DE\7\35\2\2EF\5\f\7\2FG\7\r\2\2G\t\3\2\2\2HI\7\36\2\2I"+
		"J\7\b\2\2JK\5\16\b\2KL\7\3\2\2L\13\3\2\2\2MN\b\7\1\2NV\5\n\6\2OV\7\36"+
		"\2\2PV\7\23\2\2QR\7\b\2\2RS\5\f\7\2ST\7\3\2\2TV\3\2\2\2UM\3\2\2\2UO\3"+
		"\2\2\2UP\3\2\2\2UQ\3\2\2\2Vb\3\2\2\2WX\6\7\2\3XY\t\2\2\2Ya\5\f\7\2Z[\6"+
		"\7\3\3[\\\t\3\2\2\\a\5\f\7\2]^\6\7\4\3^_\t\4\2\2_a\5\f\7\2`W\3\2\2\2`"+
		"Z\3\2\2\2`]\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\r\3\2\2\2db\3\2\2\2"+
		"ej\5\f\7\2fg\7\4\2\2gi\5\f\7\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2"+
		"kn\3\2\2\2lj\3\2\2\2me\3\2\2\2mn\3\2\2\2n\17\3\2\2\2op\7\17\2\2pu\5\22"+
		"\n\2qr\7\4\2\2rt\5\22\n\2sq\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3"+
		"\2\2\2wu\3\2\2\2xy\7\r\2\2y\21\3\2\2\2z{\7\36\2\2{|\7\t\2\2|}\7\36\2\2"+
		"}\23\3\2\2\2~\u0081\5\26\f\2\177\u0081\5\30\r\2\u0080~\3\2\2\2\u0080\177"+
		"\3\2\2\2\u0081\25\3\2\2\2\u0082\u0083\7\24\2\2\u0083\u0084\5\f\7\2\u0084"+
		"\u0088\7\25\2\2\u0085\u0087\5\6\4\2\u0086\u0085\3\2\2\2\u0087\u008a\3"+
		"\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008b\u008c\7\34\2\2\u008c\u008d\7\24\2\2\u008d\27\3\2"+
		"\2\2\u008e\u0091\7\26\2\2\u008f\u0090\7\27\2\2\u0090\u0092\5\f\7\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0096\3\2\2\2\u0093\u0095\5\6"+
		"\4\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009c\7\30"+
		"\2\2\u009a\u009b\7\27\2\2\u009b\u009d\5\f\7\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\31\3\2\2\2\u009e\u00a0\7\31\2\2\u009f\u00a1\5\f\7"+
		"\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3"+
		"\7\r\2\2\u00a3\33\3\2\2\2\u00a4\u00a5\7\36\2\2\u00a5\u00a6\7\36\2\2\u00a6"+
		"\u00a8\5\36\20\2\u00a7\u00a9\5\20\t\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9"+
		"\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\5\4\3\2\u00ab\35\3\2\2\2\u00ac"+
		"\u00b0\7\b\2\2\u00ad\u00af\5 \21\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2"+
		"\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00b4\7\3\2\2\u00b4\37\3\2\2\2\u00b5\u00b6\7\36\2"+
		"\2\u00b6\u00b9\7\36\2\2\u00b7\u00b8\7\35\2\2\u00b8\u00ba\5\f\7\2\u00b9"+
		"\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba!\3\2\2\2\25(/\66AU`bjmu\u0080"+
		"\u0088\u0091\u0096\u009c\u00a0\u00a8\u00b0\u00b9";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}