package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public class ST_AND implements LogicalNode{
    private STNumber x;
    private STNumber y;

    public ST_AND(STNumber x, STNumber y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public LogicalNode GetResult()
    {
        var X = x.GetResult();
        var Y = y.GetResult();
        return X.conjunction(Y);
    }
}
