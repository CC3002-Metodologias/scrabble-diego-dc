package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

/**
 * Interface ScrabbleTypes.
 * <p>Mutual methods all ScrabbleTypes share.
 * these includes the ability to transform to Java String
 * to transform to ScrabbleType-String
 * and to operate addition with a ScrabbleType-String</p>
 *
 * @author Diego Caviedes A.
 */

public interface ScrabbleType {

    /** Transformation of a ScrabbleType to a Java String. */
    String STtoString();

    /** Transformation of a ScrabbleType to a ScrabbleType-String. */
    STString toSTString();

    /** Addition Operation of a ScrabbleType with a ScrabbleType-String. */
    STString addToString(STString scrabbleStr);
}
