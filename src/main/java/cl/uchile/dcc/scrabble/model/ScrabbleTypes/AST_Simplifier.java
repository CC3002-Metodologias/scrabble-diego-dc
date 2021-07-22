package cl.uchile.dcc.scrabble.model.ScrabbleTypes;


import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STInt;

/**
 * Interfaz creada sólo con la intención de simplificar
 * la implementación del AST a través del composite.
 *
 * Tras muchas pruebas no exitosas de implementar el AST/composite
 * con las interfaces y restricciones de T1, y principalmente
 * por falta de tiempo, no quedó otra opción que asumir las
 * siguientes operaciones validas para todos lo ScrabbleTypes.
 *
 * (Quiero saber como se hacía sin asumir esto uwu.)
 *
 *
 * @author Diego Caviedes A.
 */



public interface AST_Simplifier {

    ScrabbleType add(ScrabbleType n);

    ScrabbleType subtract(ScrabbleType n);

    ScrabbleType multiply(ScrabbleType n);

    ScrabbleType divide(ScrabbleType n);

    ScrabbleType conjunction(ScrabbleType n);

    ScrabbleType disjunction(ScrabbleType n);

    ScrabbleType negation();

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

    ScrabbleType toSTString();

    ScrabbleType toSTBoolean();

    ScrabbleType toSTFloat();

    ScrabbleType toSTInt();

    ScrabbleType toSTBinary();
}
