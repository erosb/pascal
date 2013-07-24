grammar Pascal;

program : 'program' ID
	decl
	function*
	block
	function*;
	
block: BEGIN stmt* END;

stmt: assign | call ';' | ret | ctrlStruct ;

assign: ID LET expr ';' ;
call : ID '(' argList ')' ;
expr : expr op=('/' | '*') expr #DivMul
	| expr op=('+' | '-') expr #AddSub
	| expr op=('>' | '<' | '<=' | '>=' | '=') expr #Predicate
	| call #FunctionCall
	| ID #VarRef
	| LITERAL #Literal
	| '(' expr ')'  #Parens
	;
argList : (expr (',' expr)*)? ;

decl : 'var' varDecl (',' varDecl)* ';' ;
varDecl : varName=ID ':' type=ID ;

ctrlStruct : ifStruct | loopStruct ;
	
ifStruct : IF expr THEN
				stmt*
		   END IF ;
		   
loopStruct : DO (WHILE preCond=expr)?
				stmt*
			LOOP (WHILE postCond=expr)? ;
			
ret : RETURN expr? ';' ;
			
function: retType=ID fnName=ID formParList
		  decl?
          block ;
          
formParList : '(' formPar* ')' ;

formPar : type=ID name=ID (LET defaultVal=expr)? ; 
		   
LITERAL : INT
	| STRING
	| BOOLEAN
	;
IF : 'if' ;
THEN : 'then' ;
DO : 'do';
WHILE : 'while';
LOOP : 'loop';
RETURN : 'return';
WS : [ \t\r\n]+ -> skip ;
BEGIN : 'begin' ;
END : 'end' ;
LET : ':=' ;
ID : [a-zA-Z_][a-zA-Z_0-9]* ;

INT : '-'? [0-9]+ ;
STRING : '"' .*? '"' ;
BOOLEAN : 'true' | 'false' ;

