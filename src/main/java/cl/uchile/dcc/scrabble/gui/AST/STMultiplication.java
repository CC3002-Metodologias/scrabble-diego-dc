package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public class STMultiplication implements NumericalNode {
    private NumericalNode x;
    private NumericalNode y;

    public STMultiplication(NumericalNode x, NumericalNode y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public NumericalNode GetResult()
    {
        var X = x.GetResult();
        var Y = y.GetResult();
        return X.Multiply(Y);
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
