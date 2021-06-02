package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;

public interface ISTNumber extends ScrabbleType {

    STNumber addToInteger(STInt scrabbleInt);
    STNumber addToFloat(STFloat scrabbleFloat);


    STNumber subtractToInteger(STInt scrabbleInt);
    STNumber subtractToFloat(STFloat scrabbleFloat);


    STNumber multiplyToInteger(STInt scrabbleInt);
    STNumber multiplyToFloat(STFloat scrabbleFloat);


    STNumber divideToInteger(STInt scrabbleInt);
    STNumber divideToFloat(STFloat scrabbleFloat);


}
