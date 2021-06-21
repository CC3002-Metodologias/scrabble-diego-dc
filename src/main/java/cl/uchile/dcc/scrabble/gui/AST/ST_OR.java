package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public class ST_OR implements ScrabbleType{
    private STNumber x;
    private STNumber y;

    public ST_OR(STNumber x, STNumber y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public ScrabbleType GetResult()
    {
        var X = x.GetResult();
        var Y = y.GetResult();
        return X.disjunction(Y);
    }
}
