package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public class STAddition implements NumericalNode{
    private NumericalNode x;
    private NumericalNode y;

    public STAddition(NumericalNode x , NumericalNode y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public NumericalNode GetResult()
    {
        var X = x.GetResult();
        var Y = y.GetResult();
        return X.Add(Y);
    }

    @Override
    public String NodeToString() {
        return null;
    }

    @Override
    public NumericalNode Add(NumericalNode y) {
        return null;
    }

    @Override
    public NumericalNode Subtract(NumericalNode y) {
        return null;
    }

    @Override
    public NumericalNode Multiply(NumericalNode y) {
        return null;
    }

    @Override
    public NumericalNode Divide(NumericalNode y) {
        return null;
    }
}
