package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;

/**
 * Interface ScrabbleTypes Compatible with Logical Operations.
 * <p>ScrabbleTypes that can operate Logical Operations.
 * Includes unary operations and binary operations</p>
 *
 * @author Diego Caviedes A.
 */

public interface ISTLogicalOperationCompatible extends ScrabbleType{

    /** Unary operation, Logical Negation */
    ISTLogicalOperationCompatible negation();

    /** Binary operation, Logical Conjunction */
    //ISTLogicalOperationCompatible conjunction(ISTLogicalOperationCompatible scrabbleType);
    /** Binary operation, Logical Disjunction */
    //ISTLogicalOperationCompatible disjunction(ISTLogicalOperationCompatible scrabbleType);


    /** Operates a Conjunction with a ScrabbleType-Binary */
    STBinary conjunctionToBinary(STBinary scrabbleBinary);
    /** Operates a Conjunction with a ScrabbleType-Boolean */
    ISTLogicalOperationCompatible conjunctionToBoolean(STBoolean scrabbleBool);


    /** Operates a Disjunction with a ScrabbleType-Binary */
    STBinary disjunctionToBinary(STBinary scrabbleBinary);
    /** Operates a Disjunction with a ScrabbleType-Boolean */
    ISTLogicalOperationCompatible disjunctionToBoolean(STBoolean scrabbleBool);
}
