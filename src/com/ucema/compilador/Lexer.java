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
    "\11\0\1\1\1\2\1\3\1\4\1\5\22\0\1\1"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\0\1\23\1\24"+
    "\11\25\1\26\1\27\1\30\1\31\1\32\2\0\1\33"+
    "\1\34\1\35\1\33\1\36\6\33\1\37\1\40\1\41"+
    "\1\42\1\43\12\33\1\44\1\45\1\46\1\0\1\33"+
    "\1\0\1\47\1\50\1\51\1\52\1\53\1\54\1\55"+
    "\1\56\1\57\2\33\1\60\1\61\1\62\1\63\1\64"+
    "\1\65\1\66\1\67\1\70\1\71\4\33\1\72\1\73"+
    "\1\74\1\75\7\0\1\3\73\0\1\33\7\0\1\33"+
    "\3\0\1\33\3\0\1\33\1\0\1\33\6\0\1\33"+
    "\1\0\1\33\4\0\1\76\7\0\1\33\3\0\1\33"+
    "\3\0\1\33\1\0\1\33\6\0\1\33\1\0\1\33"+
    "\u012b\0\2\3\326\0\u0100\3";

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
    "\1\0\1\1\2\2\1\3\1\4\2\1\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\1"+
    "\2\16\1\17\1\20\1\21\1\22\1\23\2\24\1\25"+
    "\1\26\15\24\1\27\1\6\1\30\1\31\1\0\1\32"+
    "\2\0\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\0\1\2\1\43\1\44\1\45\1\46\1\47"+
    "\21\24\1\50\2\24\1\51\1\0\1\52\2\0\23\24"+
    "\1\53\1\24\2\0\1\2\21\24\1\50\1\0\2\24"+
    "\1\54\2\24\1\55\7\24\1\56\2\24\1\0\7\24"+
    "\1\57\2\24\1\60\1\53\6\24\1\61\3\24\1\62"+
    "\3\24\1\63\26\24\1\64\7\24\1\65\1\24\1\66"+
    "\1\24\1\67\5\24\1\61";

  private static int [] zzUnpackAction() {
    int [] result = new int[218];
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
    "\0\0\0\77\0\77\0\176\0\275\0\374\0\u013b\0\u017a"+
    "\0\u01b9\0\u01f8\0\77\0\77\0\77\0\u0237\0\u0276\0\77"+
    "\0\u02b5\0\u02f4\0\u0333\0\u0372\0\77\0\77\0\u03b1\0\u03f0"+
    "\0\u042f\0\u046e\0\u04ad\0\77\0\77\0\u04ec\0\u052b\0\u056a"+
    "\0\u05a9\0\u05e8\0\u0627\0\u0666\0\u06a5\0\u06e4\0\u0723\0\u0762"+
    "\0\u07a1\0\u07e0\0\77\0\u081f\0\77\0\77\0\374\0\77"+
    "\0\u085e\0\u089d\0\u08dc\0\77\0\77\0\77\0\77\0\77"+
    "\0\u091b\0\77\0\u095a\0\u0999\0\77\0\u0333\0\77\0\77"+
    "\0\77\0\u09d8\0\u0a17\0\u0a56\0\u0a95\0\u0ad4\0\u0b13\0\u0b52"+
    "\0\u0b91\0\u0bd0\0\u0c0f\0\u0c4e\0\u0c8d\0\u0ccc\0\u0d0b\0\u0d4a"+
    "\0\u0d89\0\u0dc8\0\u0e07\0\u0e46\0\u0e85\0\77\0\u0ec4\0\77"+
    "\0\u0f03\0\u0f42\0\u0f81\0\u0fc0\0\u0fff\0\u103e\0\u107d\0\u10bc"+
    "\0\u10fb\0\u113a\0\u1179\0\u11b8\0\u11f7\0\u1236\0\u1275\0\u12b4"+
    "\0\u12f3\0\u1332\0\u1371\0\u13b0\0\u13ef\0\u046e\0\u142e\0\u146d"+
    "\0\u14ac\0\u0f03\0\u14eb\0\u152a\0\u1569\0\u15a8\0\u15e7\0\u1626"+
    "\0\u1665\0\u16a4\0\u16e3\0\u1722\0\u1761\0\u17a0\0\u17df\0\u181e"+
    "\0\u185d\0\u189c\0\u18db\0\u046e\0\u191a\0\u1959\0\u1998\0\u046e"+
    "\0\u19d7\0\u1a16\0\u046e\0\u1a55\0\u1a94\0\u1ad3\0\u1b12\0\u1b51"+
    "\0\u1b90\0\u1bcf\0\u046e\0\u1c0e\0\u1c4d\0\u1c8c\0\u1ccb\0\u1d0a"+
    "\0\u1d49\0\u1d88\0\u1dc7\0\u1e06\0\u1e45\0\u046e\0\u1e84\0\u1ec3"+
    "\0\77\0\u1d49\0\u1f02\0\u1f41\0\u1f80\0\u1fbf\0\u1ffe\0\u203d"+
    "\0\u207c\0\u20bb\0\u20fa\0\u2139\0\u046e\0\u2178\0\u21b7\0\u21f6"+
    "\0\u046e\0\u2235\0\u2274\0\u22b3\0\u22f2\0\u2331\0\u2370\0\u23af"+
    "\0\u23ee\0\u242d\0\u246c\0\u24ab\0\u24ea\0\u2529\0\u2568\0\u25a7"+
    "\0\u25e6\0\u2625\0\u2664\0\u26a3\0\u26e2\0\u2721\0\u2760\0\u046e"+
    "\0\u279f\0\u27de\0\u281d\0\u285c\0\u289b\0\u28da\0\u2919\0\u046e"+
    "\0\u2958\0\u046e\0\u2997\0\u046e\0\u29d6\0\u2a15\0\u2a54\0\u2a93"+
    "\0\u2ad2\0\u046e";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[218];
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
    "\1\2\2\3\1\0\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\4\32\1\33\4\32\1\34\1\2\1\35"+
    "\1\36\1\32\1\37\1\40\1\41\1\42\2\32\1\43"+
    "\1\44\1\32\1\45\1\46\1\47\1\32\1\50\1\51"+
    "\1\52\2\32\1\53\1\54\1\55\1\32\101\0\1\3"+
    "\125\0\1\56\45\0\7\57\1\60\35\57\1\61\31\57"+
    "\24\0\2\62\5\0\11\62\3\0\24\62\3\0\1\62"+
    "\33\0\11\63\3\0\24\63\3\0\1\63\31\0\1\64"+
    "\60\0\1\65\114\0\1\66\65\0\1\67\10\0\1\70"+
    "\67\0\1\71\6\0\1\72\64\0\1\73\3\0\1\74"+
    "\5\0\1\75\71\0\2\76\75\0\2\24\102\0\1\77"+
    "\76\0\1\100\76\0\1\101\71\0\2\32\5\0\11\32"+
    "\3\0\24\32\3\0\1\32\7\0\1\57\14\0\2\32"+
    "\5\0\11\32\3\0\24\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\3\32\1\102\15\32\1\103\2\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\1\104"+
    "\13\32\1\105\7\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\4\32\1\106\17\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\20\32\1\107\3\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\10\32\1\110"+
    "\6\32\1\111\4\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\12\32\1\112\1\113\7\32\1\114\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\1\115\23\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\14\32"+
    "\1\116\5\32\1\117\1\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\4\32\1\41\17\32\3\0\1\32"+
    "\24\0\2\32\5\0\11\32\3\0\10\32\1\120\3\32"+
    "\1\121\7\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\4\32\1\122\17\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\10\32\1\123\11\32\1\124\1\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\14\32"+
    "\1\125\7\32\3\0\1\32\74\0\1\126\2\0\2\57"+
    "\4\0\71\57\24\0\2\127\5\0\11\127\3\0\24\127"+
    "\3\0\1\127\24\0\2\63\5\0\11\63\3\0\24\63"+
    "\3\0\1\63\32\0\1\130\44\0\17\131\1\132\57\131"+
    "\2\74\1\3\2\74\1\4\71\74\24\0\2\32\5\0"+
    "\11\32\3\0\4\32\1\133\17\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\17\32\1\134\4\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\3\32\1\135"+
    "\20\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\11\32\1\136\12\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\17\32\1\137\1\32\1\140\2\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\21\32\1\141"+
    "\2\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\13\32\1\142\10\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\4\32\1\143\17\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\15\32\1\144\6\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\21\32\1\145"+
    "\2\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\16\32\1\146\5\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\13\32\1\147\10\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\17\32\1\107\4\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\12\32\1\150"+
    "\11\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\13\32\1\151\10\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\13\32\1\152\10\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\15\32\1\153\3\32\1\154"+
    "\2\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\13\32\1\155\10\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\17\32\1\156\4\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\12\32\1\157\11\32\3\0"+
    "\1\32\24\0\2\160\5\0\11\160\3\0\24\160\3\0"+
    "\1\160\17\131\1\161\76\131\1\161\3\131\1\162\53\131"+
    "\24\0\2\32\5\0\11\32\3\0\11\32\1\163\12\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\24\32"+
    "\3\0\1\164\24\0\2\32\5\0\11\32\3\0\4\32"+
    "\1\165\17\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\14\32\1\166\7\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\4\32\1\167\17\32\3\0\1\32"+
    "\24\0\2\32\5\0\11\32\3\0\4\32\1\170\17\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\4\32"+
    "\1\156\17\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\1\171\23\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\13\32\1\172\10\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\17\32\1\173\4\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\4\32\1\174"+
    "\17\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\22\32\1\175\1\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\23\32\1\176\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\4\32\1\177\17\32\3\0\1\32"+
    "\24\0\2\32\5\0\11\32\3\0\21\32\1\200\2\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\4\32"+
    "\1\201\17\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\4\32\1\202\17\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\14\32\1\203\7\32\3\0\1\32"+
    "\24\0\2\32\5\0\11\32\3\0\14\32\1\204\7\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\1\201"+
    "\23\32\3\0\1\32\24\0\2\205\5\0\11\205\3\0"+
    "\24\205\3\0\1\205\17\131\1\161\3\131\1\3\53\131"+
    "\24\0\2\32\5\0\11\32\3\0\1\206\23\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\20\32\1\156"+
    "\3\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\13\32\1\207\10\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\17\32\1\210\4\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\2\32\1\211\21\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\13\32\1\212"+
    "\10\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\11\32\1\213\12\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\21\32\1\214\2\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\10\32\1\215\13\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\17\32\1\216"+
    "\4\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\10\32\1\217\13\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\1\220\23\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\17\32\1\221\4\32\3\0\1\32"+
    "\24\0\2\32\5\0\11\32\3\0\1\222\23\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\17\32\1\223"+
    "\4\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\21\32\1\224\2\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\17\32\1\225\4\32\3\0\1\32\24\0"+
    "\2\226\5\0\11\226\3\0\24\226\3\0\1\226\24\0"+
    "\2\32\5\0\11\32\3\0\13\32\1\107\10\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\1\210\23\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\7\32"+
    "\1\227\14\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\4\32\1\230\17\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\4\32\1\231\17\32\3\0\1\32"+
    "\24\0\2\32\5\0\11\32\3\0\12\32\1\232\11\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\17\32"+
    "\1\233\4\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\4\32\1\234\17\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\17\32\1\235\4\32\3\0\1\32"+
    "\24\0\2\32\5\0\11\32\3\0\14\32\1\210\7\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\17\32"+
    "\1\236\4\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\10\32\1\237\13\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\13\32\1\240\10\32\3\0\1\32"+
    "\24\0\2\241\5\0\11\241\3\0\24\241\3\0\1\241"+
    "\24\0\2\32\5\0\11\32\3\0\1\242\23\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\17\32\1\243"+
    "\4\32\3\0\1\32\24\0\2\32\5\0\3\32\1\244"+
    "\5\32\3\0\24\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\10\32\1\245\13\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\22\32\1\246\1\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\17\32\1\247"+
    "\4\32\3\0\1\32\24\0\2\32\5\0\5\32\1\250"+
    "\3\32\3\0\24\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\17\32\1\251\4\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\1\252\23\32\3\0\1\32"+
    "\24\0\2\32\5\0\10\32\1\253\3\0\24\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\20\32\1\254"+
    "\3\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\17\32\1\255\4\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\12\32\1\256\11\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\3\32\1\227\20\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\14\32\1\257"+
    "\7\32\3\0\1\32\24\0\2\32\5\0\5\32\1\260"+
    "\3\32\3\0\24\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\17\32\1\261\4\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\10\32\1\262\13\32\3\0"+
    "\1\32\24\0\2\32\5\0\1\32\1\263\1\264\3\32"+
    "\1\265\1\266\1\32\3\0\24\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\15\32\1\267\6\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\13\32\1\270"+
    "\10\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\10\32\1\271\13\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\13\32\1\272\10\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\1\273\10\32\1\274\12\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\11\32"+
    "\1\275\12\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\4\32\1\276\17\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\1\32\1\277\22\32\3\0\1\32"+
    "\24\0\2\32\5\0\11\32\3\0\10\32\1\300\13\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\4\32"+
    "\1\301\17\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\4\32\1\302\17\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\21\32\1\303\2\32\3\0\1\32"+
    "\24\0\2\32\5\0\11\32\3\0\11\32\1\304\12\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\1\305"+
    "\23\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\1\306\23\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\6\32\1\306\15\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\20\32\1\307\3\32\3\0\1\32"+
    "\24\0\2\32\5\0\11\32\3\0\17\32\1\310\4\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\3\32"+
    "\1\311\20\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\13\32\1\312\10\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\1\313\23\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\10\32\1\314\13\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\13\32\1\315"+
    "\10\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\17\32\1\316\4\32\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\21\32\1\317\2\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\1\320\23\32\3\0\1\32"+
    "\24\0\2\32\5\0\11\32\3\0\21\32\1\321\2\32"+
    "\3\0\1\32\24\0\2\32\5\0\11\32\3\0\17\32"+
    "\1\322\4\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\23\32\1\323\3\0\1\32\24\0\2\32\5\0"+
    "\11\32\3\0\2\32\1\316\21\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\14\32\1\324\7\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\24\32\3\0"+
    "\1\325\24\0\2\32\5\0\11\32\3\0\17\32\1\326"+
    "\4\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\1\324\23\32\3\0\1\32\24\0\2\32\5\0\11\32"+
    "\3\0\2\32\1\327\21\32\3\0\1\32\24\0\2\32"+
    "\5\0\11\32\3\0\1\330\23\32\3\0\1\32\24\0"+
    "\2\32\5\0\11\32\3\0\22\32\1\331\1\32\3\0"+
    "\1\32\24\0\2\32\5\0\11\32\3\0\20\32\1\332"+
    "\3\32\3\0\1\32\24\0\2\32\5\0\11\32\3\0"+
    "\11\32\1\316\12\32\3\0\1\32";

  private static int [] zzUnpacktrans() {
    int [] result = new int[11025];
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
    "\1\0\2\11\7\1\3\11\2\1\1\11\4\1\2\11"+
    "\5\1\2\11\15\1\1\11\1\1\2\11\1\0\1\11"+
    "\2\0\1\1\5\11\1\1\1\11\1\0\1\1\1\11"+
    "\1\1\3\11\24\1\1\11\1\0\1\11\2\0\25\1"+
    "\2\0\23\1\1\0\20\1\1\0\12\1\1\11\71\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[218];
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
          case 56: break;
          case 2:
            { /*Ignorar*/
            }
          // fall through
          case 57: break;
          case 3:
            { return token(yytext(), "OP_NEGADOR", yyline, yycolumn);
            }
          // fall through
          case 58: break;
          case 4:
            { return token(yytext(), "COMILLA_DOBLE", yyline, yycolumn);
            }
          // fall through
          case 59: break;
          case 5:
            { return token(yytext(), "OPERADOR_MODULO", yyline, yycolumn);
            }
          // fall through
          case 60: break;
          case 6:
            { return token(yytext(), "OP_LOGICO", yyline, yycolumn);
            }
          // fall through
          case 61: break;
          case 7:
            { return token(yytext(), "COMILLA_SIMPLE", yyline, yycolumn);
            }
          // fall through
          case 62: break;
          case 8:
            { return token(yytext(), "PARENTESIS_A", yyline, yycolumn);
            }
          // fall through
          case 63: break;
          case 9:
            { return token(yytext(), "PARENTESIS_C", yyline, yycolumn);
            }
          // fall through
          case 64: break;
          case 10:
            { return token(yytext(), "OPERADOR_MULTIPLICAR", yyline, yycolumn);
            }
          // fall through
          case 65: break;
          case 11:
            { return token(yytext(), "OPERADOR_SUMA", yyline, yycolumn);
            }
          // fall through
          case 66: break;
          case 12:
            { return token(yytext(), "COMA", yyline, yycolumn);
            }
          // fall through
          case 67: break;
          case 13:
            { return token(yytext(), "OPERADOR_RESTA", yyline, yycolumn);
            }
          // fall through
          case 68: break;
          case 14:
            { return token(yytext(), "NUMERO", yyline, yycolumn);
            }
          // fall through
          case 69: break;
          case 15:
            { return token(yytext(), "DOS_PUNTOS", yyline, yycolumn);
            }
          // fall through
          case 70: break;
          case 16:
            { return token(yytext(), "PUNTO_COMA", yyline, yycolumn);
            }
          // fall through
          case 71: break;
          case 17:
            { return token(yytext(), "OP_MENOR", yyline, yycolumn);
            }
          // fall through
          case 72: break;
          case 18:
            { return token(yytext(), "OP_IGUAL", yyline, yycolumn);
            }
          // fall through
          case 73: break;
          case 19:
            { return token(yytext(), "OP_MAYOR_QUE", yyline, yycolumn);
            }
          // fall through
          case 74: break;
          case 20:
            { return token(yytext(), "ERROR_2", yyline, yycolumn);
            }
          // fall through
          case 75: break;
          case 21:
            { return token(yytext(), "CORCHETE_A", yyline, yycolumn);
            }
          // fall through
          case 76: break;
          case 22:
            { return token(yytext(), "CORCHETE_C", yyline, yycolumn);
            }
          // fall through
          case 77: break;
          case 23:
            { return token(yytext(), "LLAVE_A", yyline, yycolumn);
            }
          // fall through
          case 78: break;
          case 24:
            { return token(yytext(), "LLAVE_C", yyline, yycolumn);
            }
          // fall through
          case 79: break;
          case 25:
            { return token(yytext(), "OP_DIFERENTE", yyline, yycolumn);
            }
          // fall through
          case 80: break;
          case 26:
            { return token(yytext(), "CADENA_ENTRE_COMILLA", yyline, yycolumn);
            }
          // fall through
          case 81: break;
          case 27:
            { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn);
            }
          // fall through
          case 82: break;
          case 28:
            { return token(yytext(), "OP_MODULO_IGUAL", yyline, yycolumn);
            }
          // fall through
          case 83: break;
          case 29:
            { return token(yytext(), "OPERADOR_Y", yyline, yycolumn);
            }
          // fall through
          case 84: break;
          case 30:
            { return token(yytext(), "OP_MULTIPLICAR_IGUAL", yyline, yycolumn);
            }
          // fall through
          case 85: break;
          case 31:
            { return token(yytext(), "OP_INCREMENTO", yyline, yycolumn);
            }
          // fall through
          case 86: break;
          case 32:
            { return token(yytext(), "OP_MAS_IGUAL", yyline, yycolumn);
            }
          // fall through
          case 87: break;
          case 33:
            { return token(yytext(), "OP_DECREMENTO", yyline, yycolumn);
            }
          // fall through
          case 88: break;
          case 34:
            { return token(yytext(), "OP_MENOS_IGUAL", yyline, yycolumn);
            }
          // fall through
          case 89: break;
          case 35:
            { return token(yytext(), "OP_DIVISION_IGUAL", yyline, yycolumn);
            }
          // fall through
          case 90: break;
          case 36:
            { return token(yytext(), "ERROR_1", yyline, yycolumn);
            }
          // fall through
          case 91: break;
          case 37:
            { return token(yytext(), "OP_MENOR_IGUAL", yyline, yycolumn);
            }
          // fall through
          case 92: break;
          case 38:
            { return token(yytext(), "OP_COMPARADOR_IGUAL", yyline, yycolumn);
            }
          // fall through
          case 93: break;
          case 39:
            { return token(yytext(), "OP_MAYOR_IGUAL", yyline, yycolumn);
            }
          // fall through
          case 94: break;
          case 40:
            { return token(yytext(), "ESTRUCTURA_SI", yyline, yycolumn);
            }
          // fall through
          case 95: break;
          case 41:
            { return token(yytext(), "OPERADOR_O", yyline, yycolumn);
            }
          // fall through
          case 96: break;
          case 42:
            { return token (yytext(), "OP_ASIG", yyline, yycolumn);
            }
          // fall through
          case 97: break;
          case 43:
            { return token(yytext(), "MOVIMIENTO", yyline, yycolumn);
            }
          // fall through
          case 98: break;
          case 44:
            { return token(yytext(), "TIPO_DATO", yyline, yycolumn);
            }
          // fall through
          case 99: break;
          case 45:
            { return token(yytext(), "FINAL", yyline, yycolumn);
            }
          // fall through
          case 100: break;
          case 46:
            { return token(yytext(), "TOMAR", yyline, yycolumn);
            }
          // fall through
          case 101: break;
          case 47:
            { return token(yytext(), "PINTAR", yyline, yycolumn);
            }
          // fall through
          case 102: break;
          case 48:
            { return token(yytext(), "COLOR", yyline, yycolumn);
            }
          // fall through
          case 103: break;
          case 49:
            { return token(yytext(), "REPETIR", yyline, yycolumn);
            }
          // fall through
          case 104: break;
          case 50:
            { return token(yytext(), "IMPRIMIR", yyline, yycolumn);
            }
          // fall through
          case 105: break;
          case 51:
            { return token(yytext(), "RETORNAR", yyline, yycolumn);
            }
          // fall through
          case 106: break;
          case 52:
            { return token(yytext(), "DETENER_REPETIR", yyline, yycolumn);
            }
          // fall through
          case 107: break;
          case 53:
            { return token(yytext(), "LANZAR_MONEDA", yyline, yycolumn);
            }
          // fall through
          case 108: break;
          case 54:
            { return token(yytext(), "DETENER_PINTAR", yyline, yycolumn);
            }
          // fall through
          case 109: break;
          case 55:
            { return token(yytext(), "VER", yyline, yycolumn);
            }
          // fall through
          case 110: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
