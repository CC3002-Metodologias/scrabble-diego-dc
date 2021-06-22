package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.AST.*;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;

public interface AST_Simplifier {

    ScrabbleType add(ScrabbleType n);

    ScrabbleType subtract(ScrabbleType n);

    ScrabbleType multiply(ScrabbleType n);

    ScrabbleType divide(ScrabbleType n);

    ScrabbleType conjunction(ScrabbleType n);

    ScrabbleType disjunction(ScrabbleType n);

    STNumber addToInteger(STInt scrabbleInt);

    STNumber addToFloat(STFloat scrabbleFloat);

    STNumber subtractToInteger(STInt scrabbleInt);

    STNumber subtractToFloat(STFloat scrabbleFloat);

    STNumber multiplyToInteger(STInt scrabbleInt);

    STNumber multiplyToFloat(STFloat scrabbleFloat);

    STNumber divideToInteger(STInt scrabbleInt);

    STNumber divideToFloat(STFloat scrabbleFloat);

    STNumber addToBinary(STBinary scrabbleBinary);

    STNumber subtractToBinary(STBinary scrabbleBinary);

    STNumber multiplyToBinary(STBinary scrabbleBinary);

    STNumber divideToBinary(STBinary scrabbleBinary);

    STBinary conjunctionToBinary(STBinary scrabbleBinary);

    ISTLogicalOperationCompatible conjunctionToBoolean(STBoolean scrabbleBool);

    STBinary disjunctionToBinary(STBinary scrabbleBinary);

    ISTLogicalOperationCompatible disjunctionToBoolean(STBoolean scrabbleBool);
}
