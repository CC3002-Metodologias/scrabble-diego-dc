package cl.uchile.dcc.scrabble.gui.Flyweight.STFactory;

import cl.uchile.dcc.scrabble.gui.Flyweight.ScrabbleTypeFlyweight;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

/**
 * Specialized Factory to create STBoolean
 *
 * @author Diego Caviedes A.
 */

public class STBooleanFactory {

    /**
     * Creates or returns the reference to the expected STBoolean
     *
     * @param value
     *      boolean value the STBoolean will contain.
     */
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
