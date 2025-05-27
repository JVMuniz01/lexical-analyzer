package src.lexical.analyzer;

import lexicalAnalysis.Lexicon;
import syntheticAnalysis.Synthetic;

public class LexicalAnalyzer {

    public static void main(String[] args) {
        Lexicon lexicon = new Lexicon("C:\\ws-sts\\lexical-analyzer\\src\\main\\java\\src\\lexical\\analyzer\\code.txt");
        Synthetic synthetic = new Synthetic(lexicon);
        synthetic.s();
    }
}
