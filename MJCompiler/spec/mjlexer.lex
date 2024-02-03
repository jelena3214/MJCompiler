
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{
	private int charNumber = 1;
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

" " 	{ charNumber++; }
"\b" 	{ charNumber--; }
"\t" 	{ charNumber+=4; }
"\r\n" 	{ charNumber = 1; }
"\f" 	{ charNumber = 1; }

"program"   { charNumber+=yytext().length();;return new_symbol(sym.PROG, yytext());}
"break"   { charNumber+=yytext().length();;return new_symbol(sym.BREAK, yytext());}
"const"   { charNumber+=yytext().length();;return new_symbol(sym.CONST, yytext());}
"if"   { charNumber+=yytext().length();;return new_symbol(sym.IF, yytext());}
"new"   { charNumber+=yytext().length();;return new_symbol(sym.NEW, yytext());}
"else"   { charNumber+=yytext().length();;return new_symbol(sym.ELSE, yytext());}
"print" 	{ charNumber+=yytext().length();;return new_symbol(sym.PRINT, yytext()); }
"read"   { charNumber+=yytext().length();;return new_symbol(sym.READ, yytext());}
"return" 	{ charNumber+=yytext().length();;return new_symbol(sym.RETURN, yytext()); }
"void" 		{ charNumber+=yytext().length();;return new_symbol(sym.VOID, yytext()); }
"continue"   { charNumber+=yytext().length();;return new_symbol(sym.CONTINUE, yytext());}
"for"   { charNumber+=yytext().length();;return new_symbol(sym.FOR, yytext());}
"static"   { charNumber+=yytext().length();;return new_symbol(sym.STATIC, yytext());}
"namespace"   { charNumber+=yytext().length();;return new_symbol(sym.NAMESPACE, yytext());}
"+" 		{ charNumber++;return new_symbol(sym.PLUS, yytext()); }
"." 		{ charNumber++;return new_symbol(sym.DOT, yytext()); }
"-" 		{ charNumber++;return new_symbol(sym.MINUS, yytext()); }
"*" 		{ charNumber++;return new_symbol(sym.MULTIPLY, yytext()); }
"/" 		{ charNumber++;return new_symbol(sym.DIV, yytext()); }
"%" 		{ charNumber++;return new_symbol(sym.MOD, yytext()); }
"==" 		{ charNumber++;return new_symbol(sym.TWOEQUAL, yytext()); }
"!=" 		{ charNumber++;return new_symbol(sym.NOTEQUAL, yytext()); }
">" 		{ charNumber++;return new_symbol(sym.GREATER, yytext()); }
">=" 		{ charNumber++;return new_symbol(sym.GREATEREQUAL, yytext()); }
"<" 		{ charNumber++;return new_symbol(sym.LESS, yytext()); }
"<=" 		{ charNumber++;return new_symbol(sym.LESSEQUAL, yytext()); }
"&&" 		{ charNumber++;return new_symbol(sym.AND, yytext()); }
"||" 		{ charNumber++;return new_symbol(sym.OR, yytext()); }
"=" 		{ charNumber++;return new_symbol(sym.EQUAL, yytext()); }
"++" 		{ charNumber++;return new_symbol(sym.TWOPLUS, yytext()); }
"--" 		{ charNumber++;return new_symbol(sym.TWOMINUS, yytext()); }
";" 		{ charNumber++;return new_symbol(sym.SEMI, yytext()); }
"::" 		{ charNumber++;return new_symbol(sym.TWODOT, yytext()); }
"," 		{ charNumber++;return new_symbol(sym.COMMA, yytext()); }
"(" 		{ charNumber++;return new_symbol(sym.LPAREN, yytext()); }
")" 		{ charNumber++;return new_symbol(sym.RPAREN, yytext()); }
"{" 		{ charNumber++;return new_symbol(sym.LBRACE, yytext()); }
"}"			{ charNumber++;return new_symbol(sym.RBRACE, yytext()); }
"[" 		{ charNumber++;return new_symbol(sym.LSBRACE, yytext()); }
"]" 		{ charNumber++;return new_symbol(sym.RSBRACE, yytext()); }

"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

[1-9][0-9]*  { charNumber+=yytext().length();return new_symbol(sym.NUMBERCONST, Integer.parseInt (yytext())); }
("true" | "false")  { charNumber+=yytext().length();return new_symbol(sym.BOOLCONST, Boolean.parseBoolean(yytext())); }
[a-zA-Z][a-zA-Z0-9_]* 	{charNumber+=yytext().length();return new_symbol (sym.IDENT, yytext()); }
\"([^\"])*\"		{charNumber+=yytext().length();return new_symbol (sym.CHARCONST, yytext()); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1) + " i koloni " + charNumber); charNumber+=yytext().length(); }










