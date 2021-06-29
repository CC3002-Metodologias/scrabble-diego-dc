package cl.uchile.dcc.scrabble.gui.Flyweight.STFactory;

import cl.uchile.dcc.scrabble.gui.Flyweight.ScrabbleTypeFlyweight;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

/**
 * Specialized Factory to create STString
 *
 * @author Diego Caviedes A.
 */

public class STStringFactory extends STFactory{

    /**
     * Creates or returns the reference to the expected STString
     *
     * @param value
     *      String value the STString will contain.
     */
    public STString make(String value) {
        // check if the value already exists even before a Builder is created.
        ScrabbleType result = ScrabbleTypeFlyweight.checkDictionary(value);
        if (result == null)
        {
            result = new STString.string_builder(value).build();
        }
        return (STString)result;
    }
}
