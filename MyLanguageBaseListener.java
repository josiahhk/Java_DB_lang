/*
Elijah Gonzales 725000232
Josiah Hamid-Khani 725003646
Joseph Hernandez 825002632
CSCE 313-505
October 16, 2018
MyLanguageBaseListener.java
*/


import org.antlr.v4.runtime.*;
        import org.antlr.v4.runtime.tree.*;
		import org.antlr.v4.runtime.misc.ParseCancellationException;
        import java.util.Scanner;
		import java.io.PrintWriter;
		import java.io.IOException;
        import org.antlr.v4.runtime.tree.ParseTreeWalker;
        import java.util.List;
        import org.antlr.v4.runtime.tree.Tree;
        import java.lang.Object;
        import org.antlr.v4.runtime.RuleContext;
import java.util.*;
import java.lang.*;
import java.io.File; 


public class MyLanguageBaseListener extends parserGrammarBaseListener{
    ArrayList<String> arrayLiteral = new ArrayList<String>(); 
	DB myDB = new DB();

    public MyLanguageBaseListener(){
		
    }

    public void clearStuff(){
        arrayLiteral.clear();    
    }
	
	
	@Override public void enterOpenCmd(parserGrammarParser.OpenCmdContext ctx) { 
        List<ParseTree> children = ctx.children;
        ParseTree openWord = ctx.getChild(0);
        ParseTree relationName = ctx.getChild(1);
        try{myDB.open(relationName.getText());
		}
        catch(Exception ex){};
    }
	
	@Override public void exitCloseCmd(parserGrammarParser.CloseCmdContext ctx) { 
        List<ParseTree> children = ctx.children;
        ParseTree closeWord = ctx.getChild(0);
        ParseTree relationName = ctx.getChild(1);
        myDB.closeCommand(relationName.getText());
    }

    public void enterWriteCmd(parserGrammarParser.WriteCmdContext ctx) { 
        List<ParseTree> children = ctx.children;
        ParseTree closeWord = ctx.getChild(0);
        ParseTree relationName = ctx.getChild(1);
        myDB.writeCommand(relationName.getText());
    }

    public void enterExitCmd(parserGrammarParser.ExitCmdContext ctx) { 
        ParseTree exitWord = ctx.getChild(0);
        myDB.exitCommand();
    }
	
	@Override public void enterShowCmd(parserGrammarParser.ShowCmdContext ctx) { 
        List<ParseTree> children = ctx.children;
		String relation = "";
        ParseTree showWord = ctx.getChild(0);
        ParseTree relationName = ctx.getChild(1);
		
		while(relationName.getChildCount() != 0)
			relationName = relationName.getChild(0);
		relation = relationName.getText();
        myDB.showTables(relation);
    }

    public void enterDeleteCmd(parserGrammarParser.DeleteCmdContext ctx) { 
		List<ParseTree> children = ctx.children;
        ParseTree relationTree = null;
        ParseTree conditionTree = null;
		ParseTree lhs = null;
		ParseTree rhs = null;
		String op = "";
		String combinedInt="";
		relationTree = ctx.getChild(1);
		conditionTree = ctx.getChild(3);		
        int i = 0;
		int leftIntCounter = 0;
		int rightIntCounter = 0;
		boolean leftIsInt = false;
		boolean rightIsInt = false;
		
		
		while(conditionTree.getChildCount() == 1){
			conditionTree = conditionTree.getChild(0);
			if(conditionTree.getChildCount()==3){
				if(i == 0){
					conditionTree = conditionTree.getChild(1);
					i++;
				}
				else if(i != 0){
					lhs = conditionTree.getChild(0);
					op = conditionTree.getChild(1).getText();
					rhs = conditionTree.getChild(2);
					break;
				}
			}
		}
		//this should check for things in quotes and return the leaves
		while(lhs.getChildCount() != 0){
			if(leftIntCounter > 1){
				for(int k = 0; k < lhs.getChildCount(); k++)
					combinedInt = combinedInt + lhs.getChild(k).getText();
				leftIsInt = true;
			}
			if(lhs.getChildCount() == 3){
				lhs = lhs.getChild(1);
				break;
			}
			lhs = lhs.getChild(0);
			leftIntCounter++;
		}
		while(rhs.getChildCount() != 0){
			if(rightIntCounter > 1){
				for(int k = 0; k < rhs.getChildCount(); k++)
					combinedInt = combinedInt + rhs.getChild(k).getText();
				rightIsInt = true;
			}
			if(rhs.getChildCount() == 3){
				rhs = rhs.getChild(1);
				break;
			}
			rhs = rhs.getChild(0);
			rightIntCounter++;

		}
		if(leftIsInt == false && rightIsInt == false)
			myDB.deleteCommand(lhs.getText(), rhs.getText(), op, relationTree.getText());
 		if(leftIsInt == true && rightIsInt == false)
			myDB.deleteCommand(combinedInt, rhs.getText(), op, relationTree.getText());
		if(leftIsInt == false && rightIsInt == true)
			myDB.deleteCommand(lhs.getText(), combinedInt, op, relationTree.getText()); 
		

    }
/*

    @Override public void exitLiteral(parserGrammarParser.LiteralContext ctx){
        List<ParseTree> children = ctx.children; 
		System.out.println(children.get(1).getText());
        arrayLiteral.add(children.get(1).getText()); 
		System.out.println(arrayLiteral.size());
    }

	@Override public void exitInteger(parserGrammarParser.IntegerContext ctx) {
		List<ParseTree> children = ctx.children;
		String combinedInt = "";
		if(children.size()>1)
			for(ParseTree child : children)
				combinedInt = combinedInt + child.getText();
		System.out.println(combinedInt);
		arrayLiteral.add(children.get(0).getText());
		System.out.println(arrayLiteral.size());
		
	}
	
	*/
	
	
	@Override public void exitQuery(parserGrammarParser.QueryContext ctx) {
		List<ParseTree> children = ctx.children; 
		String queryRelation = children.get(0).getText();
		myDB.query(queryRelation);
		
	}
	
    @Override public void exitUnion(parserGrammarParser.UnionContext ctx){
        List<ParseTree> children = ctx.children; 
        ParseTree lhs = children.get(0); 
        ParseTree rhs = children.get(2); 
        myDB.union(rhs.getText(), lhs.getText()); 

    }
	
	
	@Override public void exitRenaming(parserGrammarParser.RenamingContext ctx){
		List<ParseTree> children = ctx.children; 
		ParseTree attList = children.get(2);
		String relationName = children.get(4).getText();
		ArrayList<String> names = new ArrayList<>();
		for(int i = 0; i < attList.getChildCount(); i+=2){
			names.add(attList.getChild(i).getText());
		}
		
		myDB.rename(relationName, names);
		
	}
	
	@Override public void exitProjection(parserGrammarParser.ProjectionContext ctx){
		List<ParseTree> children = ctx.children; 
		ParseTree attList = children.get(2);
		String relationName = children.get(4).getText();
		ArrayList<String> col = new ArrayList<>();
		for(int i = 0; i < attList.getChildCount(); i+=2){
			col.add(attList.getChild(i).getText());
		}
		
		myDB.projectQuery(col, relationName);
		
		

		
	}
	
	@Override public void exitProduct(parserGrammarParser.ProductContext ctx) {
        List<ParseTree> children = ctx.children; 
        ParseTree lhs = children.get(0); 
        ParseTree rhs = children.get(2); 
        myDB.productQuery(rhs.getText(), lhs.getText()); 

    }

    @Override public void exitSelection(parserGrammarParser.SelectionContext ctx) {
        List<ParseTree> children = ctx.children; 
		String from = children.get(4).getText();
        ParseTree conditionTree = null;
		ParseTree lhs = null;
		ParseTree rhs = null;
		String op = "";
		String combinedInt="";
		conditionTree = ctx.getChild(2);		
        int i = 0;
		int leftIntCounter = 0;
		int rightIntCounter = 0;
		boolean leftIsInt = false;
		boolean rightIsInt = false;
		
		
		while(conditionTree.getChildCount() == 1){
			conditionTree = conditionTree.getChild(0);
			if(conditionTree.getChildCount()==3){
					lhs = conditionTree.getChild(0);
					op = conditionTree.getChild(1).getText();
					rhs = conditionTree.getChild(2);
					break;
			}					
		}
		
		
		//this should check for things in quotes and return the leaves
		while(lhs.getChildCount() != 0){
			if(leftIntCounter > 1){
				for(int k = 0; k < lhs.getChildCount(); k++)
					combinedInt = combinedInt + lhs.getChild(k).getText();
				leftIsInt = true;
			}
			if(lhs.getChildCount() == 3){
				lhs = lhs.getChild(1);
				break;
			}
			lhs = lhs.getChild(0);
			leftIntCounter++;
		}
		while(rhs.getChildCount() != 0){
			if(rightIntCounter > 1){
				for(int k = 0; k < rhs.getChildCount(); k++)
					combinedInt = combinedInt + rhs.getChild(k).getText();
				rightIsInt = true;
			}
			if(rhs.getChildCount() == 3){
				rhs = rhs.getChild(1);
				break;
			}
			rhs = rhs.getChild(0);
			rightIntCounter++;

		}
		if(leftIsInt == false && rightIsInt == false)
			myDB.selectQuery(lhs.getText(), rhs.getText(), op, from);
 		if(leftIsInt == true && rightIsInt == false)
			myDB.selectQuery(combinedInt, rhs.getText(), op, from);
		if(leftIsInt == false && rightIsInt == true)
			myDB.selectQuery(lhs.getText(), combinedInt, op, from); 
		
    }

    @Override public void exitDifference(parserGrammarParser.DifferenceContext ctx) {
        List<ParseTree> children = ctx.children; 
        ParseTree lhs = ctx.getChild(0); 
        ParseTree rhs = ctx.getChild(2); 
        myDB.differenceQuery(lhs.getText(), rhs.getText()); 

    }
	
	
	@Override public void enterInsertCmd(parserGrammarParser.InsertCmdContext ctx) {
		List<ParseTree> children = ctx.children; 
		ParseTree table = ctx.getChild(1); 
		ParseTree lit = null;
		ParseTree intTree = null;
		String combinedInt = "";
		ArrayList<String> args = new ArrayList<>(); 
		for(int i = 4; i < children.size(); i+=2){
			lit = children.get(i);
			combinedInt = "";
			if(lit.getChildCount() == 3)
				args.add(lit.getChild(1).getText());
			else if(lit.getChildCount() == 1){
				intTree = lit.getChild(0);
				for(int j = 0; j < intTree.getChildCount(); j++)
					combinedInt = combinedInt + intTree.getChild(j).getText();
				args.add(combinedInt);
			}
		}
		myDB.insertCommand(table.getText(), args); 
				
    }
	
	
	@Override public void enterCreateCmd(parserGrammarParser.CreateCmdContext ctx) {
		List<ParseTree> children = ctx.children; 
		ParseTree table = ctx.getChild(1); 
		ParseTree typedAtList = ctx.getChild(3);
		ParseTree var = null;
		ParseTree intTree = null;
		ParseTree primKeyTree = null;
		String combinedInt = "";
		ArrayList<Attribute> input = new ArrayList<>();
		for(int i = 0; i < typedAtList.getChildCount(); i+=3){
			Attribute a = new Attribute();
			combinedInt = "";
			for(int j = i; j < i+2; j++){
				var = typedAtList.getChild(j);
				if(var.getChildCount()==1){
					if(j%3 == 0)
						a.setName(var.getText());
					else a.setDT(var.getText());
				}
				else if(var.getChildCount() ==4){ //VARCHAR (size)
					a.setDT(var.getChild(0).getText());
					intTree = var.getChild(2);
					for(int k = 0; k < intTree.getChildCount(); k++)
						combinedInt = combinedInt + intTree.getChild(k).getText();
					a.setSize(combinedInt);
				}
			}
		
			input.add(a);
		}
		
		primKeyTree = ctx.getChild(7);
		for(int i = 0; i < primKeyTree.getChildCount(); i+=2)
			for(int j = 0; j < input.size(); j++)
				if(input.get(j).getName().equals(primKeyTree.getChild(i).getText()))
					input.get(j).setPrimKey(true);
		
		myDB.createCommand(table.getText(), input);	


	}
	
	@Override public void enterUpdateCmd(parserGrammarParser.UpdateCmdContext ctx) { 
		List<ParseTree> children = ctx.children; 
		ParseTree table = ctx.getChild(1); 
		ParseTree att = ctx.getChild(3);
		ParseTree literal = ctx.getChild(5);
        ParseTree conditionTree = ctx.getChild(7);
		ParseTree lhs = null;
		ParseTree rhs = null;
		String op = "";
		String combinedInt="";
        int i = 0;
		int leftIntCounter = 0;
		int rightIntCounter = 0;
		boolean leftIsInt = false;
		boolean rightIsInt = false;
		
		
		
		while(literal.getChildCount() > 0){
			if(literal.getChildCount() == 3)
				literal = literal.getChild(1);
			else literal = literal.getChild(0);
		}

		//everything below this is for the condition
		while(conditionTree.getChildCount() == 1){
			conditionTree = conditionTree.getChild(0);
			if(conditionTree.getChildCount()==3){
				if(i == 0){
					conditionTree = conditionTree.getChild(1);
					i++;
				}
				else if(i != 0){
					lhs = conditionTree.getChild(0);
					op = conditionTree.getChild(1).getText();
					rhs = conditionTree.getChild(2);
					break;
				}
			}
		}
		
		
				
		//this should check for things in quotes and return the leaves and put ints together
		while(lhs.getChildCount() != 0){
			if(leftIntCounter > 1){
				for(int k = 0; k < lhs.getChildCount(); k++)
					combinedInt = combinedInt + lhs.getChild(k).getText();
				leftIsInt = true;
			}
			if(lhs.getChildCount() == 3){
				lhs = lhs.getChild(1);
				break;
			}
			lhs = lhs.getChild(0);
			leftIntCounter++;
		}
		while(rhs.getChildCount() != 0){
			if(rightIntCounter > 1){
				for(int k = 0; k < rhs.getChildCount(); k++)
					combinedInt = combinedInt + rhs.getChild(k).getText();
				rightIsInt = true;
			}
			if(rhs.getChildCount() == 3){
				rhs = rhs.getChild(1);
				break;
			}
			rhs = rhs.getChild(0);
			rightIntCounter++;

		}
		
		if(leftIsInt == false && rightIsInt == false)
			myDB.updateQuery(lhs.getText(), rhs.getText(), op, table.getText(), att.getText(), literal.getText());
 		if(leftIsInt == true && rightIsInt == false)
			myDB.updateQuery(combinedInt, rhs.getText(), op, table.getText(), att.getText(), literal.getText());
		if(leftIsInt == false && rightIsInt == true)
			myDB.updateQuery(lhs.getText(), combinedInt, op, table.getText(), att.getText(), literal.getText()); 
			
	}
	
	
	
}