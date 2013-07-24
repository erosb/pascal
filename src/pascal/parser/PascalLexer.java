// Generated from Pascal.g4 by ANTLR 4.0
package pascal.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		LITERAL=17, IF=18, THEN=19, DO=20, WHILE=21, LOOP=22, RETURN=23, WS=24, 
		BEGIN=25, END=26, LET=27, ID=28, INT=29, STRING=30, BOOLEAN=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "','", "'+'", "'-'", "'*'", "'('", "':'", "'<'", "'program'", "'='", 
		"';'", "'<='", "'var'", "'>'", "'/'", "'>='", "LITERAL", "'if'", "'then'", 
		"'do'", "'while'", "'loop'", "'return'", "WS", "'begin'", "'end'", "':='", 
		"ID", "INT", "STRING", "BOOLEAN"
	};
	public static final String[] ruleNames = {
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "LITERAL", 
		"IF", "THEN", "DO", "WHILE", "LOOP", "RETURN", "WS", "BEGIN", "END", "LET", 
		"ID", "INT", "STRING", "BOOLEAN"
	};


	public PascalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pascal.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 23: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4!\u00c4\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\5\22o\n\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\6\31\u008f\n\31\r\31\16\31\u0090\3\31\3"+
		"\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\35\3\35\7\35\u00a4\n\35\f\35\16\35\u00a7\13\35\3\36\5\36\u00aa\n\36\3"+
		"\36\6\36\u00ad\n\36\r\36\16\36\u00ae\3\37\3\37\7\37\u00b3\n\37\f\37\16"+
		"\37\u00b6\13\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u00c3\n \3\u00b4"+
		"!\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27"+
		"\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27"+
		"\1-\30\1/\31\1\61\32\2\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1\3\2"+
		"\6\5\13\f\17\17\"\"\5C\\aac|\6\62;C\\aac|\3\62;\u00cb\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\r"+
		"K\3\2\2\2\17M\3\2\2\2\21O\3\2\2\2\23Q\3\2\2\2\25Y\3\2\2\2\27[\3\2\2\2"+
		"\31]\3\2\2\2\33`\3\2\2\2\35d\3\2\2\2\37f\3\2\2\2!h\3\2\2\2#n\3\2\2\2%"+
		"p\3\2\2\2\'s\3\2\2\2)x\3\2\2\2+{\3\2\2\2-\u0081\3\2\2\2/\u0086\3\2\2\2"+
		"\61\u008e\3\2\2\2\63\u0094\3\2\2\2\65\u009a\3\2\2\2\67\u009e\3\2\2\29"+
		"\u00a1\3\2\2\2;\u00a9\3\2\2\2=\u00b0\3\2\2\2?\u00c2\3\2\2\2AB\7+\2\2B"+
		"\4\3\2\2\2CD\7.\2\2D\6\3\2\2\2EF\7-\2\2F\b\3\2\2\2GH\7/\2\2H\n\3\2\2\2"+
		"IJ\7,\2\2J\f\3\2\2\2KL\7*\2\2L\16\3\2\2\2MN\7<\2\2N\20\3\2\2\2OP\7>\2"+
		"\2P\22\3\2\2\2QR\7r\2\2RS\7t\2\2ST\7q\2\2TU\7i\2\2UV\7t\2\2VW\7c\2\2W"+
		"X\7o\2\2X\24\3\2\2\2YZ\7?\2\2Z\26\3\2\2\2[\\\7=\2\2\\\30\3\2\2\2]^\7>"+
		"\2\2^_\7?\2\2_\32\3\2\2\2`a\7x\2\2ab\7c\2\2bc\7t\2\2c\34\3\2\2\2de\7@"+
		"\2\2e\36\3\2\2\2fg\7\61\2\2g \3\2\2\2hi\7@\2\2ij\7?\2\2j\"\3\2\2\2ko\5"+
		";\36\2lo\5=\37\2mo\5? \2nk\3\2\2\2nl\3\2\2\2nm\3\2\2\2o$\3\2\2\2pq\7k"+
		"\2\2qr\7h\2\2r&\3\2\2\2st\7v\2\2tu\7j\2\2uv\7g\2\2vw\7p\2\2w(\3\2\2\2"+
		"xy\7f\2\2yz\7q\2\2z*\3\2\2\2{|\7y\2\2|}\7j\2\2}~\7k\2\2~\177\7n\2\2\177"+
		"\u0080\7g\2\2\u0080,\3\2\2\2\u0081\u0082\7n\2\2\u0082\u0083\7q\2\2\u0083"+
		"\u0084\7q\2\2\u0084\u0085\7r\2\2\u0085.\3\2\2\2\u0086\u0087\7t\2\2\u0087"+
		"\u0088\7g\2\2\u0088\u0089\7v\2\2\u0089\u008a\7w\2\2\u008a\u008b\7t\2\2"+
		"\u008b\u008c\7p\2\2\u008c\60\3\2\2\2\u008d\u008f\t\2\2\2\u008e\u008d\3"+
		"\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\b\31\2\2\u0093\62\3\2\2\2\u0094\u0095\7d\2"+
		"\2\u0095\u0096\7g\2\2\u0096\u0097\7i\2\2\u0097\u0098\7k\2\2\u0098\u0099"+
		"\7p\2\2\u0099\64\3\2\2\2\u009a\u009b\7g\2\2\u009b\u009c\7p\2\2\u009c\u009d"+
		"\7f\2\2\u009d\66\3\2\2\2\u009e\u009f\7<\2\2\u009f\u00a0\7?\2\2\u00a08"+
		"\3\2\2\2\u00a1\u00a5\t\3\2\2\u00a2\u00a4\t\4\2\2\u00a3\u00a2\3\2\2\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6:\3\2\2\2"+
		"\u00a7\u00a5\3\2\2\2\u00a8\u00aa\7/\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00ad\t\5\2\2\u00ac\u00ab\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af<\3\2\2\2"+
		"\u00b0\u00b4\7$\2\2\u00b1\u00b3\13\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b7\u00b8\7$\2\2\u00b8>\3\2\2\2\u00b9\u00ba\7v\2\2\u00ba"+
		"\u00bb\7t\2\2\u00bb\u00bc\7w\2\2\u00bc\u00c3\7g\2\2\u00bd\u00be\7h\2\2"+
		"\u00be\u00bf\7c\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c3"+
		"\7g\2\2\u00c2\u00b9\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c3@\3\2\2\2\n\2n\u0090"+
		"\u00a5\u00a9\u00ae\u00b4\u00c2";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}