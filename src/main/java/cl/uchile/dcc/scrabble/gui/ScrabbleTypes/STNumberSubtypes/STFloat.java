package cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;

/**
 * A new ScrabbleType STFloat -> references a Java double.
 */
public class STFloat extends STNumber{

    private double myDouble;

    // Getter & Setter
    public double getMyDouble() {
        return myDouble;
    }
    public void setMyDouble(double myDouble) {
        this.myDouble = myDouble;
    }

    // Constructor for our class
    public STFloat(double newFloat)
    {
        this.myDouble = newFloat;
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
        if (!(o instanceof STFloat))
            return false;
        STFloat STfloat = (STFloat) o;
        // field comparison
        return this.getMyDouble() == STfloat.getMyDouble();
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
