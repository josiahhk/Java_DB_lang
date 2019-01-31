/*

Elijah Gonzales 725000232
Josiah Hamid-Khani 725003646
Joseph Hernandez 825002632
CSCE 313-505
October 10, 2018
ThrowingErroListener.java

Code for ThrowingErrorListener taken from:
https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4

ThrowingErrorListener.java
*/ 

import org.antlr.v4.runtime.*;
	import org.antlr.v4.runtime.tree.*;
	import org.antlr.v4.runtime.misc.ParseCancellationException;
		
public class ThrowingErrorListener extends BaseErrorListener {

   public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();

   @Override
   public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
      throws ParseCancellationException {
         throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
      }
}
