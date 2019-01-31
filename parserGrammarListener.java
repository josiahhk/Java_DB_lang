/*
Elijah Gonzales 725000232
Josiah Hamid-Khani 725003646
Joseph Hernandez 825002632
CSCE 313-505
October 10, 2018
paserGrammarListener.java
*/

// Generated from H:/Java\parserGrammar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link parserGrammarParser}.
 */
public interface parserGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(parserGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(parserGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(parserGrammarParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(parserGrammarParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#relationName}.
	 * @param ctx the parse tree
	 */
	void enterRelationName(parserGrammarParser.RelationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#relationName}.
	 * @param ctx the parse tree
	 */
	void exitRelationName(parserGrammarParser.RelationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(parserGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(parserGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#atomicExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomicExpr(parserGrammarParser.AtomicExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#atomicExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomicExpr(parserGrammarParser.AtomicExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(parserGrammarParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(parserGrammarParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(parserGrammarParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(parserGrammarParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(parserGrammarParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(parserGrammarParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(parserGrammarParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(parserGrammarParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(parserGrammarParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(parserGrammarParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(parserGrammarParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(parserGrammarParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#attributeName}.
	 * @param ctx the parse tree
	 */
	void enterAttributeName(parserGrammarParser.AttributeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#attributeName}.
	 * @param ctx the parse tree
	 */
	void exitAttributeName(parserGrammarParser.AttributeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#projection}.
	 * @param ctx the parse tree
	 */
	void enterProjection(parserGrammarParser.ProjectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#projection}.
	 * @param ctx the parse tree
	 */
	void exitProjection(parserGrammarParser.ProjectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void enterAttributeList(parserGrammarParser.AttributeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void exitAttributeList(parserGrammarParser.AttributeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#renaming}.
	 * @param ctx the parse tree
	 */
	void enterRenaming(parserGrammarParser.RenamingContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#renaming}.
	 * @param ctx the parse tree
	 */
	void exitRenaming(parserGrammarParser.RenamingContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnion(parserGrammarParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnion(parserGrammarParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#difference}.
	 * @param ctx the parse tree
	 */
	void enterDifference(parserGrammarParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#difference}.
	 * @param ctx the parse tree
	 */
	void exitDifference(parserGrammarParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#product}.
	 * @param ctx the parse tree
	 */
	void enterProduct(parserGrammarParser.ProductContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#product}.
	 * @param ctx the parse tree
	 */
	void exitProduct(parserGrammarParser.ProductContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(parserGrammarParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(parserGrammarParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#closeCmd}.
	 * @param ctx the parse tree
	 */
	void enterCloseCmd(parserGrammarParser.CloseCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#closeCmd}.
	 * @param ctx the parse tree
	 */
	void exitCloseCmd(parserGrammarParser.CloseCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#writeCmd}.
	 * @param ctx the parse tree
	 */
	void enterWriteCmd(parserGrammarParser.WriteCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#writeCmd}.
	 * @param ctx the parse tree
	 */
	void exitWriteCmd(parserGrammarParser.WriteCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#openCmd}.
	 * @param ctx the parse tree
	 */
	void enterOpenCmd(parserGrammarParser.OpenCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#openCmd}.
	 * @param ctx the parse tree
	 */
	void exitOpenCmd(parserGrammarParser.OpenCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#exitCmd}.
	 * @param ctx the parse tree
	 */
	void enterExitCmd(parserGrammarParser.ExitCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#exitCmd}.
	 * @param ctx the parse tree
	 */
	void exitExitCmd(parserGrammarParser.ExitCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#showCmd}.
	 * @param ctx the parse tree
	 */
	void enterShowCmd(parserGrammarParser.ShowCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#showCmd}.
	 * @param ctx the parse tree
	 */
	void exitShowCmd(parserGrammarParser.ShowCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#createCmd}.
	 * @param ctx the parse tree
	 */
	void enterCreateCmd(parserGrammarParser.CreateCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#createCmd}.
	 * @param ctx the parse tree
	 */
	void exitCreateCmd(parserGrammarParser.CreateCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#updateCmd}.
	 * @param ctx the parse tree
	 */
	void enterUpdateCmd(parserGrammarParser.UpdateCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#updateCmd}.
	 * @param ctx the parse tree
	 */
	void exitUpdateCmd(parserGrammarParser.UpdateCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#insertCmd}.
	 * @param ctx the parse tree
	 */
	void enterInsertCmd(parserGrammarParser.InsertCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#insertCmd}.
	 * @param ctx the parse tree
	 */
	void exitInsertCmd(parserGrammarParser.InsertCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#deleteCmd}.
	 * @param ctx the parse tree
	 */
	void enterDeleteCmd(parserGrammarParser.DeleteCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#deleteCmd}.
	 * @param ctx the parse tree
	 */
	void exitDeleteCmd(parserGrammarParser.DeleteCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#typedAttributeList}.
	 * @param ctx the parse tree
	 */
	void enterTypedAttributeList(parserGrammarParser.TypedAttributeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#typedAttributeList}.
	 * @param ctx the parse tree
	 */
	void exitTypedAttributeList(parserGrammarParser.TypedAttributeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(parserGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(parserGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(parserGrammarParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(parserGrammarParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserGrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(parserGrammarParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserGrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(parserGrammarParser.LiteralContext ctx);
}
