package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

import java.util.ArrayList;
import java.util.List;

public abstract class STOperation implements ScrabbleNode{
    protected List<ScrabbleType> children = new ArrayList<>();


    @Override
    public ScrabbleNode GetResult() {
        return null;
    }

}
