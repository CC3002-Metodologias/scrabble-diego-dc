package cl.uchile.dcc.scrabble.model.Flyweight.STFactory;

import cl.uchile.dcc.scrabble.model.Flyweight.ScrabbleTypeFlyweight;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.ScrabbleType;

/**
 * Specialized Factory to create STInt
 *
 * @author Diego Caviedes A.
 */

public class STIntFactory {

    /**
     * Creates or returns the reference to the expected STInt
     *
     * @param value
     *      int value the STInt will contain.
     */
    public STInt make(int value) {
        // check if the value already exists even before a Builder is created.
        ScrabbleType result = ScrabbleTypeFlyweight.checkDictionary(value);
        if (result == null)
        {
            result = new STInt.int_builder(value).build();
        }
        return (STInt)result;
    }
}
