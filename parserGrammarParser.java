/*
Elijah Gonzales 725000232
Josiah Hamid-Khani 725003646
Joseph Hernandez 825002632
CSCE 313-505
October 10, 2018
parserGrammarParser.java
*/
// Generated from H:/Java\parserGrammar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class parserGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, Identifier=38, 
		Alpha=39, Digit=40, WS=41;
	public static final int
		RULE_program = 0, RULE_query = 1, RULE_relationName = 2, RULE_expr = 3, 
		RULE_atomicExpr = 4, RULE_selection = 5, RULE_condition = 6, RULE_conjunction = 7, 
		RULE_comparison = 8, RULE_op = 9, RULE_operand = 10, RULE_attributeName = 11, 
		RULE_projection = 12, RULE_attributeList = 13, RULE_renaming = 14, RULE_union = 15, 
		RULE_difference = 16, RULE_product = 17, RULE_command = 18, RULE_closeCmd = 19, 
		RULE_writeCmd = 20, RULE_openCmd = 21, RULE_exitCmd = 22, RULE_showCmd = 23, 
		RULE_createCmd = 24, RULE_updateCmd = 25, RULE_insertCmd = 26, RULE_deleteCmd = 27, 
		RULE_typedAttributeList = 28, RULE_type = 29, RULE_integer = 30, RULE_literal = 31;
	public static final String[] ruleNames = {
		"program", "query", "relationName", "expr", "atomicExpr", "selection", 
		"condition", "conjunction", "comparison", "op", "operand", "attributeName", 
		"projection", "attributeList", "renaming", "union", "difference", "product", 
		"command", "closeCmd", "writeCmd", "openCmd", "exitCmd", "showCmd", "createCmd", 
		"updateCmd", "insertCmd", "deleteCmd", "typedAttributeList", "type", "integer", 
		"literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'<-'", "';'", "'('", "')'", "'select'", "'||'", "'&&'", "'=='", 
		"'!='", "'<'", "'>'", "'<='", "'>='", "'project'", "','", "'rename'", 
		"'+'", "'-'", "'*'", "'CLOSE'", "'WRITE'", "'OPEN'", "'EXIT'", "'SHOW'", 
		"'CREATE TABLE'", "'PRIMARY KEY'", "'UPDATE'", "'SET'", "'='", "'WHERE'", 
		"'INSERT INTO'", "'VALUES FROM'", "'VALUES FROM RELATION'", "'DELETE FROM'", 
		"'VARCHAR'", "'INTEGER'", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "Identifier", "Alpha", "Digit", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "parserGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public parserGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__26) | (1L << T__30) | (1L << T__33) | (1L << Identifier))) != 0)) {
				{
				setState(66);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(64);
					query();
					}
					break;
				case T__19:
				case T__20:
				case T__21:
				case T__22:
				case T__23:
				case T__24:
				case T__26:
				case T__30:
				case T__33:
					{
					setState(65);
					command();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(70);
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

	public static class QueryContext extends ParserRuleContext {
		public RelationNameContext relationName() {
			return getRuleContext(RelationNameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			relationName();
			setState(72);
			match(T__0);
			setState(73);
			expr();
			setState(74);
			match(T__1);
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

	public static class RelationNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(parserGrammarParser.Identifier, 0); }
		public RelationNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterRelationName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitRelationName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitRelationName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationNameContext relationName() throws RecognitionException {
		RelationNameContext _localctx = new RelationNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_relationName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(Identifier);
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
		public AtomicExprContext atomicExpr() {
			return getRuleContext(AtomicExprContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public ProjectionContext projection() {
			return getRuleContext(ProjectionContext.class,0);
		}
		public RenamingContext renaming() {
			return getRuleContext(RenamingContext.class,0);
		}
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public DifferenceContext difference() {
			return getRuleContext(DifferenceContext.class,0);
		}
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				atomicExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				selection();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				projection();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				renaming();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				union();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				difference();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
				product();
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

	public static class AtomicExprContext extends ParserRuleContext {
		public RelationNameContext relationName() {
			return getRuleContext(RelationNameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtomicExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterAtomicExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitAtomicExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitAtomicExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicExprContext atomicExpr() throws RecognitionException {
		AtomicExprContext _localctx = new AtomicExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atomicExpr);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				relationName();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(T__2);
				setState(89);
				expr();
				setState(90);
				match(T__3);
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

	public static class SelectionContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public AtomicExprContext atomicExpr() {
			return getRuleContext(AtomicExprContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__4);
			setState(95);
			match(T__2);
			setState(96);
			condition();
			setState(97);
			match(T__3);
			setState(98);
			atomicExpr();
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

	public static class ConditionContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			conjunction();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(101);
				match(T__5);
				setState(102);
				conjunction();
				}
				}
				setState(107);
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

	public static class ConjunctionContext extends ParserRuleContext {
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			comparison();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(109);
				match(T__6);
				setState(110);
				comparison();
				}
				}
				setState(115);
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comparison);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
			case Identifier:
			case Alpha:
			case Digit:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				operand();
				setState(117);
				op();
				setState(118);
				operand();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(T__2);
				setState(121);
				condition();
				setState(122);
				match(T__3);
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

	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class OperandContext extends ParserRuleContext {
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_operand);
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				attributeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				literal();
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

	public static class AttributeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(parserGrammarParser.Identifier, 0); }
		public AttributeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterAttributeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitAttributeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitAttributeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeNameContext attributeName() throws RecognitionException {
		AttributeNameContext _localctx = new AttributeNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attributeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(Identifier);
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

	public static class ProjectionContext extends ParserRuleContext {
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public AtomicExprContext atomicExpr() {
			return getRuleContext(AtomicExprContext.class,0);
		}
		public ProjectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterProjection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitProjection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitProjection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectionContext projection() throws RecognitionException {
		ProjectionContext _localctx = new ProjectionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_projection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__13);
			setState(135);
			match(T__2);
			setState(136);
			attributeList();
			setState(137);
			match(T__3);
			setState(138);
			atomicExpr();
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

	public static class AttributeListContext extends ParserRuleContext {
		public List<AttributeNameContext> attributeName() {
			return getRuleContexts(AttributeNameContext.class);
		}
		public AttributeNameContext attributeName(int i) {
			return getRuleContext(AttributeNameContext.class,i);
		}
		public AttributeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterAttributeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitAttributeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitAttributeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeListContext attributeList() throws RecognitionException {
		AttributeListContext _localctx = new AttributeListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_attributeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			attributeName();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(141);
				match(T__14);
				setState(142);
				attributeName();
				}
				}
				setState(147);
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

	public static class RenamingContext extends ParserRuleContext {
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public AtomicExprContext atomicExpr() {
			return getRuleContext(AtomicExprContext.class,0);
		}
		public RenamingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_renaming; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterRenaming(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitRenaming(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitRenaming(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RenamingContext renaming() throws RecognitionException {
		RenamingContext _localctx = new RenamingContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_renaming);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__15);
			setState(149);
			match(T__2);
			setState(150);
			attributeList();
			setState(151);
			match(T__3);
			setState(152);
			atomicExpr();
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

	public static class UnionContext extends ParserRuleContext {
		public List<AtomicExprContext> atomicExpr() {
			return getRuleContexts(AtomicExprContext.class);
		}
		public AtomicExprContext atomicExpr(int i) {
			return getRuleContext(AtomicExprContext.class,i);
		}
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			atomicExpr();
			setState(155);
			match(T__16);
			setState(156);
			atomicExpr();
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

	public static class DifferenceContext extends ParserRuleContext {
		public List<AtomicExprContext> atomicExpr() {
			return getRuleContexts(AtomicExprContext.class);
		}
		public AtomicExprContext atomicExpr(int i) {
			return getRuleContext(AtomicExprContext.class,i);
		}
		public DifferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_difference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterDifference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitDifference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitDifference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DifferenceContext difference() throws RecognitionException {
		DifferenceContext _localctx = new DifferenceContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_difference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			atomicExpr();
			setState(159);
			match(T__17);
			setState(160);
			atomicExpr();
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

	public static class ProductContext extends ParserRuleContext {
		public List<AtomicExprContext> atomicExpr() {
			return getRuleContexts(AtomicExprContext.class);
		}
		public AtomicExprContext atomicExpr(int i) {
			return getRuleContext(AtomicExprContext.class,i);
		}
		public ProductContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_product; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterProduct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitProduct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitProduct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProductContext product() throws RecognitionException {
		ProductContext _localctx = new ProductContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_product);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			atomicExpr();
			setState(163);
			match(T__18);
			setState(164);
			atomicExpr();
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

	public static class CommandContext extends ParserRuleContext {
		public OpenCmdContext openCmd() {
			return getRuleContext(OpenCmdContext.class,0);
		}
		public CloseCmdContext closeCmd() {
			return getRuleContext(CloseCmdContext.class,0);
		}
		public WriteCmdContext writeCmd() {
			return getRuleContext(WriteCmdContext.class,0);
		}
		public ExitCmdContext exitCmd() {
			return getRuleContext(ExitCmdContext.class,0);
		}
		public ShowCmdContext showCmd() {
			return getRuleContext(ShowCmdContext.class,0);
		}
		public CreateCmdContext createCmd() {
			return getRuleContext(CreateCmdContext.class,0);
		}
		public UpdateCmdContext updateCmd() {
			return getRuleContext(UpdateCmdContext.class,0);
		}
		public InsertCmdContext insertCmd() {
			return getRuleContext(InsertCmdContext.class,0);
		}
		public DeleteCmdContext deleteCmd() {
			return getRuleContext(DeleteCmdContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				{
				setState(166);
				openCmd();
				}
				break;
			case T__19:
				{
				setState(167);
				closeCmd();
				}
				break;
			case T__20:
				{
				setState(168);
				writeCmd();
				}
				break;
			case T__22:
				{
				setState(169);
				exitCmd();
				}
				break;
			case T__23:
				{
				setState(170);
				showCmd();
				}
				break;
			case T__24:
				{
				setState(171);
				createCmd();
				}
				break;
			case T__26:
				{
				setState(172);
				updateCmd();
				}
				break;
			case T__30:
				{
				setState(173);
				insertCmd();
				}
				break;
			case T__33:
				{
				setState(174);
				deleteCmd();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(177);
			match(T__1);
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

	public static class CloseCmdContext extends ParserRuleContext {
		public RelationNameContext relationName() {
			return getRuleContext(RelationNameContext.class,0);
		}
		public CloseCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closeCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterCloseCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitCloseCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitCloseCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CloseCmdContext closeCmd() throws RecognitionException {
		CloseCmdContext _localctx = new CloseCmdContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_closeCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(T__19);
			setState(180);
			relationName();
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

	public static class WriteCmdContext extends ParserRuleContext {
		public RelationNameContext relationName() {
			return getRuleContext(RelationNameContext.class,0);
		}
		public WriteCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterWriteCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitWriteCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitWriteCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteCmdContext writeCmd() throws RecognitionException {
		WriteCmdContext _localctx = new WriteCmdContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_writeCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__20);
			setState(183);
			relationName();
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

	public static class OpenCmdContext extends ParserRuleContext {
		public RelationNameContext relationName() {
			return getRuleContext(RelationNameContext.class,0);
		}
		public OpenCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterOpenCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitOpenCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitOpenCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpenCmdContext openCmd() throws RecognitionException {
		OpenCmdContext _localctx = new OpenCmdContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_openCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__21);
			setState(186);
			relationName();
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

	public static class ExitCmdContext extends ParserRuleContext {
		public ExitCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exitCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterExitCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitExitCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitExitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExitCmdContext exitCmd() throws RecognitionException {
		ExitCmdContext _localctx = new ExitCmdContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_exitCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__22);
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

	public static class ShowCmdContext extends ParserRuleContext {
		public AtomicExprContext atomicExpr() {
			return getRuleContext(AtomicExprContext.class,0);
		}
		public ShowCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterShowCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitShowCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitShowCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowCmdContext showCmd() throws RecognitionException {
		ShowCmdContext _localctx = new ShowCmdContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_showCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__23);
			setState(191);
			atomicExpr();
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

	public static class CreateCmdContext extends ParserRuleContext {
		public RelationNameContext relationName() {
			return getRuleContext(RelationNameContext.class,0);
		}
		public TypedAttributeListContext typedAttributeList() {
			return getRuleContext(TypedAttributeListContext.class,0);
		}
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public CreateCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterCreateCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitCreateCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitCreateCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateCmdContext createCmd() throws RecognitionException {
		CreateCmdContext _localctx = new CreateCmdContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_createCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(T__24);
			setState(194);
			relationName();
			setState(195);
			match(T__2);
			setState(196);
			typedAttributeList();
			setState(197);
			match(T__3);
			setState(198);
			match(T__25);
			setState(199);
			match(T__2);
			setState(200);
			attributeList();
			setState(201);
			match(T__3);
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

	public static class UpdateCmdContext extends ParserRuleContext {
		public RelationNameContext relationName() {
			return getRuleContext(RelationNameContext.class,0);
		}
		public List<AttributeNameContext> attributeName() {
			return getRuleContexts(AttributeNameContext.class);
		}
		public AttributeNameContext attributeName(int i) {
			return getRuleContext(AttributeNameContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public UpdateCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterUpdateCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitUpdateCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitUpdateCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateCmdContext updateCmd() throws RecognitionException {
		UpdateCmdContext _localctx = new UpdateCmdContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_updateCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__26);
			setState(204);
			relationName();
			setState(205);
			match(T__27);
			setState(206);
			attributeName();
			setState(207);
			match(T__28);
			setState(208);
			literal();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(209);
				match(T__14);
				setState(210);
				attributeName();
				setState(211);
				match(T__28);
				setState(212);
				literal();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(219);
			match(T__29);
			setState(220);
			condition();
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

	public static class InsertCmdContext extends ParserRuleContext {
		public RelationNameContext relationName() {
			return getRuleContext(RelationNameContext.class,0);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InsertCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterInsertCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitInsertCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitInsertCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertCmdContext insertCmd() throws RecognitionException {
		InsertCmdContext _localctx = new InsertCmdContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_insertCmd);
		int _la;
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(T__30);
				setState(223);
				relationName();
				setState(224);
				match(T__31);
				setState(225);
				match(T__2);
				setState(226);
				literal();
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(227);
					match(T__14);
					setState(228);
					literal();
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(234);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(T__30);
				setState(237);
				relationName();
				setState(238);
				match(T__32);
				setState(239);
				expr();
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

	public static class DeleteCmdContext extends ParserRuleContext {
		public RelationNameContext relationName() {
			return getRuleContext(RelationNameContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public DeleteCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterDeleteCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitDeleteCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitDeleteCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteCmdContext deleteCmd() throws RecognitionException {
		DeleteCmdContext _localctx = new DeleteCmdContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_deleteCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(T__33);
			setState(244);
			relationName();
			setState(245);
			match(T__29);
			setState(246);
			condition();
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

	public static class TypedAttributeListContext extends ParserRuleContext {
		public List<AttributeNameContext> attributeName() {
			return getRuleContexts(AttributeNameContext.class);
		}
		public AttributeNameContext attributeName(int i) {
			return getRuleContext(AttributeNameContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypedAttributeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedAttributeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterTypedAttributeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitTypedAttributeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitTypedAttributeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedAttributeListContext typedAttributeList() throws RecognitionException {
		TypedAttributeListContext _localctx = new TypedAttributeListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_typedAttributeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			attributeName();
			setState(249);
			type();
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(250);
				match(T__14);
				setState(251);
				attributeName();
				setState(252);
				type();
				}
				}
				setState(258);
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

	public static class TypeContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_type);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(T__34);
				setState(260);
				match(T__2);
				setState(261);
				integer();
				setState(262);
				match(T__3);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				match(T__35);
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

	public static class IntegerContext extends ParserRuleContext {
		public List<TerminalNode> Digit() { return getTokens(parserGrammarParser.Digit); }
		public TerminalNode Digit(int i) {
			return getToken(parserGrammarParser.Digit, i);
		}
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(Digit);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Digit) {
				{
				{
				setState(268);
				match(Digit);
				}
				}
				setState(273);
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

	public static class LiteralContext extends ParserRuleContext {
		public List<TerminalNode> Alpha() { return getTokens(parserGrammarParser.Alpha); }
		public TerminalNode Alpha(int i) {
			return getToken(parserGrammarParser.Alpha, i);
		}
		public List<TerminalNode> Digit() { return getTokens(parserGrammarParser.Digit); }
		public TerminalNode Digit(int i) {
			return getToken(parserGrammarParser.Digit, i);
		}
		public TerminalNode Identifier() { return getToken(parserGrammarParser.Identifier, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parserGrammarListener ) ((parserGrammarListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parserGrammarVisitor ) return ((parserGrammarVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_literal);
		int _la;
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				_la = _input.LA(1);
				if ( !(_la==Alpha || _la==Digit) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				_la = _input.LA(1);
				if ( !(_la==Alpha || _la==Digit) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Alpha || _la==Digit) {
					{
					{
					setState(276);
					_la = _input.LA(1);
					if ( !(_la==Alpha || _la==Digit) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(281);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(282);
				match(T__36);
				setState(283);
				match(Identifier);
				setState(284);
				match(T__36);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(285);
				match(Identifier);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u0123\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\7\2E\n\2\f\2\16\2H\13\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5X\n\5\3\6\3\6\3\6\3\6\3\6\5\6_\n\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\7\bj\n\b\f\b\16\bm\13\b\3\t\3\t\3\t\7\tr\n"+
		"\t\f\t\16\tu\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\177\n\n\3\13\3\13"+
		"\3\f\3\f\5\f\u0085\n\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\7\17\u0092\n\17\f\17\16\17\u0095\13\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00b2\n\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u00d9\n\33\f\33\16\33\u00dc\13\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u00e8\n\34\f\34"+
		"\16\34\u00eb\13\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00f4\n\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0101\n\36"+
		"\f\36\16\36\u0104\13\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u010c\n\37"+
		"\3 \3 \7 \u0110\n \f \16 \u0113\13 \3!\3!\3!\7!\u0118\n!\f!\16!\u011b"+
		"\13!\3!\3!\3!\3!\5!\u0121\n!\3!\2\2\"\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@\2\4\3\2\n\17\3\2)*\2\u0122\2F\3\2\2\2"+
		"\4I\3\2\2\2\6N\3\2\2\2\bW\3\2\2\2\n^\3\2\2\2\f`\3\2\2\2\16f\3\2\2\2\20"+
		"n\3\2\2\2\22~\3\2\2\2\24\u0080\3\2\2\2\26\u0084\3\2\2\2\30\u0086\3\2\2"+
		"\2\32\u0088\3\2\2\2\34\u008e\3\2\2\2\36\u0096\3\2\2\2 \u009c\3\2\2\2\""+
		"\u00a0\3\2\2\2$\u00a4\3\2\2\2&\u00b1\3\2\2\2(\u00b5\3\2\2\2*\u00b8\3\2"+
		"\2\2,\u00bb\3\2\2\2.\u00be\3\2\2\2\60\u00c0\3\2\2\2\62\u00c3\3\2\2\2\64"+
		"\u00cd\3\2\2\2\66\u00f3\3\2\2\28\u00f5\3\2\2\2:\u00fa\3\2\2\2<\u010b\3"+
		"\2\2\2>\u010d\3\2\2\2@\u0120\3\2\2\2BE\5\4\3\2CE\5&\24\2DB\3\2\2\2DC\3"+
		"\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\3\3\2\2\2HF\3\2\2\2IJ\5\6\4\2JK"+
		"\7\3\2\2KL\5\b\5\2LM\7\4\2\2M\5\3\2\2\2NO\7(\2\2O\7\3\2\2\2PX\5\n\6\2"+
		"QX\5\f\7\2RX\5\32\16\2SX\5\36\20\2TX\5 \21\2UX\5\"\22\2VX\5$\23\2WP\3"+
		"\2\2\2WQ\3\2\2\2WR\3\2\2\2WS\3\2\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2X\t"+
		"\3\2\2\2Y_\5\6\4\2Z[\7\5\2\2[\\\5\b\5\2\\]\7\6\2\2]_\3\2\2\2^Y\3\2\2\2"+
		"^Z\3\2\2\2_\13\3\2\2\2`a\7\7\2\2ab\7\5\2\2bc\5\16\b\2cd\7\6\2\2de\5\n"+
		"\6\2e\r\3\2\2\2fk\5\20\t\2gh\7\b\2\2hj\5\20\t\2ig\3\2\2\2jm\3\2\2\2ki"+
		"\3\2\2\2kl\3\2\2\2l\17\3\2\2\2mk\3\2\2\2ns\5\22\n\2op\7\t\2\2pr\5\22\n"+
		"\2qo\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\21\3\2\2\2us\3\2\2\2vw\5\26"+
		"\f\2wx\5\24\13\2xy\5\26\f\2y\177\3\2\2\2z{\7\5\2\2{|\5\16\b\2|}\7\6\2"+
		"\2}\177\3\2\2\2~v\3\2\2\2~z\3\2\2\2\177\23\3\2\2\2\u0080\u0081\t\2\2\2"+
		"\u0081\25\3\2\2\2\u0082\u0085\5\30\r\2\u0083\u0085\5@!\2\u0084\u0082\3"+
		"\2\2\2\u0084\u0083\3\2\2\2\u0085\27\3\2\2\2\u0086\u0087\7(\2\2\u0087\31"+
		"\3\2\2\2\u0088\u0089\7\20\2\2\u0089\u008a\7\5\2\2\u008a\u008b\5\34\17"+
		"\2\u008b\u008c\7\6\2\2\u008c\u008d\5\n\6\2\u008d\33\3\2\2\2\u008e\u0093"+
		"\5\30\r\2\u008f\u0090\7\21\2\2\u0090\u0092\5\30\r\2\u0091\u008f\3\2\2"+
		"\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\35"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\22\2\2\u0097\u0098\7\5\2\2"+
		"\u0098\u0099\5\34\17\2\u0099\u009a\7\6\2\2\u009a\u009b\5\n\6\2\u009b\37"+
		"\3\2\2\2\u009c\u009d\5\n\6\2\u009d\u009e\7\23\2\2\u009e\u009f\5\n\6\2"+
		"\u009f!\3\2\2\2\u00a0\u00a1\5\n\6\2\u00a1\u00a2\7\24\2\2\u00a2\u00a3\5"+
		"\n\6\2\u00a3#\3\2\2\2\u00a4\u00a5\5\n\6\2\u00a5\u00a6\7\25\2\2\u00a6\u00a7"+
		"\5\n\6\2\u00a7%\3\2\2\2\u00a8\u00b2\5,\27\2\u00a9\u00b2\5(\25\2\u00aa"+
		"\u00b2\5*\26\2\u00ab\u00b2\5.\30\2\u00ac\u00b2\5\60\31\2\u00ad\u00b2\5"+
		"\62\32\2\u00ae\u00b2\5\64\33\2\u00af\u00b2\5\66\34\2\u00b0\u00b2\58\35"+
		"\2\u00b1\u00a8\3\2\2\2\u00b1\u00a9\3\2\2\2\u00b1\u00aa\3\2\2\2\u00b1\u00ab"+
		"\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\4"+
		"\2\2\u00b4\'\3\2\2\2\u00b5\u00b6\7\26\2\2\u00b6\u00b7\5\6\4\2\u00b7)\3"+
		"\2\2\2\u00b8\u00b9\7\27\2\2\u00b9\u00ba\5\6\4\2\u00ba+\3\2\2\2\u00bb\u00bc"+
		"\7\30\2\2\u00bc\u00bd\5\6\4\2\u00bd-\3\2\2\2\u00be\u00bf\7\31\2\2\u00bf"+
		"/\3\2\2\2\u00c0\u00c1\7\32\2\2\u00c1\u00c2\5\n\6\2\u00c2\61\3\2\2\2\u00c3"+
		"\u00c4\7\33\2\2\u00c4\u00c5\5\6\4\2\u00c5\u00c6\7\5\2\2\u00c6\u00c7\5"+
		":\36\2\u00c7\u00c8\7\6\2\2\u00c8\u00c9\7\34\2\2\u00c9\u00ca\7\5\2\2\u00ca"+
		"\u00cb\5\34\17\2\u00cb\u00cc\7\6\2\2\u00cc\63\3\2\2\2\u00cd\u00ce\7\35"+
		"\2\2\u00ce\u00cf\5\6\4\2\u00cf\u00d0\7\36\2\2\u00d0\u00d1\5\30\r\2\u00d1"+
		"\u00d2\7\37\2\2\u00d2\u00da\5@!\2\u00d3\u00d4\7\21\2\2\u00d4\u00d5\5\30"+
		"\r\2\u00d5\u00d6\7\37\2\2\u00d6\u00d7\5@!\2\u00d7\u00d9\3\2\2\2\u00d8"+
		"\u00d3\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7 \2\2\u00de"+
		"\u00df\5\16\b\2\u00df\65\3\2\2\2\u00e0\u00e1\7!\2\2\u00e1\u00e2\5\6\4"+
		"\2\u00e2\u00e3\7\"\2\2\u00e3\u00e4\7\5\2\2\u00e4\u00e9\5@!\2\u00e5\u00e6"+
		"\7\21\2\2\u00e6\u00e8\5@!\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00ec\u00ed\7\6\2\2\u00ed\u00f4\3\2\2\2\u00ee\u00ef\7!\2\2\u00ef"+
		"\u00f0\5\6\4\2\u00f0\u00f1\7#\2\2\u00f1\u00f2\5\b\5\2\u00f2\u00f4\3\2"+
		"\2\2\u00f3\u00e0\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f4\67\3\2\2\2\u00f5\u00f6"+
		"\7$\2\2\u00f6\u00f7\5\6\4\2\u00f7\u00f8\7 \2\2\u00f8\u00f9\5\16\b\2\u00f9"+
		"9\3\2\2\2\u00fa\u00fb\5\30\r\2\u00fb\u0102\5<\37\2\u00fc\u00fd\7\21\2"+
		"\2\u00fd\u00fe\5\30\r\2\u00fe\u00ff\5<\37\2\u00ff\u0101\3\2\2\2\u0100"+
		"\u00fc\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103;\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7%\2\2\u0106\u0107"+
		"\7\5\2\2\u0107\u0108\5> \2\u0108\u0109\7\6\2\2\u0109\u010c\3\2\2\2\u010a"+
		"\u010c\7&\2\2\u010b\u0105\3\2\2\2\u010b\u010a\3\2\2\2\u010c=\3\2\2\2\u010d"+
		"\u0111\7*\2\2\u010e\u0110\7*\2\2\u010f\u010e\3\2\2\2\u0110\u0113\3\2\2"+
		"\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112?\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\u0114\u0121\t\3\2\2\u0115\u0119\t\3\2\2\u0116\u0118\t\3\2\2\u0117"+
		"\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\u0121\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011d\7\'\2\2\u011d"+
		"\u011e\7(\2\2\u011e\u0121\7\'\2\2\u011f\u0121\7(\2\2\u0120\u0114\3\2\2"+
		"\2\u0120\u0115\3\2\2\2\u0120\u011c\3\2\2\2\u0120\u011f\3\2\2\2\u0121A"+
		"\3\2\2\2\24DFW^ks~\u0084\u0093\u00b1\u00da\u00e9\u00f3\u0102\u010b\u0111"+
		"\u0119\u0120";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
