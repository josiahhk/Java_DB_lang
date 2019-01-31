/*
Elijah Gonzales 725000232
Josiah Hamid-Khani 725003646
Joseph Hernandez 825002632
CSCE 313-505
October 16, 2018
parserCodeV2.java
*/
import org.antlr.v4.runtime.*;
        import org.antlr.v4.runtime.tree.*;
		import org.antlr.v4.runtime.misc.ParseCancellationException;
        import java.util.Scanner;
		import java.io.PrintWriter;
		import java.io.IOException;
		import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class parserCodeV2{
    public static void main(String[] args) throws ParseCancellationException, IOException{
	Scanner keyboard = new Scanner(System.in);
    String inputString = "";
	PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
	int i = 0;
	
	MyLanguageBaseListener mlbListener = new MyLanguageBaseListener();
    while (keyboard.hasNext()) {
        try {
                inputString = keyboard.nextLine();
				//this should allow the code to skip empty lines in the input
				if(inputString.isEmpty()){
				}
				else{
					ANTLRInputStream input = new ANTLRInputStream(inputString);
					parserGrammarLexer lexer = new parserGrammarLexer(input);
					lexer.removeErrorListeners();
					lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
					CommonTokenStream tokens = new CommonTokenStream(lexer);
					parserGrammarParser parser = new parserGrammarParser(tokens);
					parser.removeErrorListeners();
					parser.addErrorListener(ThrowingErrorListener.INSTANCE);
					parserGrammarParser.ProgramContext programContext = parser.program();
					ParseTreeWalker walker = new ParseTreeWalker();
					walker.walk(mlbListener, programContext);
				}
            }
        
        catch(Exception e){
            writer.println("Line " + i + " is invalid");
			i++;
        }
	}
	writer.close();
    }
}