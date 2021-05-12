package cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;

/**
 * A new ScrabbleType STInt -> references a Java int.
 */
public class STInt extends STNumber{

    private int myInt;

    // Getter & Setter
    public int getMyInt() {
        return myInt;
    }
    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    // Constructor for our Class STInt
    public STInt(int newInt)
    {
        this.myInt = newInt;
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
        if (!(o instanceof STInt))
            return false;
        STInt STint = (STInt) o;
        // field comparison
        return this.getMyInt() == STint.getMyInt();
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
