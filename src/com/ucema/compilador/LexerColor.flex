import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
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
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146)); }
{EspacioEnBlanco} { /*Ignorar*/ }

/* Identificador */
\${Identificador} { /*Ignorar*/ }

/* Tipos de dato */
numero | 
cadena |
color  { return textColor(yychar, yylength(), new Color(148, 58, 173)); }

imprimir  { return textColor(yychar, yylength(), new Color(102, 102, 255)); }
retornar { return textColor(yychar, yylength(), new Color(102, 102, 255)); }


/* Número */
{Numero} { return textColor(yychar, yylength(), new Color(35, 120, 147)); }

/* Colores */
#[{Letra}{Digito}]{6} { return textColor(yychar, yylength(), new Color(224, 195, 12)); }

/* Operadores de agrupación */
"("|")"|"{"|"}" | "[" | "]" { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Signos de puntuación */
","|
";" { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador de asignación */
--> { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Movimiento */
adelante |
atrás |
izquierda |
derecha |
norte |
sur |
este |
oeste { return textColor(yychar, yylength(), new Color(17, 94, 153)); }

/* Pintar */
pintar { return textColor(yychar, yylength(), new Color(212, 129, 6)); }

/* Detener pintar */
detenerPintar { return textColor(yychar, yylength(), new Color(255, 64, 129)); }

/* Tomar */
tomar |
poner { return textColor(yychar, yylength(), new Color(102, 41, 120)); }

/* Lanzar Moneda */
lanzarMoneda { return textColor(yychar, yylength(), new Color(239, 108, 0)); }

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
derechaEsNegro { return textColor(yychar, yylength(), new Color(150, 0, 80)); }

/* Repetir */
repetir |
repetirMientras { return textColor(yychar, yylength(), new Color(121, 107, 255)); }

/* Detener repetir */
interrumpir { return textColor(yychar, yylength(), new Color(255, 64, 129)); }

/* Estructura si */
si |
sino { return textColor(yychar, yylength(), new Color(48, 63, 159)); }

/* Operadores lógicos */
"&" |
"|" { return textColor(yychar, yylength(), new Color(46, 125, 50)); }

/* Final */
final { return textColor(yychar, yylength(), new Color(198, 40, 40)); }


/* Comilla simple*/
( "'") { return textColor(yychar, yylength(), new Color(0, 102, 255)); }
/* Comillas */
( "\"") { return textColor(yychar, yylength(), new Color(0, 102, 255)); }

/* Cadena - texto entre comillas*/
L?\"(\\.|[^\\\"])*\"  { return textColor(yychar, yylength(), new Color(0, 102, 255)); }


/* Comparador Mayor igual*/
">="  { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Comparador Menor igual*/
 "<="  { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Más igual*/
 "+=" { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Menos igual*/
  "-="   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Multiplica igual*/
  "*="   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Division igual*/
  "/="   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Comparador igual*/
  "=="  { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Diferente */
  "!="   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Negador*/
  "!"  { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Incremento */
  "++"   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Decremento*/
  "--"   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Igual */
  "="   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Modulo igual*/
  "%="   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Mayor que */
  ">"   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Menor que */
  "<"   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Signo dos puntos*/
  ":"   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* operador y logico*/
  "&&"   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* operador o logico*/
  "||"   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Multiplicación */
  "*"   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Modulo*/
  "%"   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Resta */
  "-"  { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Operador Resta */
  "+"   { return textColor(yychar, yylength(), new Color(182, 200, 205)); }

/* Marcador false*/
  "falso"   { return textColor(yychar, yylength(), new Color(0, 204, 102)); }

/* Marcador true*/
 "verdadero"  { return textColor(yychar, yylength(), new Color(0, 204, 102)); }




/* Errores */
// Número erróneo
0 {Numero}+ { /* Ignorar */ }
// Identificador sin $
{Identificador} { /* Ignorar */ }
. { /* Ignorar */ }