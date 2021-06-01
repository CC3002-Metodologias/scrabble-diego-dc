package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;

public interface IScrabbleTypeLogicalOperationCompatible {

    void negation();

    IScrabbleTypeLogicalOperationCompatible conjunction(IScrabbleTypeLogicalOperationCompatible scrabbleType);
    IScrabbleTypeLogicalOperationCompatible disjunction(IScrabbleTypeLogicalOperationCompatible scrabbleType);

    STBinary conjunctionToBinary(STBinary scrabbleBinary);
    IScrabbleTypeLogicalOperationCompatible conjunctionToBoolean(STBoolean scrabbleBool);

    STBinary disjunctionToBinary(STBinary scrabbleBinary);
    IScrabbleTypeLogicalOperationCompatible disjunctionToBoolean(STBoolean scrabbleBool);
}
