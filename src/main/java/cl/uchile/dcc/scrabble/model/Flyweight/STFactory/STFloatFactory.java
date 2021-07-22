package cl.uchile.dcc.scrabble.model.Flyweight.STFactory;

import cl.uchile.dcc.scrabble.model.Flyweight.ScrabbleTypeFlyweight;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.ScrabbleType;

/**
 * Specialized Factory to create STFloat
 *
 * @author Diego Caviedes A.
 */

public class STFloatFactory {

    /**
     * Creates or returns the reference to the expected STFloat
     *
     * @param value
     *      double value the STFloat will contain.
     */
    public STFloat make(double value) {
        // check if the value already exists even before a Builder is created.
        ScrabbleType result = ScrabbleTypeFlyweight.checkDictionary(value);
        if (result == null)
        {
            result = new STFloat.float_builder(value).build();
        }
        return (STFloat)result;
    }
}
