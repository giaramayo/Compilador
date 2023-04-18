package com.ucema.compilador;


import compilerTools.Token;


@SuppressWarnings("fallthrough")
class Lexer {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\1\1\1\4\22\0\1\1"+
    "\2\0\1\5\1\6\1\0\1\7\1\0\1\10\1\11"+
    "\1\12\1\0\1\13\1\14\1\0\1\15\1\16\11\17"+
    "\1\0\1\20\2\0\1\21\2\0\1\22\1\23\1\24"+
    "\1\22\1\25\7\22\1\26\1\27\1\30\1\31\12\22"+
    "\4\0\1\22\1\0\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\2\22\1\43\1\44\1\45"+
    "\1\46\1\47\1\50\1\51\1\52\1\53\1\54\4\22"+
    "\1\55\1\56\1\7\1\57\7\0\1\3\73\0\1\22"+
    "\7\0\1\22\3\0\1\22\3\0\1\22\1\0\1\22"+
    "\6\0\1\22\1\0\1\22\4\0\1\60\7\0\1\22"+
    "\3\0\1\22\3\0\1\22\1\0\1\22\6\0\1\61"+
    "\1\0\1\22\u012b\0\2\3\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\2\1\1\3\1\4\1\5\1\6"+
    "\2\1\2\7\1\10\16\11\1\12\1\13\1\0\1\14"+
    "\2\0\1\2\1\15\17\11\1\16\2\11\1\0\1\17"+
    "\2\0\20\11\1\20\1\11\2\0\1\2\16\11\1\16"+
    "\1\0\1\11\1\21\2\11\1\22\6\11\1\23\1\11"+
    "\1\0\6\11\1\24\1\11\1\25\1\20\5\11\1\26"+
    "\33\11\1\27\7\11\1\30\1\11\1\31\1\11\1\32"+
    "\5\11\1\26";

  private static int [] zzUnpackAction() {
    int [] result = new int[172];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\62\0\144\0\226\0\310\0\62\0\62"+
    "\0\62\0\62\0\372\0\u012c\0\u015e\0\u0190\0\62\0\u01c2"+
    "\0\u01f4\0\u0226\0\u0258\0\u028a\0\u02bc\0\u02ee\0\u0320\0\u0352"+
    "\0\u0384\0\u03b6\0\u03e8\0\u041a\0\u044c\0\62\0\62\0\u047e"+
    "\0\u04b0\0\u04e2\0\u0514\0\u0546\0\u015e\0\u0578\0\u05aa\0\u05dc"+
    "\0\u060e\0\u0640\0\u0672\0\u06a4\0\u06d6\0\u0708\0\u073a\0\u076c"+
    "\0\u079e\0\u07d0\0\u0802\0\u0834\0\u0866\0\u0898\0\u08ca\0\u08fc"+
    "\0\62\0\u092e\0\u0960\0\u0992\0\u09c4\0\u09f6\0\u0a28\0\u0a5a"+
    "\0\u0a8c\0\u0abe\0\u0af0\0\u0b22\0\u0b54\0\u0b86\0\u0bb8\0\u0bea"+
    "\0\u0c1c\0\u0c4e\0\u0c80\0\u01c2\0\u0cb2\0\u0ce4\0\u0d16\0\u092e"+
    "\0\u0d48\0\u0d7a\0\u0dac\0\u0dde\0\u0e10\0\u0e42\0\u0e74\0\u0ea6"+
    "\0\u0ed8\0\u0f0a\0\u0f3c\0\u0f6e\0\u0fa0\0\u0fd2\0\u01c2\0\u1004"+
    "\0\u1036\0\u01c2\0\u1068\0\u109a\0\u01c2\0\u10cc\0\u10fe\0\u1130"+
    "\0\u1162\0\u1194\0\u11c6\0\u01c2\0\u11f8\0\u122a\0\u125c\0\u128e"+
    "\0\u12c0\0\u12f2\0\u1324\0\u1356\0\u01c2\0\u1388\0\62\0\u12c0"+
    "\0\u13ba\0\u13ec\0\u141e\0\u1450\0\u1482\0\u14b4\0\u14e6\0\u1518"+
    "\0\u154a\0\u157c\0\u15ae\0\u15e0\0\u1612\0\u1644\0\u1676\0\u16a8"+
    "\0\u16da\0\u170c\0\u173e\0\u1770\0\u17a2\0\u17d4\0\u1806\0\u1838"+
    "\0\u186a\0\u189c\0\u18ce\0\u1900\0\u1932\0\u1964\0\u1996\0\u19c8"+
    "\0\u19fa\0\u01c2\0\u1a2c\0\u1a5e\0\u1a90\0\u1ac2\0\u1af4\0\u1b26"+
    "\0\u1b58\0\u01c2\0\u1b8a\0\u01c2\0\u1bbc\0\u01c2\0\u1bee\0\u1c20"+
    "\0\u1c52\0\u1c84\0\u1cb6\0\u01c2";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[172];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\0\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\2\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\2\10\20\1\21\1\20\1\22\1\23\1\24\1\25"+
    "\2\20\1\26\1\27\1\20\1\30\1\31\1\32\1\20"+
    "\1\33\1\34\1\35\2\20\1\36\1\37\2\20\64\0"+
    "\1\3\75\0\2\40\2\0\34\40\2\0\2\40\22\0"+
    "\34\41\2\0\2\41\14\0\1\42\57\0\1\43\2\0"+
    "\1\44\62\0\2\45\60\0\2\16\60\0\2\20\2\0"+
    "\34\20\2\0\2\20\16\0\2\20\2\0\13\20\1\46"+
    "\15\20\1\47\2\20\2\0\2\20\16\0\2\20\2\0"+
    "\24\20\1\50\7\20\2\0\2\20\16\0\2\20\2\0"+
    "\14\20\1\51\17\20\2\0\2\20\16\0\2\20\2\0"+
    "\30\20\1\52\3\20\2\0\2\20\16\0\2\20\2\0"+
    "\20\20\1\53\6\20\1\54\4\20\2\0\2\20\16\0"+
    "\2\20\2\0\23\20\1\55\7\20\1\56\2\0\2\20"+
    "\16\0\2\20\2\0\10\20\1\57\23\20\2\0\2\20"+
    "\16\0\2\20\2\0\24\20\1\60\7\20\2\0\1\20"+
    "\1\61\16\0\2\20\2\0\14\20\1\24\17\20\2\0"+
    "\2\20\16\0\2\20\2\0\20\20\1\62\3\20\1\63"+
    "\7\20\2\0\2\20\16\0\2\20\2\0\14\20\1\64"+
    "\17\20\2\0\2\20\16\0\2\20\2\0\20\20\1\65"+
    "\11\20\1\66\1\20\2\0\2\20\16\0\2\20\2\0"+
    "\24\20\1\67\7\20\2\0\2\20\16\0\2\70\2\0"+
    "\34\70\2\0\2\70\16\0\2\41\2\0\34\41\2\0"+
    "\2\41\21\0\1\71\40\0\12\72\1\73\47\72\2\44"+
    "\1\3\1\44\1\4\55\44\16\0\2\20\2\0\14\20"+
    "\1\74\17\20\2\0\2\20\16\0\2\20\2\0\27\20"+
    "\1\75\4\20\2\0\2\20\16\0\2\20\2\0\21\20"+
    "\1\76\12\20\2\0\2\20\16\0\2\20\2\0\27\20"+
    "\1\77\1\20\1\100\2\20\2\0\2\20\16\0\2\20"+
    "\2\0\31\20\1\101\2\20\2\0\2\20\16\0\2\20"+
    "\2\0\23\20\1\102\10\20\2\0\2\20\16\0\2\20"+
    "\2\0\14\20\1\103\17\20\2\0\2\20\16\0\2\20"+
    "\2\0\31\20\1\104\2\20\2\0\2\20\16\0\2\20"+
    "\2\0\26\20\1\105\5\20\2\0\2\20\16\0\2\20"+
    "\2\0\23\20\1\106\10\20\2\0\2\20\16\0\2\20"+
    "\2\0\27\20\1\52\4\20\2\0\2\20\16\0\2\20"+
    "\2\0\22\20\1\107\11\20\2\0\2\20\16\0\2\20"+
    "\2\0\23\20\1\110\10\20\2\0\2\20\16\0\2\20"+
    "\2\0\23\20\1\111\10\20\2\0\2\20\16\0\2\20"+
    "\2\0\25\20\1\112\6\20\2\0\2\20\16\0\2\20"+
    "\2\0\23\20\1\113\10\20\2\0\2\20\16\0\2\20"+
    "\2\0\27\20\1\114\4\20\2\0\2\20\16\0\2\20"+
    "\2\0\22\20\1\115\11\20\2\0\2\20\16\0\2\116"+
    "\2\0\34\116\2\0\2\116\12\72\1\117\61\72\1\117"+
    "\2\72\1\120\44\72\16\0\2\20\2\0\21\20\1\121"+
    "\12\20\2\0\2\20\16\0\2\20\2\0\34\20\2\0"+
    "\1\122\1\20\16\0\2\20\2\0\24\20\1\123\7\20"+
    "\2\0\2\20\16\0\2\20\2\0\14\20\1\124\17\20"+
    "\2\0\2\20\16\0\2\20\2\0\14\20\1\125\17\20"+
    "\2\0\2\20\16\0\2\20\2\0\14\20\1\114\17\20"+
    "\2\0\2\20\16\0\2\20\2\0\10\20\1\126\23\20"+
    "\2\0\2\20\16\0\2\20\2\0\23\20\1\127\10\20"+
    "\2\0\2\20\16\0\2\20\2\0\14\20\1\130\17\20"+
    "\2\0\2\20\16\0\2\20\2\0\32\20\1\131\1\20"+
    "\2\0\2\20\16\0\2\20\2\0\33\20\1\132\2\0"+
    "\2\20\16\0\2\20\2\0\14\20\1\133\17\20\2\0"+
    "\2\20\16\0\2\20\2\0\31\20\1\134\2\20\2\0"+
    "\2\20\16\0\2\20\2\0\14\20\1\135\17\20\2\0"+
    "\2\20\16\0\2\20\2\0\14\20\1\136\17\20\2\0"+
    "\2\20\16\0\2\20\2\0\24\20\1\137\7\20\2\0"+
    "\2\20\16\0\2\20\2\0\10\20\1\135\23\20\2\0"+
    "\2\20\16\0\2\140\2\0\34\140\2\0\2\140\12\72"+
    "\1\117\2\72\1\3\44\72\16\0\2\20\2\0\10\20"+
    "\1\141\23\20\2\0\2\20\16\0\2\20\2\0\30\20"+
    "\1\114\3\20\2\0\2\20\16\0\2\20\2\0\27\20"+
    "\1\142\4\20\2\0\2\20\16\0\2\20\2\0\12\20"+
    "\1\143\21\20\2\0\2\20\16\0\2\20\2\0\23\20"+
    "\1\144\10\20\2\0\2\20\16\0\2\20\2\0\21\20"+
    "\1\145\12\20\2\0\2\20\16\0\2\20\2\0\31\20"+
    "\1\146\2\20\2\0\2\20\16\0\2\20\2\0\27\20"+
    "\1\147\4\20\2\0\2\20\16\0\2\20\2\0\20\20"+
    "\1\150\13\20\2\0\2\20\16\0\2\20\2\0\10\20"+
    "\1\151\23\20\2\0\2\20\16\0\2\20\2\0\27\20"+
    "\1\152\4\20\2\0\2\20\16\0\2\20\2\0\10\20"+
    "\1\153\23\20\2\0\2\20\16\0\2\20\2\0\27\20"+
    "\1\154\4\20\2\0\2\20\16\0\2\20\2\0\31\20"+
    "\1\155\2\20\2\0\2\20\16\0\2\156\2\0\34\156"+
    "\2\0\2\156\16\0\2\20\2\0\23\20\1\52\10\20"+
    "\2\0\2\20\16\0\2\20\2\0\17\20\1\157\14\20"+
    "\2\0\2\20\16\0\2\20\2\0\14\20\1\160\17\20"+
    "\2\0\2\20\16\0\2\20\2\0\14\20\1\161\17\20"+
    "\2\0\2\20\16\0\2\20\2\0\27\20\1\162\4\20"+
    "\2\0\2\20\16\0\2\20\2\0\14\20\1\163\17\20"+
    "\2\0\2\20\16\0\2\20\2\0\27\20\1\164\4\20"+
    "\2\0\2\20\16\0\2\20\2\0\24\20\1\142\7\20"+
    "\2\0\2\20\16\0\2\20\2\0\27\20\1\165\4\20"+
    "\2\0\2\20\16\0\2\20\2\0\20\20\1\166\13\20"+
    "\2\0\2\20\16\0\2\167\2\0\34\167\2\0\2\167"+
    "\16\0\2\20\2\0\10\20\1\170\23\20\2\0\2\20"+
    "\16\0\2\20\2\0\27\20\1\171\4\20\2\0\2\20"+
    "\16\0\2\20\2\0\3\20\1\172\30\20\2\0\2\20"+
    "\16\0\2\20\2\0\32\20\1\173\1\20\2\0\2\20"+
    "\16\0\2\20\2\0\27\20\1\174\4\20\2\0\2\20"+
    "\16\0\2\20\2\0\4\20\1\175\27\20\2\0\2\20"+
    "\16\0\2\20\2\0\27\20\1\176\4\20\2\0\2\20"+
    "\16\0\2\20\2\0\7\20\1\177\24\20\2\0\2\20"+
    "\16\0\2\20\2\0\30\20\1\200\3\20\2\0\2\20"+
    "\16\0\2\20\2\0\22\20\1\201\11\20\2\0\2\20"+
    "\16\0\2\20\2\0\13\20\1\157\20\20\2\0\2\20"+
    "\16\0\2\20\2\0\24\20\1\202\7\20\2\0\2\20"+
    "\16\0\2\20\2\0\4\20\1\203\27\20\2\0\2\20"+
    "\16\0\2\20\2\0\20\20\1\204\13\20\2\0\2\20"+
    "\16\0\2\20\2\0\1\20\1\205\1\206\2\20\1\207"+
    "\1\210\25\20\2\0\2\20\16\0\2\20\2\0\25\20"+
    "\1\211\6\20\2\0\2\20\16\0\2\20\2\0\23\20"+
    "\1\212\10\20\2\0\2\20\16\0\2\20\2\0\20\20"+
    "\1\213\13\20\2\0\2\20\16\0\2\20\2\0\23\20"+
    "\1\214\10\20\2\0\2\20\16\0\2\20\2\0\10\20"+
    "\1\215\10\20\1\216\12\20\2\0\2\20\16\0\2\20"+
    "\2\0\21\20\1\217\12\20\2\0\2\20\16\0\2\20"+
    "\2\0\14\20\1\220\17\20\2\0\2\20\16\0\2\20"+
    "\2\0\11\20\1\221\22\20\2\0\2\20\16\0\2\20"+
    "\2\0\20\20\1\222\13\20\2\0\2\20\16\0\2\20"+
    "\2\0\14\20\1\223\17\20\2\0\2\20\16\0\2\20"+
    "\2\0\14\20\1\224\17\20\2\0\2\20\16\0\2\20"+
    "\2\0\31\20\1\225\2\20\2\0\2\20\16\0\2\20"+
    "\2\0\21\20\1\226\12\20\2\0\2\20\16\0\2\20"+
    "\2\0\10\20\1\227\23\20\2\0\2\20\16\0\2\20"+
    "\2\0\10\20\1\230\23\20\2\0\2\20\16\0\2\20"+
    "\2\0\16\20\1\230\15\20\2\0\2\20\16\0\2\20"+
    "\2\0\30\20\1\231\3\20\2\0\2\20\16\0\2\20"+
    "\2\0\27\20\1\232\4\20\2\0\2\20\16\0\2\20"+
    "\2\0\13\20\1\233\20\20\2\0\2\20\16\0\2\20"+
    "\2\0\23\20\1\234\10\20\2\0\2\20\16\0\2\20"+
    "\2\0\10\20\1\235\23\20\2\0\2\20\16\0\2\20"+
    "\2\0\20\20\1\236\13\20\2\0\2\20\16\0\2\20"+
    "\2\0\23\20\1\237\10\20\2\0\2\20\16\0\2\20"+
    "\2\0\27\20\1\240\4\20\2\0\2\20\16\0\2\20"+
    "\2\0\31\20\1\241\2\20\2\0\2\20\16\0\2\20"+
    "\2\0\10\20\1\242\23\20\2\0\2\20\16\0\2\20"+
    "\2\0\31\20\1\243\2\20\2\0\2\20\16\0\2\20"+
    "\2\0\27\20\1\244\4\20\2\0\2\20\16\0\2\20"+
    "\2\0\33\20\1\245\2\0\2\20\16\0\2\20\2\0"+
    "\12\20\1\240\21\20\2\0\2\20\16\0\2\20\2\0"+
    "\24\20\1\246\7\20\2\0\2\20\16\0\2\20\2\0"+
    "\34\20\2\0\1\247\1\20\16\0\2\20\2\0\27\20"+
    "\1\250\4\20\2\0\2\20\16\0\2\20\2\0\10\20"+
    "\1\246\23\20\2\0\2\20\16\0\2\20\2\0\12\20"+
    "\1\251\21\20\2\0\2\20\16\0\2\20\2\0\10\20"+
    "\1\252\23\20\2\0\2\20\16\0\2\20\2\0\32\20"+
    "\1\253\1\20\2\0\2\20\16\0\2\20\2\0\30\20"+
    "\1\254\3\20\2\0\2\20\16\0\2\20\2\0\21\20"+
    "\1\240\12\20\2\0\2\20";

  private static int [] zzUnpacktrans() {
    int [] result = new int[7400];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\3\1\4\11\4\1\1\11\16\1\2\11"+
    "\1\0\1\1\2\0\24\1\1\0\1\11\2\0\22\1"+
    "\2\0\20\1\1\0\15\1\1\0\10\1\1\11\65\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[172];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Token yylex() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return token(yytext(), "ERROR", yyline, yycolumn);
            }
          // fall through
          case 27: break;
          case 2:
            { /*Ignorar*/
            }
          // fall through
          case 28: break;
          case 3:
            { return token(yytext(), "OP_LOGICO", yyline, yycolumn);
            }
          // fall through
          case 29: break;
          case 4:
            { return token(yytext(), "PARENTESIS_A", yyline, yycolumn);
            }
          // fall through
          case 30: break;
          case 5:
            { return token(yytext(), "PARENTESIS_C", yyline, yycolumn);
            }
          // fall through
          case 31: break;
          case 6:
            { return token(yytext(), "COMA", yyline, yycolumn);
            }
          // fall through
          case 32: break;
          case 7:
            { return token(yytext(), "NUMERO", yyline, yycolumn);
            }
          // fall through
          case 33: break;
          case 8:
            { return token(yytext(), "PUNTO_COMA", yyline, yycolumn);
            }
          // fall through
          case 34: break;
          case 9:
            { return token(yytext(), "ERROR_2", yyline, yycolumn);
            }
          // fall through
          case 35: break;
          case 10:
            { return token(yytext(), "LLAVE_A", yyline, yycolumn);
            }
          // fall through
          case 36: break;
          case 11:
            { return token(yytext(), "LLAVE_C", yyline, yycolumn);
            }
          // fall through
          case 37: break;
          case 12:
            { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn);
            }
          // fall through
          case 38: break;
          case 13:
            { return token(yytext(), "ERROR_1", yyline, yycolumn);
            }
          // fall through
          case 39: break;
          case 14:
            { return token(yytext(), "ESTRUCTURA_SI", yyline, yycolumn);
            }
          // fall through
          case 40: break;
          case 15:
            { return token (yytext(), "OP_ASIG", yyline, yycolumn);
            }
          // fall through
          case 41: break;
          case 16:
            { return token(yytext(), "MOVIMIENTO", yyline, yycolumn);
            }
          // fall through
          case 42: break;
          case 17:
            { return token(yytext(), "TIPO_DATO", yyline, yycolumn);
            }
          // fall through
          case 43: break;
          case 18:
            { return token(yytext(), "FINAL", yyline, yycolumn);
            }
          // fall through
          case 44: break;
          case 19:
            { return token(yytext(), "TOMAR", yyline, yycolumn);
            }
          // fall through
          case 45: break;
          case 20:
            { return token(yytext(), "PINTAR", yyline, yycolumn);
            }
          // fall through
          case 46: break;
          case 21:
            { return token(yytext(), "COLOR", yyline, yycolumn);
            }
          // fall through
          case 47: break;
          case 22:
            { return token(yytext(), "REPETIR", yyline, yycolumn);
            }
          // fall through
          case 48: break;
          case 23:
            { return token(yytext(), "DETENER_REPETIR", yyline, yycolumn);
            }
          // fall through
          case 49: break;
          case 24:
            { return token(yytext(), "LANZAR_MONEDA", yyline, yycolumn);
            }
          // fall through
          case 50: break;
          case 25:
            { return token(yytext(), "DETENER_PINTAR", yyline, yycolumn);
            }
          // fall through
          case 51: break;
          case 26:
            { return token(yytext(), "VER", yyline, yycolumn);
            }
          // fall through
          case 52: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
