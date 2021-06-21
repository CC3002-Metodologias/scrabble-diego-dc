package cl.uchile.dcc.scrabble.gui.AST;

public interface NumericalNode extends ScrabbleNode{

    @Override
    NumericalNode GetResult();

    NumericalNode Add(NumericalNode y);
    NumericalNode Subtract(NumericalNode y);
    NumericalNode Multiply(NumericalNode y);
    NumericalNode Divide(NumericalNode y);

}
