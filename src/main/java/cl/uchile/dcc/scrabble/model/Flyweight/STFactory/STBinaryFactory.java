package cl.uchile.dcc.scrabble.model.Flyweight.STFactory;

import cl.uchile.dcc.scrabble.model.Flyweight.ScrabbleTypeFlyweight;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.ScrabbleType;

/**
 * Specialized Factory to create STBinary
 *
 * @author Diego Caviedes A.
 */

public class STBinaryFactory {

    /**
     * Creates or returns the reference to the expected STBinary
     *
     * @param value
     *      String value the STBinary will contain.
     */
    public STBinary make(String value) {
        // check if the value already exists even before a Builder is created.
        ScrabbleType result = ScrabbleTypeFlyweight.checkDictionary(value + "b");
        if (result == null)
        {
            result = new STBinary.binary_builder(value).build();
        }
        return (STBinary)result;
    }
}
