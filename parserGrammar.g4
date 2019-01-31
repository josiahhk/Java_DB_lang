/*
Elijah Gonzales 725000232
Josiah Hamid-Khani 725003646
Joseph Hernandez 825002632
CSCE 313-505
October 10, 2018
parserGrammar.g4
*/

grammar parserGrammar;

program : (query | command)*;

query: relationName '<-' expr ';';

relationName: Identifier;

expr: atomicExpr | selection | projection | renaming | union | difference |
      product;
      
atomicExpr: relationName | '('expr')';

selection: 'select' '(' condition ')' atomicExpr;

condition: conjunction ('||' conjunction)*;

conjunction: comparison ('&&' comparison)*;

comparison: operand op operand | '('condition')';

op: '==' | '!=' | '<' | '>'| '<=' | '>=';

operand: attributeName | literal;

attributeName: Identifier;


projection: 'project' '('attributeList')' atomicExpr;

attributeList: attributeName (',' attributeName)*;

renaming: 'rename' '('attributeList')' atomicExpr;

union: atomicExpr '+' atomicExpr;

difference: atomicExpr '-' atomicExpr;

product: atomicExpr '*' atomicExpr;

command: ( openCmd | closeCmd | writeCmd | exitCmd | showCmd | createCmd |
		 updateCmd | insertCmd | deleteCmd ) ';';
closeCmd: 'CLOSE' relationName;

writeCmd: 'WRITE' relationName;

openCmd: 'OPEN' relationName;

exitCmd: 'EXIT';

showCmd: 'SHOW' atomicExpr;

createCmd: 'CREATE TABLE' relationName '('typedAttributeList')' 'PRIMARY KEY' '('attributeList')';


updateCmd: 'UPDATE' relationName 'SET' attributeName '=' literal (',' attributeName '=' literal)* 'WHERE' condition;


insertCmd: 'INSERT INTO' relationName 'VALUES FROM' '('literal (','literal)*')'
		 | 'INSERT INTO' relationName 'VALUES FROM RELATION' expr;


deleteCmd: 'DELETE FROM' relationName 'WHERE' condition;


typedAttributeList: attributeName type (',' attributeName type)*;


type: 'VARCHAR' '(' integer ')' | 'INTEGER';

integer: Digit(Digit)*;

Identifier : (Alpha)(Alpha | Digit)*;


Alpha: [a-z] | [A-Z] | '_';

Digit: [0-9];

WS : [ \t\r\n]+ -> skip ;


literal: (Alpha|Digit)|(Alpha|Digit)(Alpha|Digit)*|'"'Identifier'"' | Identifier;

