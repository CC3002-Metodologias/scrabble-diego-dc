package cl.uchile.dcc.scrabble.model.ScrabbleTypes;

import cl.uchile.dcc.scrabble.model.Flyweight.ScrabbleTypeFlyweight;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STInt;

/**
 * A ScrabbleType-String, reference to a Java String.
 *
 * @author Diego Caviedes A.
 */

public class STString implements ScrabbleType {

    public static class string_builder {
        String myValue;

        /** Default constructor - if no parameter is given, assigns to 'myValue' an empty String */
        public string_builder() {
            this.myValue = "";
        }

        /** Constructor string_builder */
        public string_builder(String newString) {
            this.myValue = newString;
        }

        /**
         * Public constructor for a STFloat.
         * The purpose is to save Memory:
         * will only create a STInt if there is no other
         * STInt created with the same value before.
         */
        public STString build() {
            // check if there is already an STInt with this value created.
            ScrabbleType result = ScrabbleTypeFlyweight.checkDictionary(myValue);
            // if not
            if (result == null) {
                // Create a new STInt and add to the Dictionary.
                result = new STString(myValue);
                ScrabbleTypeFlyweight.addElement(myValue, result);
            }
            // it can only be a STInt
            return (STString)result;
        }
    }

    private String myString;

    /** Getter. Returns the referenced Java String of this STString. */
    public String getMyString() {
        return myString;
    }

    /**
     * Parameterized Constructor for a STString.
     * Creates STString with a given Java String.
     */
    private STString(String newString) {
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
    public STString addToString(STString scrabbleStr) {
        STString result = new STString.string_builder(scrabbleStr.getMyString() + this.getMyString()).build();
        return result;
    }

    // ------------------------------ Null Methods --------------------------

    @Override
    public ScrabbleType toSTBoolean() {
        return null;
    }

    @Override
    public ScrabbleType toSTFloat() {
        return null;
    }

    @Override
    public ScrabbleType toSTInt() {
        return null;
    }

    @Override
    public ScrabbleType toSTBinary() {
        return null;
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
    public ScrabbleType negation() {
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
}


