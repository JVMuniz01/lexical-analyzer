<h1>💼 Compiler - Linguagens Formais</h1>

This compiler is developed in Java and consists of three main parts: lexical analysis, syntactic analysis, and semantic analysis. 
The goal of the compiler is to analyze source code written in a specific language and produce an intermediate representation or perform actions based on that analysis.

<h2>📌 Group</h2>
João Victor Muniz Rocha<br>
Davi Rocha de Barros Carvalho


<h2>🧱 Lexical Analysis</h2>
Lexical analysis is the first phase of the compilation process, where the source code is scanned and converted into tokens. 
Each token represents a lexical element of the language, such as keywords, identifiers, operators, etc. The provided source code implements this analysis in two main classes: Token and Lexicon.

<h2>📂 Class Token </h2>
The Token class defines the possible token types and provides methods to get the lexeme and type of a token. The token types are:

INT_TYPE: Integer type<br>
DOUBLE_TYPE: Double type<br>
CHAR_TYPE: Character type<br>
IDENTIFIER_TYPE: Identifier<br>
RELATIONAL_OPERATOR_TYPE: Relational operator<br>
ARITHMETIC_OPERATOR_TYPE: Arithmetic operator<br>
SPECIAL_CHARACTER_TYPE: Special character<br>
RESERVED_WORD_TYPE: Reserved word<br>
ASSIGNMENT_OPERATOR_TYPE: Assignment operator<br>
STRING_TYPE: String type<br>
END_CODE_TYPE: Token indicating end of source code<br>
The Token class also implements methods to represent the token as a string.<br>

<h2>🔀 Supported Languages</h2>
Based on the current implementation, the compiler is able to handle a language that includes:

Data types: int, double, char, string<br>
Arithmetic operators: +, -, *, /, %<br>
Relational operators: <, >, <=, >=, ==<br>
Assignment operator: =<br>
Keywords: int, double, float, char, String, Integer, if, else, while, for, main, Boolean<br>
Special characters: (, ), {, }, ,, ;<br>
Identifiers and character and string literals.<br>
This compiler can be extended to support more language features and constructs as needed.<br>
