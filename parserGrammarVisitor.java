/*
Elijah Gonzales 725000232
Josiah Hamid-Khani 725003646
Joseph Hernandez 825002632
CSCE 313-505
October 10, 2018
parserGrammarVisitor.java
*/
// Generated from H:/Java\parserGrammar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link parserGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface parserGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(parserGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(parserGrammarParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#relationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationName(parserGrammarParser.RelationNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(parserGrammarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#atomicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicExpr(parserGrammarParser.AtomicExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(parserGrammarParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(parserGrammarParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(parserGrammarParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(parserGrammarParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(parserGrammarParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(parserGrammarParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#attributeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeName(parserGrammarParser.AttributeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#projection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjection(parserGrammarParser.ProjectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#attributeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeList(parserGrammarParser.AttributeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#renaming}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenaming(parserGrammarParser.RenamingContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(parserGrammarParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#difference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifference(parserGrammarParser.DifferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#product}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProduct(parserGrammarParser.ProductContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(parserGrammarParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#closeCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseCmd(parserGrammarParser.CloseCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#writeCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteCmd(parserGrammarParser.WriteCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#openCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenCmd(parserGrammarParser.OpenCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#exitCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitCmd(parserGrammarParser.ExitCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#showCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCmd(parserGrammarParser.ShowCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#createCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateCmd(parserGrammarParser.CreateCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#updateCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateCmd(parserGrammarParser.UpdateCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#insertCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertCmd(parserGrammarParser.InsertCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#deleteCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteCmd(parserGrammarParser.DeleteCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#typedAttributeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedAttributeList(parserGrammarParser.TypedAttributeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(parserGrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(parserGrammarParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserGrammarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(parserGrammarParser.LiteralContext ctx);
}
