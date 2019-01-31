For part 4: Pretty much every file included is required to run with the exception of DBTester and TableTester. In order to run, follow the steps at the bottom and replace "stuff.txt" with whatever file includes the instructions you want to run.

For part 3: So I truly don't know what all is needed to run it at this point. In
order to test the DB, you can compile all the java program using the method
listed below and then run DBTester also using the method listed below
but instead of parserCodeV2 < stuff.txt, use DBTester.


In order to compile and run, you will need:
All the generated parser/lexer listeners and whatnot
Anything necessary to get ANTLR to run
ThrowingErrorListener.java
ParserCodeV2.java

We compiled on compute using: javac -cp "antlr-4.7.1-complete.jar" *.java
and then ran it using:  java -cp ".:antlr-4.7.1-complete.jar" parserCodeV2 < stuff.txt
It will print the trees to the screen, but the output file will only contain the necessary
"Line __ is valid/invalid". The output file will be titled "output". 
The code should skip blank lines in the input file.


