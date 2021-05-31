package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;

public interface INumberBinaryCompatible {

    STNumber addToBinary(STBinary scrabbleBinary);
    STNumber subtractToBinary(STBinary scrabbleBinary);
    STNumber multiplyToBinary(STBinary scrabbleBinary);
    STNumber divideToBinary(STBinary scrabbleBinary);
}
