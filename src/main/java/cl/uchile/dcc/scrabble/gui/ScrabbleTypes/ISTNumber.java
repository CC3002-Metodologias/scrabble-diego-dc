package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;

/**
 * Interface ScrabbleType-Numbers.
 * <p>Includes all ScrabbleTypes with a numerical behaviour;
 * Allow basic operations with main numerical types:
 * ScrabbleType-Int and ScrabbleType-Float</p>
 *
 * @author Diego Caviedes A.
 */

public interface ISTNumber extends ScrabbleType {

    /** Can be added to a ScrabbleType-Int */
    STNumber addToInteger(STInt scrabbleInt);
    /** Can be added to a ScrabbleType-Float */
    STNumber addToFloat(STFloat scrabbleFloat);


    /** Can be subtracted to a ScrabbleType-Int */
    STNumber subtractToInteger(STInt scrabbleInt);
    /** Can be subtracted to a ScrabbleType-Float */
    STNumber subtractToFloat(STFloat scrabbleFloat);


    /** Can be multiplied to a ScrabbleType-Int */
    STNumber multiplyToInteger(STInt scrabbleInt);
    /** Can be multiplied to a ScrabbleType-Float */
    STNumber multiplyToFloat(STFloat scrabbleFloat);


    /** Can be divided to a ScrabbleType-Int */
    STNumber divideToInteger(STInt scrabbleInt);
    /** Can be divided to a ScrabbleType-Float */
    STNumber divideToFloat(STFloat scrabbleFloat);


}
