package cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public interface INumberBinaryCompatible extends ScrabbleType {

    STNumber addToBinary(STBinary scrabbleBinary);
    STNumber subtractToBinary(STBinary scrabbleBinary);
    STNumber multiplyToBinary(STBinary scrabbleBinary);
    STNumber divideToBinary(STBinary scrabbleBinary);
}
