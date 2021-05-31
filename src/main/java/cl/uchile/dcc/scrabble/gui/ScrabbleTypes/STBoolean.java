package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

/**
 * A new ScrabbleType STBoolean -> references a Java Boolean.
 */

public class STBoolean implements ScrabbleType{

    private boolean myBoolean;

    // Getter & Setter
    public boolean getMyBoolean() {
        return myBoolean;
    }
    public void setMyBoolean(boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    // Default Constructor parameterized of our class
    public STBoolean()
    {
        this.myBoolean = false;
    }

    // Constructor parameterized of our class
    public STBoolean(boolean newBoolean)
    {
        this.myBoolean = newBoolean;
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
        if (!(o instanceof STBoolean))
            return false;
        STBoolean STboolean = (STBoolean) o;
        // field comparison
        return this.getMyBoolean() == STboolean.getMyBoolean();
    }

    @Override
    public String STtoString() {
        Boolean i = getMyBoolean();
        return i.toString();
    }

    @Override
    public STString toSTString() {
        STString STStringTransform = new STString(this.STtoString());
        return STStringTransform;
    }

    public STBoolean toSTBoolean() {
        return this;
    }

}
