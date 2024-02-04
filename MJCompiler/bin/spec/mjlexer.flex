
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"program"   { return new_symbol(sym.PROG, yytext());}
"break"   { return new_symbol(sym.BREAK, yytext());}
"const"   { return new_symbol(sym.CONST, yytext());}
"if"   { return new_symbol(sym.IF, yytext());}
"new"   { return new_symbol(sym.NEW, yytext());}
"else"   { return new_symbol(sym.ELSE, yytext());}
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"read"   { return new_symbol(sym.READ, yytext());}
"return" 	{ return new_symbol(sym.RETURN, yytext()); }
"void" 		{ return new_symbol(sym.VOID, yytext()); }
"continue"   { return new_symbol(sym.CONTINUE, yytext());}
"for"   { return new_symbol(sym.FOR, yytext());}
"static"   { return new_symbol(sym.STATIC, yytext());}
"namespace"   { return new_symbol(sym.NAMESPACE, yytext());}
"+" 		{ return new_symbol(sym.PLUS, yytext()); }
"." 		{ return new_symbol(sym.DOT, yytext()); }
"-" 		{ return new_symbol(sym.MINUS, yytext()); }
"*" 		{ return new_symbol(sym.MULTIPLY, yytext()); }
"/" 		{ return new_symbol(sym.DIV, yytext()); }
"%" 		{ return new_symbol(sym.MOD, yytext()); }
"==" 		{ return new_symbol(sym.TWOEQUAL, yytext()); }
"!=" 		{ return new_symbol(sym.NOTEQUAL, yytext()); }
">" 		{ return new_symbol(sym.GREATER, yytext()); }
">=" 		{ return new_symbol(sym.GREATEREQUAL, yytext()); }
"<" 		{ return new_symbol(sym.LESS, yytext()); }
"<=" 		{ return new_symbol(sym.LESSEQUAL, yytext()); }
"&&" 		{ return new_symbol(sym.AND, yytext()); }
"||" 		{ return new_symbol(sym.OR, yytext()); }
"=" 		{ return new_symbol(sym.EQUAL, yytext()); }
"++" 		{ return new_symbol(sym.TWOPLUS, yytext()); }
"--" 		{ return new_symbol(sym.TWOMINUS, yytext()); }
";" 		{ return new_symbol(sym.SEMI, yytext()); }
"::" 		{ return new_symbol(sym.TWODOT, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"(" 		{ return new_symbol(sym.LPAREN, yytext()); }
")" 		{ return new_symbol(sym.RPAREN, yytext()); }
"{" 		{ return new_symbol(sym.LBRACE, yytext()); }
"}"			{ return new_symbol(sym.RBRACE, yytext()); }
"[" 		{ return new_symbol(sym.LSBRACE, yytext()); }
"]" 		{ return new_symbol(sym.RSBRACE, yytext()); }

"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

([1-9][0-9]* | 0)  { return new_symbol(sym.NUMBERCONST, Integer.parseInt (yytext())); }
("true" | "false")  { return new_symbol(sym.BOOLCONST, Boolean.parseBoolean(yytext())); }
[a-zA-Z][a-zA-Z0-9_]* 	{ return new_symbol (sym.IDENT, yytext()); }
'[^']'		{ return new_symbol(sym.CHARCONST, new Character(yytext().charAt(1))); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1) + " i koloni " + yycolumn); }

