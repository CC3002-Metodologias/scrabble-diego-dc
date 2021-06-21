package cl.uchile.dcc.scrabble.gui.AST;


import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public interface ScrabbleNode {

    ScrabbleType NodeToST();

    ScrabbleNode GetResult();

    ScrabbleNode StrAdd(ScrabbleNode y);

    String NodeToString();
}
