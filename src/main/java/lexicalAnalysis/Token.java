package lexicalAnalysis;


public class Token {
    public static int INT_TYPE = 0;
    public static int DOUBLE_TYPE = 1;
    public static int CHAR_TYPE = 2;
    public static int IDENTIFIER_TYPE = 3;
    public static int RELATIONAL_OPERATOR_TYPE = 4;
    public static int ARITHMETIC_OPERATOR_TYPE = 5;
    public static int SPECIAL_CHARACTER_TYPE = 6;
    public static int RESERVED_WORD_TYPE = 7;
    public static int ASSIGNMENT_OPERATOR_TYPE = 8;
    public static int STRING_TYPE = 12;
    public static int COMMENT_TYPE = 69;
    public static int END_CODE_TYPE = 99;
    
    private int type;
    private String lexeme;

    public Token(String lexeme, int type) {
        this.lexeme = lexeme;
        this.type = type;
    }

    public String getLexeme() {
        return this.lexeme;
    }

    public int getType() {
        return this.type;
    }

    @Override
    public String toString() {
        switch (this.type) {
            case 0:
                return this.lexeme + " - INT";
            case 1:
                return this.lexeme + " - DOUBLE";
            case 2:
                return this.lexeme + " - CHAR";
            case 3:
                return this.lexeme + " - IDENTIFIER";
            case 4:
                return this.lexeme + " - RELATIONAL OPERATOR";
            case 5:
                return this.lexeme + " - ARITHMETIC OPERATOR";
            case 6:
                return this.lexeme + " - SPECIAL CHARACTER";
            case 7:
                return this.lexeme + " - RESERVED WORD";
            case 8:
                return this.lexeme + " - ASSIGNMENT OPERATOR";
            case 12:
                return this.lexeme + " - STRING";
            case 69:
            return this.lexeme + " - COMMENT";
            case 99:
                return this.lexeme + " - END_CODE";
        }
        return "";
    }

    public String secondToString() {
        switch (this.type) {
            case 0:
                return "INT";
            case 1:
                return "DOUBLE";
            case 2:
                return "CHAR";
            case 3:
                return "IDENTIFIER";
            case 4:
                return "RELATIONAL OPERATOR";
            case 5:
                return "ARITHMETIC OPERATOR";
            case 6:
                return "SPECIAL CHARACTER";
            case 7:
                return "RESERVED WORD";
            case 8:
                return "ASSIGNMENT OPERATOR";
            case 12:
                return "STRING";
            case 69:
            return "COMMENT";
            case 99:
                return "END_CODE";
        }
        return "";
    }

    public String stringText() {
        return this.lexeme.toString();
    }
}