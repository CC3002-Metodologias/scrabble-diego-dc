package cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;

/**
 * A new ScrabbleType STBinary -> references a Java String with only 0's & 1's.
 */
public class STBinary extends STNumber {

    private String myString;

    // Getter & Setter
    public String getMyString() {
        return myString;
    }
    public void setMyString(String myString) {
        this.myString = myString;
    }

    // Constructor of our class.
    public STBinary(String newString)
    {
        this.myString = newString;
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (!(o instanceof STBinary))
            return false;
        STBinary binary = (STBinary) o;
        // field comparison
        return this.getMyString().equals(binary.getMyString());
    }


    @Override
    public String STtoString() {
        return null;
    }

    @Override
    public STString toSTString() {
        return null;
    }

    @Override
    public STBoolean toSTBoolean() {
        return null;
    }

    @Override
    public STNumber toSTFloat() {
        return null;
    }

    @Override
    public STNumber toSTInt() {
        return null;
    }

    @Override
    public STNumber toSTBinary() {
        return null;
    }
}
