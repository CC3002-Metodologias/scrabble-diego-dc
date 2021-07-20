package cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.ScrabbleType;

/**
 * Interface Numerical ScrabbleTypes Compatible with Binary Operations
 * <p>Numerical ScrabbleTypes that allow operations with ScrabbleType-Binary</p>
 *
 * @author Diego Caviedes A.
 */

public interface INumberBinaryCompatible extends ScrabbleType {



    /** This type of STNumber can be transformed to STInt */
    STInt toSTInt();

    /** This type of STNumber can be transformed to STBinary */
    STBinary toSTBinary();

    /** Operates an Addition to a ScrabbleType-Binary */
    STNumber addToBinary(STBinary scrabbleBinary);

    /** Operates a Subtraction to a ScrabbleType-Binary */
    STNumber subtractToBinary(STBinary scrabbleBinary);

    /** Operates a Multiplication to a ScrabbleType-Binary */
    STNumber multiplyToBinary(STBinary scrabbleBinary);

    /** Operates a Division to a ScrabbleType-Binary */
    STNumber divideToBinary(STBinary scrabbleBinary);
}
