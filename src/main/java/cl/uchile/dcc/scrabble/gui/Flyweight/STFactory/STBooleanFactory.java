package cl.uchile.dcc.scrabble.gui.Flyweight.STFactory;

import cl.uchile.dcc.scrabble.gui.Flyweight.ScrabbleTypeFlyweight;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public class STBooleanFactory {

    public STBoolean make(boolean value) {
        // check if the value already exists even before a Builder is created.
        ScrabbleType result = ScrabbleTypeFlyweight.checkDictionary(value);
        if (result == null)
        {
            result = new STBoolean.boolean_builder(value).build();
        }
        return (STBoolean)result;
    }
}
