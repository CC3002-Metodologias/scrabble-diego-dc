package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

/**
 * Interface for ScrabbleTypes.
 */

public interface ScrabbleType {

    // Transformation of a ScrabbleType to Java String.
    String STtoString();

    // Transformation to a ScrabbleTypeString.
    STString toSTString();

    // Addition operation with a ScrabbleTypeString.
    STString addToString(STString scrabbleStr);
}
