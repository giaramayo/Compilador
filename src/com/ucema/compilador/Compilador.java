package com.ucema.compilador;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatIntelliJLaf;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.HashMap;
import compilerTools.*;
import javax.swing.Timer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.LayoutStyle.ComponentPlacement;



public class Compilador extends JFrame {

	private String title;
	private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;
		
	private JPanel contentPane;
	public  JTextArea jtaOutputConsole;
	private JButton btnAbrir;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnGuardarC;
	private JButton btnCompilar;
	private JButton btnEjecutar;
	private JLabel logo;
	private Label titulo;
	private JTextPane jtpCode;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTable tblTokens;
	
	private JComponent component;
	
	public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
                new Compilador().setVisible(true);
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
        });
	}

	public Compilador() {
		initComponentes();		
		init();
	}
	
	private void init() {
		title = "#CompiladorUCEMA";
		setLocationRelativeTo(null);
		setTitle(title);
		directorio = new Directory(this, jtpCode, title, ".comp");
		
		Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
		
		Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{"número", "color", "adelante", "atrás",
                "izquierda", "derecha", "norte", "sur", "este", "oeste", "pintar", "detenerPintar",
                "tomar", "poner", "lanzarMoneda"}, jtpCode, () -> {
                timerKeyReleased.restart();
            });
		
	}
	
    @SuppressWarnings("unchecked")
	public void initComponentes() {
		titulo = new Label("Compilador");
		logo = new JLabel("");
		jtpCode = new JTextPane();
		tblTokens = new JTable();
		jtaOutputConsole = new JTextArea();
		
		scrollPane = new JScrollPane();
		scrollPane_1 = new JScrollPane();
		scrollPane_2 = new JScrollPane();

		btnAbrir = new JButton("Abrir");
		btnNuevo = new JButton("Nuevo");
		btnGuardar = new JButton("Guardar");
		btnGuardarC = new JButton("Guardar como");
		btnEjecutar = new JButton("Ejecutar");
		btnCompilar = new JButton("Compilar");
		
		configurar();
		
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAbrirActionPerformed(evt);
			}
		});
				
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				 btnGuardarActionPerformed(evt);
			}
		});
		
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnEjecutarActionPerformed(evt);
			}
		});
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnNuevoActionPerformed(evt);			
			}
		});
		
		btnGuardarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				 btnGuardarCActionPerformed(evt);
			}
		});
		btnCompilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCompilarActionPerformed(evt);
			}
		});
	    
	}
	
	private void configurar() {
		scrollPane.setBorder(null);
		jtpCode.setBorder(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1254, 699);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 35, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		titulo.setFont(new Font("Courier New", Font.BOLD, 38));
		titulo.setForeground(new Color(255, 221, 204));
		jtaOutputConsole.setEnabled(false);
        jtaOutputConsole.setBackground(new Color(255, 255, 255));
		//jtaOutputConsole.setSelectedTextColor(new Color(244, 244, 244));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
		scrollPane_2.setViewportView(jtaOutputConsole);

		btnAbrir.setBorderPainted(false);
		btnAbrir.setBorder(UIManager.getBorder("Button.border"));
		btnAbrir.setBackground(new Color(255, 174, 125));
		btnAbrir.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnNuevo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNuevo.setIconTextGap(2);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNuevo.setBorderPainted(false);
		btnNuevo.setBorder(UIManager.getBorder("Button.border"));
		btnNuevo.setBackground(new Color(255, 174, 125));
		
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardar.setBorderPainted(false);
		btnGuardar.setBorder(UIManager.getBorder("Button.border"));
		btnGuardar.setBackground(new Color(255, 174, 125));
		
		logo.setIcon(new ImageIcon(Compilador.class.getResource("/com/ucema/iconos/logoC.jpg")));
		
		btnGuardarC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardarC.setBorderPainted(false);
		btnGuardarC.setBorder(UIManager.getBorder("Button.border"));
		btnGuardarC.setBackground(new Color(255, 174, 125));
		
		btnCompilar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCompilar.setBorderPainted(false);
		btnCompilar.setBorder(UIManager.getBorder("Button.border"));
		btnCompilar.setBackground(new Color(255, 145, 77));
		
		btnEjecutar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEjecutar.setBorderPainted(false);
		btnEjecutar.setBorder(UIManager.getBorder("Button.border"));
		btnEjecutar.setBackground(new Color(255, 255, 170));
		scrollPane.setViewportView(jtpCode);
				
		tblTokens.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Componente léxico", "Lexema", "[Línea, Columna]"}) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
		scrollPane_1.setViewportView(tblTokens);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addComponent(logo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(titulo, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(btnNuevo, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnAbrir, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnGuardarC, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addGap(92)
							.addComponent(btnCompilar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnEjecutar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 827, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 827, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(172, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(logo, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(titulo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNuevo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAbrir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGuardarC, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCompilar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEjecutar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(236, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	 private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
	            colorAnalysis();
	            clearFields();
        }
	}
	
	 private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
	            clearFields();
        }
	 }
	 
	 private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
	            clearFields();
        }
	 }
	 
	 private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
	}
	 
	 private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
	        directorio.New();
	        clearFields();
	 }
	 
	 private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
		 btnCompilar.doClick();
	        if (codeHasBeenCompiled) {
	            if (errors.size() > 0) {
	                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
	                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
	            } else {
	                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
	                System.out.println(codeBlock);
	                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
	                System.out.println(blocksOfCode);
	                executeCode(blocksOfCode, 1);
	            }
	        }
    }
	 
	 private void executeCode(ArrayList<String> blocksOfCode, int repeats) {
        for (int j = 1; j <= repeats; j++) {
        int repeatCode = -1;
        for (int i = 0; i < blocksOfCode.size(); i++) {
            String blockOfCode = blocksOfCode.get(i);
            if (repeatCode != -1) {
                int[] posicionMarcador = CodeBlock.getPositionOfBothMarkers(blocksOfCode, blockOfCode);
                executeCode(new ArrayList<>(blocksOfCode.subList(posicionMarcador[0], posicionMarcador[1])), repeatCode);
                repeatCode = -1;
                i = posicionMarcador[1];
            } else {
                String[] sentences = blockOfCode.split(";");
                for (String sentence : sentences) {
                    sentence = sentence.trim();
                    // Llamar código de ejecución (arduino, gráfico, etc)
                    if (sentence.startsWith("pintar")) {
                        String parametro;
                        if (sentence.contains("$")) {
                            parametro = identificadores.get(sentence.substring(9, sentence.length() - 2));
                        } else {
                            parametro = sentence.substring(9, sentence.length() - 2);
                        }
                        System.out.println("Pintando de color " + parametro + "...");
                    } else if (sentence.startsWith("izquierda")) {
                        System.out.println("Moviéndose a la izquierda...");
                    } else if (sentence.startsWith("derecha")) {
                        System.out.println("Moviéndose a la derecha...");
                    } else if (sentence.startsWith("adelante")) {
                        System.out.println("Moviéndose hacia adelante");
                    } else if (sentence.contains("-->")) {
                        String[] identComp = sentence.split(" ");
                        System.out.println("Declarando identificador " + identComp[1] + " igual a " + identComp[3]);
                    } else if (sentence.startsWith("atrás")) {
                        System.out.println("Moviéndose hacia atrás");
                    } else if (sentence.startsWith("imprimir")) {
                        System.out.println("imprimir ...");
                    } else if (sentence.startsWith("repetir")) {
                        String parametro;
                        if (sentence.contains("$")) {
                            parametro = identificadores.get(sentence.substring(10, sentence.length() - 2));
                        } else {
                            parametro = sentence.substring(10, sentence.length() - 2);
                        }
                        repeatCode = Integer.parseInt(parametro);
                    }
                }
            }
        }
       }
    }

	 private void clearFields() {
	    Functions.clearDataInTable(tblTokens);
	    jtaOutputConsole.setText("");
	    tokens.clear();
	    errors.clear();
	    identProd.clear();
	    identificadores.clear();
	    codeHasBeenCompiled = false;
	}
	 
	 private void colorAnalysis() {
        textsColor.clear();
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
	    Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
	 }
	 
	 private void compile() {
	    clearFields();
	    lexicalAnalysis();
	    fillTableTokens();
	    syntacticAnalysis();
	    semanticAnalysis();
	    printConsole();
	    codeHasBeenCompiled = true;
    }
	 
	 private void lexicalAnalysis() {
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }
	 
	 private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }
	 
	 private void syntacticAnalysis() {
	        Grammar gramatica = new Grammar(tokens, errors);

	        /* Deshabilitar mensajes y validaciones */
	        gramatica.disableMessages();
	        gramatica.disableValidations();

	        /* Eliminación de errores */
	        gramatica.delete(new String[]{"ERROR", "ERROR_1", "ERROR_2"}, 14);

	        /* Agrupación de valores */
	        gramatica.group("VALOR", "(NUMERO | COLOR)", true);

	        /* Declaración de variables */
	        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR OP_ASIG VALOR", true, identProd);
	        gramatica.group("VARIABLE", "TIPO_DATO OP_ASIG VALOR", true,
	                1, " × Error sintáctico {}: falta el identificador en la declaración de variable [#, %]");

	        gramatica.finalLineColumn();

	        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR OP_ASIG", true,
	                2, " × Error sintáctico {}: falta el valor en la declaración de variable [#, %]");

	        gramatica.initialLineColumn();

	        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR VALOR", true,
	                3, " × Error sintáctico {}: falta el operador de asignación en la declaración de variable [#, %]", 2);
	        gramatica.group("VARIABLE", "IDENTIFICADOR OP_ASIG VALOR", true,
	                4, " × Error sintáctico {}: falta el tipo de dato en la declaración de variable [#, %]");

	        /* Eliminación de tipos de datos y operadores de asignación */
	        gramatica.delete("TIPO_DATO",
	                5, " × Error sintáctico {}: el tipo de dato no está en la declaración de una variable [#, %]");
	        gramatica.delete("OP_ASIG",
	                6, " × Error sintáctico {}: el operador de asignación no está en la declaración de una variable [#, %]");

	        /* Agrupación de identificadores como valor y definición de parámetros */
	        gramatica.group("VALOR", "IDENTIFICADOR", true);
	        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");

	        /* Agrupación de funciones */
	        gramatica.group("FUNCION", "(MOVIMIENTO | PINTAR | DETENER_PINTAR |"
	                + " TOMAR | LANZAR_MONEDA | VER | DETENER_REPETIR )", true);
	        gramatica.group("FUNCION_COMP", "FUNCION PARENTESIS_A (VALOR | PARAMETROS)? PARENTESIS_C", true);
	        gramatica.group("FUNCION_COMP", "FUNCION (VALOR | PARAMETROS)? PARENTESIS_C", true,
	                7, " × Error sintáctico {}: falta el paréntesis que abre en la función [#, %]");
	        gramatica.finalLineColumn();
	        gramatica.group("FUNCION_COMP", "FUNCION PARENTESIS_A (VALOR | PARAMETROS)", true,
	                8, " × Error sintáctico {}: falta el paréntesis que cierra en la función [#, %]");

	        gramatica.initialLineColumn();

	        /* Eliminación de funciones mal declaradas */
	        gramatica.delete("FUNCION",
	                9, " × Error sintáctico {}: La función no está declarada correctamente [#, %]");

	        /* Expresiones lógicas */
	        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
	            gramatica.group("EXP_LOGICA", "(EXP_LOGICA | FUNCION_COMP) (OP_LOGICO (EXP_LOGICA | FUNCION_COMP))+");
	            gramatica.group("EXP_LOGICA", "PARENTESIS_A (EXP_LOGICA | FUNCION_COMP) PARENTESIS_C", true);
	        });

	        /* Eliminación de operadores lógicos */
	        gramatica.delete("OP_LOGICO",
	                10, " × Error sintáctico {}: El operador lógico no está contenido en una expresión [#, %]");

	        /* Agrupación de expresiones lógicas como valores y parámetros */
	        gramatica.group("VALOR", "EXP_LOGICA", true);
	        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");

	        /* Agrupación de estructuras de control */
	        gramatica.group("EST_CONTROL", "(REPETIR | ESTRUCTURA_SI)", true);
	        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL (VALOR | PARAMETROS)", true);
	        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_A PARENTESIS_C", true);
	        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_A (VALOR | PARAMETROS) PARENTESIS_C", true);
	        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL (VALOR | PARAMETROS) PARENTESIS_C", true,
	                11, " × Error sintáctico {}: falta el paréntesis que abre en la estructura [#, %]");
	        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_C", true,
	                12, " × Error sintáctico {}: falta el paréntesis que abre en la estructura [#, %]");
	        gramatica.finalLineColumn();
	        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_A (VALOR | PARAMETROS)", true,
	                13, " × Error sintáctico {}: falta el paréntesis que cierra en la estructura [#, %]");
	        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_A", true,
	                14, " × Error sintáctico {}: falta el paréntesis que cierra en la estructura [#, %]");

	        gramatica.initialLineColumn();

	        /* Eliminación de estructuras de control mal declaradas */
	        gramatica.delete("EST_CONTROL",
	                15, " × Error sintáctico {}: La estructura de control no está declarada correctamente [#, %]");

	        /* Eliminación de paréntesis */
	        gramatica.delete(new String[]{"PARENTESIS_A", "PARENTESIS_C"},
	                16, " × Error sintáctico {}: El paréntesis [] no está contenido en una agrupación [#, %]");

	        /* Eliminación de valores */
	        gramatica.delete("VALOR",
	                17, " × Error sintáctico {}: El valor no está contenido en una función o estructura de control [#, %]");

	        gramatica.finalLineColumn();

	        /* Verificación de punto y coma al final de la sentencia */
	        // Identificadores
	        gramatica.group("VARIABLE_PC", "VARIABLE PUNTO_COMA", true);
	        gramatica.group("VARIABLE_PC", "VARIABLE", true,
	                18, " × Error sintáctico {}: falta el punto y coma al final de la declaración de variable [#, %]");
	        // Funciones
	        gramatica.group("FUNCION_COMP_PC", "FUNCION_COMP PUNTO_COMA", true);
	        gramatica.group("FUNCION_COMP_PC", "FUNCION_COMP", true,
	                19, " × Error sintáctico {}: falta el punto y coma al final de la declaración de función [#, %]");

	        gramatica.initialLineColumn();

	        /* Eliminación de punto y coma */
	        gramatica.delete("PUNTO_COMA",
	                20, " × Error sintáctico {}: el punto y coma no está al final de una sentencia [#, %]");

	        /* Agrupación de sentencias */
	        gramatica.group("SENTENCIAS", "(VARIABLE_PC | FUNCION_COMP_PC)+");
	        /* Estructuras de control completas */
	        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
	            gramatica.group("EST_CONTROL_COMP_LASLC", "EST_CONTROL_COMP LLAVE_A (SENTENCIAS)? LLAVE_C", true);
	            gramatica.group("SENTENCIAS", "(SENTENCIAS | EST_CONTROL_COMP_LASLC)+");
	        });

	        /* Estructuras de control incompletas */
	        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
	            gramatica.initialLineColumn();

	            gramatica.group("EST_CONTROL_COMP_LASLC", "EST_CONTROL_COMP (SENTENCIAS)? LLAVE_C", true,
	                    21, " × Error sintáctico {}: falta la llave que abre en la estructura de control [#, %]");

	            gramatica.finalLineColumn();

	            gramatica.group("EST_CONTROL_COMP_LASLC", "EST_CONTROL_COMP LLAVE_A SENTENCIAS",
	                    22, " × Error sintáctico {}: falta la llave que cierra en la estructura de control [#, %]");
	            gramatica.group("SENTENCIAS", "(SENTENCIAS | EST_CONTROL_COMP_LASLC)+");
	        });

	        /* Eliminación de llaves */
	        gramatica.delete(new String[]{"LLAVE_A", "LLAVE_C"},
	                23, " × Error sintáctico {}: la llave no está contenida en una agrupación [#, %]");

	        /* Mostrar gramáticas */
	         gramatica.show();
	    }

	 
	 private void semanticAnalysis() {
		 HashMap<String, String> identDataType = new HashMap<>();
	        identDataType.put("color", "COLOR");
	        identDataType.put("número", "NUMERO");
	        for (Production id : identProd) {
	            if (!identDataType.get(id.lexemeRank(0)).equals(id.lexicalCompRank(-1))) {
	                errors.add(new ErrorLSSL(1, " × Error semántico {}: valor no compatible con el tipo de dato [#, %]", id, true));
	            }
	            if (id.lexicalCompRank(-1).equals("COLOR") && !id.lexemeRank(-1).matches("#[0-9a-fA-F]+")) {
	                errors.add(new ErrorLSSL(2, " × Error lógico {}: el color no es un número hexadecimal [#, %]", id, false));
	            }
	            identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
	        }
	 }
	 
	 private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }
}
