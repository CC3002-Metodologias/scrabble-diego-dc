package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

import java.util.ArrayList;
import java.util.List;

public abstract class STOperation implements ScrabbleType{
    protected List<ScrabbleType> children = new ArrayList<>();

    @Override
    public String STtoString() {
        return null;
    }

    @Override
    public STString toSTString() {
        return null;
    }

    @Override
    public STString addToString(STString scrabbleStr) {
        return null;
    }

    @Override
    public ScrabbleType GetResult() {
        return null;
    }



}
