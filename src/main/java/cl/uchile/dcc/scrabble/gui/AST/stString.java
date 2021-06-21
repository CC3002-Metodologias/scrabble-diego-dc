package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public class stString implements ScrabbleNode{
    STString mySTString;

    public stString(String mySTString) {
        this.mySTString.setMyString(mySTString);
    }

    @Override
    public ScrabbleType NodeToST() {
        return mySTString;
    }

    @Override
    public ScrabbleNode GetResult() {
        return this;
    }

    @Override
    public ScrabbleNode StrAdd(ScrabbleNode y) {
        stString result = new stString(this.mySTString.add(y.NodeToST()).toString());
        return result;
    }


    @Override
    public String NodeToString() {
        return null;
    }
}
