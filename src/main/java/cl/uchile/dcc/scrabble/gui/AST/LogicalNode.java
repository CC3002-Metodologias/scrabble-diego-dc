package cl.uchile.dcc.scrabble.gui.AST;

public interface LogicalNode extends ScrabbleNode{

    ScrabbleNode And(ScrabbleNode y);

    ScrabbleNode Or(ScrabbleNode y);
}
