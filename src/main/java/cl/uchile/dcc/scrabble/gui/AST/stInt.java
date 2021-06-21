package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public class stInt implements NumericalNode{
    STInt mySTInt;

    public stInt(int mySTInt) {
        this.mySTInt.setMyInt(mySTInt);
    }

    @Override
    public ScrabbleType NodeToST() {
        return mySTInt;
    }

    @Override
    public NumericalNode GetResult() {
        return this;
    }

    @Override
    public ScrabbleNode StrAdd(ScrabbleNode y) {
        return null;
    }

    @Override
    public ScrabbleNode And(ScrabbleNode y) {
        return null;
    }

    @Override
    public ScrabbleNode Or(ScrabbleNode y) {
        return null;
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
