package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

/**
 * A new ScrabbleType STBoolean -> references a Java Boolean.
 */

public class STBoolean implements ScrabbleType{

    private Boolean myBoolean;

    // Getter & Setter
    public Boolean getMyBoolean() {
        return myBoolean;
    }
    public void setMyBoolean(boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    // Creates a new STBoolean
    public STBoolean(Boolean newBoolean)
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
        return getMyBoolean().toString();
    }

    @Override
    public STString toSTString() {
        STString STStringTransform = new STString(this.getMyBoolean().toString());
        return STStringTransform;
    }

    public STBoolean toSTBoolean() {
        return this;
    }

}
