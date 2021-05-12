package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

/**
 * Interface for ScrabbleTypes.
 */

public interface ScrabbleType {

    String STtoString();
    STString toSTString();
    STBoolean toSTBoolean();
    STNumber toSTFloat();
    STNumber toSTInt();
    STNumber toSTBinary();

}
