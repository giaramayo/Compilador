package com.ucema.compilador;

import jflex.exceptions.SilentExit;

public class ExecuteJFlex {

    public static void main(String omega[]) {
        String lexerFile = System.getProperty("user.dir") + "/src/com/ucema/compilador/Lexer.flex",
               lexerFileColor = System.getProperty("user.dir") + "/src/com/ucema/compilador/LexerColor.flex";
        try {
            jflex.Main.generate(new String[]{lexerFile, lexerFileColor});
        } catch (SilentExit ex) {
            System.out.println("Error al compilar/generar el archivo flex: " + ex);
        }
    }
}
