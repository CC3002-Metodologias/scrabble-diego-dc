package cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;

/**
 * A new ScrabbleType STFloat -> references a Java double.
 */
public class STFloat extends STNumber{

    private Double myDouble;

    // Getter & Setter
    public Double getMyDouble() {
        return myDouble;
    }
    public void setMyDouble(Double myDouble) {
        this.myDouble = myDouble;
    }

    // Constructor for our class
    public STFloat(Double newFloat)
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
        return getMyDouble().toString();
    }

    @Override
    public STString toSTString() {
        STString STStringTransform = new STString(this.getMyDouble().toString());
        return STStringTransform;
    }

    public STNumber toSTFloat() {
        return this;
    }


}
