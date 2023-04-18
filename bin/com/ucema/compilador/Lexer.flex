import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

/* Número */
Numero = 0 | [1-9][0-9]*
%%
/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }

/* Identificador */
\${Identificador} { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }

/* Tipos de dato */
numero | 
cadena |
color { return token(yytext(), "TIPO_DATO", yyline, yycolumn); }

/* Tipos de dato */
imprimir { return token(yytext(), "IMPRIMIR", yyline, yycolumn); }

/*  */
retornar { return token(yytext(), "RETORNAR", yyline, yycolumn); }


/* Número */
{Numero} { return token(yytext(), "NUMERO", yyline, yycolumn); }

/* Colores */
#[{Letra}{Digito}]{6} { return token(yytext(), "COLOR", yyline, yycolumn); }

/* Operadores de agrupación */
"(" { return token(yytext(), "PARENTESIS_A", yyline, yycolumn); }
")" { return token(yytext(), "PARENTESIS_C", yyline, yycolumn); }
"{" { return token(yytext(), "LLAVE_A", yyline, yycolumn); }
"}" { return token(yytext(), "LLAVE_C", yyline, yycolumn); }
"]" { return token(yytext(), "CORCHETE_C", yyline, yycolumn); }
"[" { return token(yytext(), "CORCHETE_A", yyline, yycolumn); }


/* Signos de puntuación */
"," { return token(yytext(), "COMA", yyline, yycolumn); }
";" { return token(yytext(), "PUNTO_COMA", yyline, yycolumn); }

/* Operador de asignación */
--> { return token (yytext(), "OP_ASIG", yyline, yycolumn); }

/* Movimiento */
adelante |
atrás |
izquierda |
derecha |
norte |
sur |
este |
oeste { return token(yytext(), "MOVIMIENTO", yyline, yycolumn); }

/* Pintar */
pintar { return token(yytext(), "PINTAR", yyline, yycolumn); }

/* Detener pintar */
detenerPintar { return token(yytext(), "DETENER_PINTAR", yyline, yycolumn); }

/* Tomar */
tomar |
poner { return token(yytext(), "TOMAR", yyline, yycolumn); }

/* Lanzar Moneda */
lanzarMoneda { return token(yytext(), "LANZAR_MONEDA", yyline, yycolumn); }

/* Ver */
izquierdaEsObstáculo |
izquierdaEsClaro |
izquierdaEsBaliza |
izquierdaEsBlanco |
izquierdaEsNegro |
frenteEsObstáculo |
frenteEsClaro |
frenteEsBaliza |
frenteEsBlanco |
frenteEsNegro |
derechaEsObstáculo |
derechaEsClaro |
derechaEsBaliza |
derechaEsBlanco |
derechaEsNegro { return token(yytext(), "VER", yyline, yycolumn); }



/* Repetir */
repetir |
repetirMientras { return token(yytext(), "REPETIR", yyline, yycolumn); }

/* Detener repetir */
interrumpir { return token(yytext(), "DETENER_REPETIR", yyline, yycolumn); }

/* Estructura si */
si |
sino { return token(yytext(), "ESTRUCTURA_SI", yyline, yycolumn); }

/* Operadores lógicos */
"&" |
"|" { return token(yytext(), "OP_LOGICO", yyline, yycolumn); }

/* Final */
final { return token(yytext(), "FINAL", yyline, yycolumn); }

/* Errores */
// Número erróneo
0 {Numero}+ { return token(yytext(), "ERROR_1", yyline, yycolumn); }
// Identificador sin $
{Identificador} { return token(yytext(), "ERROR_2", yyline, yycolumn); }

/* Comilla simple*/
( "'") { return token(yytext(), "COMILLA_SIMPLE", yyline, yycolumn); }
/* Comillas */
( "\"") { return token(yytext(), "COMILLA_DOBLE", yyline, yycolumn); }

/* Cadena - texto entre comillas*/
L?\"(\\.|[^\\\"])*\"  { return token(yytext(), "CADENA_ENTRE_COMILLA", yyline, yycolumn); }

/* Comparador Mayor igual*/
( ">=" ) { return token(yytext(), "OP_MAYOR_IGUAL", yyline, yycolumn); }

/* Comparador Menor igual*/
( "<=" ) { return token(yytext(), "OP_MENOR_IGUAL", yyline, yycolumn); }

/* Operador Más igual*/
( "+=" ) { return token(yytext(), "OP_MAS_IGUAL", yyline, yycolumn); }

/* Operador Menos igual*/
( "-=" ) { return token(yytext(), "OP_MENOS_IGUAL", yyline, yycolumn); }

/* Operador Multiplica igual*/
( "*=" ) { return token(yytext(), "OP_MULTIPLICAR_IGUAL", yyline, yycolumn); }

/* Operador Division igual*/
( "/=" ) { return token(yytext(), "OP_DIVISION_IGUAL", yyline, yycolumn); }

/* Operador Comparador igual*/
( "==" ) { return token(yytext(), "OP_COMPARADOR_IGUAL", yyline, yycolumn); }

/* Operador Diferente */
( "!=" ) { return token(yytext(), "OP_DIFERENTE", yyline, yycolumn); }

/* Operador Negador*/
( "!" ) { return token(yytext(), "OP_NEGADOR", yyline, yycolumn); }

/* Incremento */
( "++" ) { return token(yytext(), "OP_INCREMENTO", yyline, yycolumn); }

/* Decremento*/
( "--" ) { return token(yytext(), "OP_DECREMENTO", yyline, yycolumn); }

/* Operador Igual */
( "=" ) { return token(yytext(), "OP_IGUAL", yyline, yycolumn); }

/* Modulo igual*/
( "%=" ) { return token(yytext(), "OP_MODULO_IGUAL", yyline, yycolumn); }

/* Operador Mayor que */
( ">" ) { return token(yytext(), "OP_MAYOR_QUE", yyline, yycolumn); }

/* Operador Menor que */
( "<" ) { return token(yytext(), "OP_MENOR", yyline, yycolumn); }

/* Signo dos puntos*/
( ":" ) { return token(yytext(), "DOS_PUNTOS", yyline, yycolumn); }

/* operador y logico*/
( "&&" ) { return token(yytext(), "OPERADOR_Y", yyline, yycolumn); }


/* operador o logico*/
( "||" ) { return token(yytext(), "OPERADOR_O", yyline, yycolumn); }


/* Operador Multiplicación */
( "*" ) { return token(yytext(), "OPERADOR_MULTIPLICAR", yyline, yycolumn); }

/* Operador Modulo*/
( "%" ) { return token(yytext(), "OPERADOR_MODULO", yyline, yycolumn); }


/* Operador Resta */
( "-" ) { return token(yytext(), "OPERADOR_RESTA", yyline, yycolumn); }


/* Operador Resta */
( "+" ) { return token(yytext(), "OPERADOR_SUMA", yyline, yycolumn); }

/* Marcador false*/
( "falso" ) { return token(yytext(), "MARCADOR_FALSO", yyline, yycolumn); }

/* Marcador true*/
( "verdadero" ) { return token(yytext(), "MARCADOR_VERDADERO", yyline, yycolumn); }



. { return token(yytext(), "ERROR", yyline, yycolumn); }