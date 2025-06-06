package lexicalAnalysis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lexicon {
    private char[] content;
    private int contentIndex;
    
    public Lexicon (String sourceCodePath){
        try {
            String strContent;
            strContent = new String(Files.readAllBytes(Paths.get(sourceCodePath)));
            this.content = strContent.toCharArray();
            this.contentIndex = 0;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private char nextChar() {
        char next = content[contentIndex++];
        return next;
    }

    private boolean hasNextChar() {
        return contentIndex < this.content.length;
    }

    
    private void back() {
        this.contentIndex--;
    }

    private char lastChar() {
        char last = content[contentIndex - 1];
        return last;
    }

    private boolean isLetter(char c) {
        return ((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'));
    }

    private boolean isDigit(char c) {
        return (c >= '0') && (c <= '9');
    }
    
    public Token nextToken(){
        Token token = null;
        char c;
        int state = 0;
        StringBuffer lexema = new StringBuffer();
        while(hasNextChar()){
            c = this.nextChar();
            switch (state) {
                case 0:
                    if (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
                        state = 0;
                    } else if (this.isLetter(c) || c == '_') {
                        lexema.append(c);
                        state = 1;
                    } else if (this.isDigit(c)) {
                        lexema.append(c);
                        state = 2;
                    } else if (c == ')' ||
                            c == '(' ||
                            c == '{' ||
                            c == '}' ||
                            c == ',' ||
                            c == ';') {
                        lexema.append(c);
                        state = 5;
                    } else if (c == '\'') {
                        lexema.append(c);
                        state = 6;
                    } else if (c == '/') {
                        char next = this.nextChar();
                        if (next == '/') {
                            lexema.append("//");
                            state = 30;
                        } else if (next == '*') {
                            lexema.append("/*");
                            state = 31;
                        } else {
                            this.back(); // devolve o próximo caractere
                            lexema.append('/');
                            state = 12;
                        }
                    } else if (c == '+' || c == '-' || c == '*' || c == '%') {
                        lexema.append(c);
                        state = 12;
                    }
                     else if (c == '=') {
                        lexema.append(c);
                        state = 13;
                    } else if (c == '<') {
                        lexema.append(c);
                        state = 14;
                    } else if (c == '>') {
                        lexema.append(c);
                        state = 15;
                    } else if (c == 'ç') {
                        lexema.append(c);
                        state = 18;
                    } else if (c == '"') {
                        lexema.append(c);
                        state = 22;
                    } else if (c == '$') {
                        lexema.append(c);
                        state = 99;
                        this.back();
                    } else if (c == '#') {
                        lexema.append(c);
                        state = 20;
                    } else {
                        lexema.append(c);
                        throw new RuntimeException("Erro: token inválido \"" + lexema.toString() + "\"");
                    }
                    break;
                case 1:
                if (this.isLetter(c) || this.isDigit(c) || c == '_') {
                        lexema.append(c);
                        state = 1;
                    }else{
                    this.back();
                        String newLexeme = lexema.toString();
                        if (newLexeme.compareTo("int") == 0 ||
                                newLexeme.compareTo("double") == 0 ||
                                newLexeme.compareTo("float") == 0 ||
                                newLexeme.compareTo("char") == 0 ||
                                newLexeme.compareTo("String") == 0 ||
                                newLexeme.compareTo("Integer") == 0 ||
                                newLexeme.compareTo("if") == 0 ||
                                newLexeme.compareTo("else") == 0 ||
                                newLexeme.compareTo("while") == 0 ||
                                newLexeme.compareTo("for") == 0 ||
                                newLexeme.compareTo("main") == 0 ||
                                newLexeme.compareTo("Boolean") == 0 
                                ) {
                            return new Token(lexema.toString(), Token.RESERVED_WORD_TYPE);
                        }
                        return new Token(lexema.toString(), Token.IDENTIFIER_TYPE);
                }
                break;
                case 2:
                    if (this.isDigit(c)) {
                            lexema.append(c);
                            state = 2;
                        } else if (c == '.') {
                            lexema.append(c);
                            state = 3;
                        } else if (c == '^') {
                            lexema.append(c);
                            state = 16;
                        } else {
                            this.back();
                            return new Token(lexema.toString(), Token.INT_TYPE);
                        }
                        break;    
                    case 3:
                    if (this.isDigit(c)) {
                        lexema.append(c);
                        state = 4;
                    } else {
                        throw new RuntimeException("ERROR: invalid float number! --> \"" + lexema.toString() + "\"");
                    }
                    break;
                case 4:
                    if (this.isDigit(c)) {
                        lexema.append(c);
                        state = 4;
                    } else {
                        this.back();
                        return new Token(lexema.toString(), Token.DOUBLE_TYPE);
                    }
                    break;
                case 5:
                    this.back();
                    return new Token(lexema.toString(), Token.SPECIAL_CHARACTER_TYPE);
                case 6:
                    if (this.isDigit(c) || this.isLetter(c)) {
                        lexema.append(c);
                        state = 7;
                    } else {
                        throw new RuntimeException("ERROR: Incorrect char format! --> \"" + lexema.toString() + "\"");
                    }
                    break;
                case 7:
                    if (c == '\'') {
                        lexema.append(c);
                        state = 8;
                    } else {
                        throw new RuntimeException("ERROR: Incorrect char format! --> \"" + lexema.toString() + "\"");
                    }
                    break;
                case 8:
                    this.back();
                    return new Token(lexema.toString(), Token.CHAR_TYPE);
                case 10:
                    this.back();
                    return new Token(lexema.toString(), Token.RELATIONAL_OPERATOR_TYPE);
                case 11:
                    this.back();
                    return new Token(lexema.toString(), Token.ASSIGNMENT_OPERATOR_TYPE);
                case 12:
                    this.back();
                    return new Token(lexema.toString(), Token.ARITHMETIC_OPERATOR_TYPE);
                case 13:
                    if (c != '=') {
                        this.back();
                        state = 11;
                    } else {
                        lexema.append(c);
                        state = 10;
                    }
                    break;
                case 14:
                    if(c == '<'){
                        throw new RuntimeException(
                            "ERROR: Incorrect operator relational format! --> \"" + lexema.toString() + "\"");
                    }
                    if (c == '>' || c == '=') {
                        lexema.append(c);
                        state = 10;
                    } else {
                        this.back();
                        state = 10;
                    } 
                    
                    break;
                case 15:
                    if (c == '=') {
                        lexema.append(c);
                        state = 10;
                    } else if (c != '=') {
                        this.back();
                        state = 10;
                    } else {
                        throw new RuntimeException(
                                "ERROR: Incorrect operator relational format! --> \"" + lexema.toString() + "\"");
                    }
                    break;                           
                    case 30: 
                        if (c != '\n') {
                            lexema.append(c);
                        } else {
                            this.back();
                            return new Token(lexema.toString(), Token.COMMENT_TYPE);
                        }
                            break;
                case 31:
                    while (hasNextChar()) {
                    c = nextChar();
                    lexema.append(c);
                    if (c == '*') {
                        if (hasNextChar()) {
                            char next = nextChar();
                            lexema.append(next);
                            if (next == '/') {
                    return new Token(lexema.toString(), Token.COMMENT_TYPE);
                }
            }
        }
        if (c == '\n') {
        }
    }                
                case 22:
                    if(c == '"'){
                        lexema.append(c);
                        state = 23;
                    }else{
                        lexema.append(c);
                        state = 22;
                    }
                    break;
                case 23:
                    this.back();
                    return new Token(lexema.toString(), Token.STRING_TYPE);
                case 99:
                    return new Token(lexema.toString(), Token.END_CODE_TYPE);
            }
        }
        return token;
    }
}