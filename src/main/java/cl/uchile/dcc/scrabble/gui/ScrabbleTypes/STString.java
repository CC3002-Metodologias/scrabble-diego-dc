package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;

/**
 * A ScrabbleType-String, reference to a Java String.
 *
 * @author Diego Caviedes A.
 */

public class STString implements ScrabbleType {

    private String myString;

    /** Getter. Returns the referenced Java String of this STString. */
    public String getMyString() {
        return myString;
    }

    /** Setter. Sets the given Java String to this STString. */
    public void setMyString(String myString) {
        this.myString = myString;
    }

    /**
     * Default Constructor for a STString.
     * Creates a STString with an empty Java String.
     */
    public STString() {
        this.myString = "";
    }

    /**
     * Parameterized Constructor for a STString.
     * Creates STString with a given Java String.
     */
    public STString(String newString) {
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

    /** Addition Operation - allows any ScrabbleType */
    public STString add(ScrabbleType STToAdd){
        STString result;
        result = STToAdd.addToString(this);
        return result;
    }

    @Override
    public ScrabbleType subtract(ScrabbleType n) {
        return null;
    }

    @Override
    public ScrabbleType multiply(ScrabbleType n) {
        return null;
    }

    @Override
    public ScrabbleType divide(ScrabbleType n) {
        return null;
    }

    @Override
    public ScrabbleType conjunction(ScrabbleType n) {
        return null;
    }

    @Override
    public ScrabbleType disjunction(ScrabbleType n) {
        return null;
    }

    @Override
    public STNumber addToInteger(STInt scrabbleInt) {
        return null;
    }

    @Override
    public STNumber addToFloat(STFloat scrabbleFloat) {
        return null;
    }

    @Override
    public STNumber subtractToInteger(STInt scrabbleInt) {
        return null;
    }

    @Override
    public STNumber subtractToFloat(STFloat scrabbleFloat) {
        return null;
    }

    @Override
    public STNumber multiplyToInteger(STInt scrabbleInt) {
        return null;
    }

    @Override
    public STNumber multiplyToFloat(STFloat scrabbleFloat) {
        return null;
    }

    @Override
    public STNumber divideToInteger(STInt scrabbleInt) {
        return null;
    }

    @Override
    public STNumber divideToFloat(STFloat scrabbleFloat) {
        return null;
    }

    @Override
    public STNumber addToBinary(STBinary scrabbleBinary) {
        return null;
    }

    @Override
    public STNumber subtractToBinary(STBinary scrabbleBinary) {
        return null;
    }

    @Override
    public STNumber multiplyToBinary(STBinary scrabbleBinary) {
        return null;
    }

    @Override
    public STNumber divideToBinary(STBinary scrabbleBinary) {
        return null;
    }

    @Override
    public STBinary conjunctionToBinary(STBinary scrabbleBinary) {
        return null;
    }

    @Override
    public ISTLogicalOperationCompatible conjunctionToBoolean(STBoolean scrabbleBool) {
        return null;
    }

    @Override
    public STBinary disjunctionToBinary(STBinary scrabbleBinary) {
        return null;
    }

    @Override
    public ISTLogicalOperationCompatible disjunctionToBoolean(STBoolean scrabbleBool) {
        return null;
    }


    @Override
    public STString addToString(STString scrabbleStr) {
        STString result = new STString();
        result.setMyString(scrabbleStr.getMyString() + this.getMyString());
        return result;
    }
}


