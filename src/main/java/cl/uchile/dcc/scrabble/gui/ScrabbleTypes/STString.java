package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

/**
 * A new ScrabbleType STString -> references a Java String.
 */

public class STString implements ScrabbleType {

    private String myString;

    // Getter & Setter
    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    // Creates a new STString
    public STString(String newString) {
        if(newString == null)
        {
            this.setMyString("");
        }
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
        if (!(o instanceof STString))
            return false;
        STString STstring = (STString) o;
        // field comparison
        return this.getMyString().equals(STstring.getMyString());
    }


    @Override
    public String STtoString() {
        return getMyString();
    }

    @Override
    public STString toSTString() {
        return this;
    }
}


