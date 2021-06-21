package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public class STDivision implements ScrabbleType                                                                             {
    private ScrabbleType x;
    private ScrabbleType y;

    public STDivision(STNumber x, STNumber y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public ScrabbleType GetResult()
    {
        var X = x.GetResult();
        var Y = y.GetResult();
        return X.divide(Y);
    }
}
