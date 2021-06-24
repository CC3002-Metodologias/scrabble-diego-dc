package cl.uchile.dcc.scrabble.gui.Flyweight;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

import java.util.HashMap;

public class ScrabbleTypeFlyweight {

    static HashMap<Object, ScrabbleType> scrabbleTypes = new HashMap<>();


    public static ScrabbleType checkDictionary(Object key){
        return scrabbleTypes.get(key);
    }

    public static void addElement(Object key, ScrabbleType st)
    {
        scrabbleTypes.put(key, st);
    }

}
