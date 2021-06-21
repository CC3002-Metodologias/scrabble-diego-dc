package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public class stBool implements LogicalNode{
    STBoolean mySTBoolean;

    public stBool(boolean mySTBoolean) {
        this.mySTBoolean.setMyBoolean(mySTBoolean);
    }

    @Override
    public ScrabbleType NodeToST() {
        return mySTBoolean;
    }

    @Override
    public ScrabbleNode GetResult() {
        return this;
    }

    @Override
    public ScrabbleNode StrAdd(ScrabbleNode y) {
        return null;
    }

    @Override
    public ScrabbleNode And(ScrabbleNode y) {
        LogicalNode result;
        result =
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
}
