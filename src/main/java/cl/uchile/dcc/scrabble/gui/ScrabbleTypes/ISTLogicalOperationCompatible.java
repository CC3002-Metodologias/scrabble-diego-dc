package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;

public interface ISTLogicalOperationCompatible extends ScrabbleType{

    ISTLogicalOperationCompatible negation();

    ISTLogicalOperationCompatible conjunction(ISTLogicalOperationCompatible scrabbleType);
    ISTLogicalOperationCompatible disjunction(ISTLogicalOperationCompatible scrabbleType);

    STBinary conjunctionToBinary(STBinary scrabbleBinary);
    ISTLogicalOperationCompatible conjunctionToBoolean(STBoolean scrabbleBool);

    STBinary disjunctionToBinary(STBinary scrabbleBinary);
    ISTLogicalOperationCompatible disjunctionToBoolean(STBoolean scrabbleBool);
}
