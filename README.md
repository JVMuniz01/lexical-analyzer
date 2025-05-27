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

INT_TYPE: Integer type
DOUBLE_TYPE: Double type
CHAR_TYPE: Character type
IDENTIFIER_TYPE: Identifier
RELATIONAL_OPERATOR_TYPE: Relational operator
ARITHMETIC_OPERATOR_TYPE: Arithmetic operator
SPECIAL_CHARACTER_TYPE: Special character
RESERVED_WORD_TYPE: Reserved word
ASSIGNMENT_OPERATOR_TYPE: Assignment operator
RAISED_CAIO_TYPE: Special token "RAISED CAIO"
TOKEN_A: Special token "TOKEN A"
RING_0: Special token "RING 0"
STRING_TYPE: String type
END_CODE_TYPE: Token indicating end of source code
The Token class also implements methods to represent the token as a string.

<h2>🔀 Key Features</h2>
📋 User CRUD operations

🛍️ Order/product/category registration and relationships

💳 Payment-order association

📦 Order item management with quantity and price control

📅 ISO 8601 date formatting

🔒 Global exception handling

🔐 JWT security

JWT secret and expiration configuration

Future implementation for token-based authentication/authorization
