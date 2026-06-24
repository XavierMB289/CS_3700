RULES:
- Things in <> are not literal, they are descriptions. The | inbetween is an "OR"
- Things in [] are optional. All things in the same bracket must be filled in optionally
- You cannot have a variable named "temp"!!!
- Variable declaration MUST be first (thats the way I had/wanted to code it)
- Have fun

INFO:
OPERAND is ==, >, <
OPERATOR is +, -, *, /, %

"Commands":
 - <VARIABLE_NAME> = <INT | "INPUT"> [<OPERATOR> <INT | INPUT>]
 - - Sets a variable equal to an int or an input
 - IF <VARIABLE_NAME> <OPERAND> <VARIABLE_NAME | INT | INPUT> THEN
 - - Compares 2 things
 - ENDIF
 - - Ends the IF statement
 - FOR <TEMP_VARIABLE_NAME> IN <VARIABLE_NAME | INPUT> THEN
 - - A more complex foreach
 - ENDFOR
 - - Ends the FOR loop
 - INPUT
 - - Grabs an input
 - OUTPUT <VARIABLE_NAME | TEMP_VARIABLE_NAME | TS>
 - - OUTPUTs the given information
 - TS <VARIABLE_NAME | INT>
 - - Converts (T)o (S)tring
 - DISPLAY [<INT | "BF">]
 - - Displays the dataline to this point. If an int is given, will only display the data at the given index instead.
 - - This does not change the BFCode
 - BF_CODE
 - - Displays the bfcode up to this point. This does not change the BFCode