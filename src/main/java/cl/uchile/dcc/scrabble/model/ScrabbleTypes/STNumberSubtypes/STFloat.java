package cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.model.Flyweight.ScrabbleTypeFlyweight;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.*;

/**
 * A new ScrabbleType-Float, reference to a double.
 *
 * @author Diego Caviedes A.
 */
public class STFloat extends STNumber{

    public static class float_builder {
        double myValue;

        /** Default constructor - if no parameter is given, assigns to 'myValue' a (double)0.0 */
        public float_builder() {
            this.myValue = 0.0;
        }

        /** Constructor float_builder */
        public float_builder(double newDouble) {
            this.myValue = newDouble;
        }

        /**
         * Public builder for a STFloat.
         * The purpose is to save Memory:
         * will only create a STInt if there is no other
         * STInt created with the same value before.
         */
        public STFloat build() {
            // check if there is already an STFloat with this value created.
            ScrabbleType result = ScrabbleTypeFlyweight.checkDictionary(myValue);
            // if not
            if (result == null) {
                // Create a new STFloat and add to the Dictionary.
                result = new STFloat(myValue);
                ScrabbleTypeFlyweight.addElement(myValue, result);
            }
            // it can only be a STFloat.
            return (STFloat)result;
        }
    }

    private double myDouble;

    /** Getter. Returns referenced double of this STFloat. */
    public double getMyDouble() {
        return myDouble;
    }


    /**
     * Parameterized Constructor for a STFloat
     * Creates a STFloat with a given double value.
     */
    private STFloat(double newFloat){
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
        Double i = getMyDouble();
        return i.toString();
    }

    @Override
    public STString toSTString() {
        STString STStringTransform = new STString.string_builder(this.STtoString()).build();
        return STStringTransform;
    }

    @Override
    public ScrabbleType toSTBoolean() {
        return null;
    }

    @Override
    public STString addToString(STString scrabbleStr) {
        STString thisToString = this.toSTString();
        STString result = new STString.string_builder(scrabbleStr.getMyString() + thisToString.getMyString()).build();
        return result;
    }

    @Override
    public STFloat toSTFloat() {
        return this;
    }


    /** Addition Operation - allows any type of STNumber */
    public STNumber add(ScrabbleType numberToAdd) {
        STNumber result;
        result = numberToAdd.addToFloat(this);
        return result;
    }

    /** Subtraction Operation - allows any type of STNumber */
    public STNumber subtract(ScrabbleType numberToSubtract) {
        STNumber result;
        result = numberToSubtract.subtractToFloat(this);
        return result;
    }

    /** Multiplication Operation - allows any type of STNumber */
    public STNumber multiply(ScrabbleType numberToMultiply) {
        STNumber result;
        result = numberToMultiply.multiplyToFloat(this);
        return result;
    }

    /** Division Operation - allows any type of STNumber */
    public STNumber divide(ScrabbleType numberToDivide) {
        STNumber result;
        result = numberToDivide.divideToFloat(this);
        return result;
    }


    @Override
    public STNumber addToInteger(STInt scrabbleInt) {
        STFloat result = new STFloat.float_builder(scrabbleInt.getMyInt() + this.getMyDouble()).build();
        return result;
    }

    @Override
    public STNumber addToFloat(STFloat scrabbleFloat) {
        STFloat result = new STFloat.float_builder(scrabbleFloat.getMyDouble() + this.getMyDouble()).build();
        return result;
    }


    @Override
    public STNumber subtractToInteger(STInt scrabbleInt) {
        STFloat result = new STFloat.float_builder(scrabbleInt.getMyInt() - this.getMyDouble()).build();
        return result;
    }

    @Override
    public STNumber subtractToFloat(STFloat scrabbleFloat) {
        STFloat result = new STFloat.float_builder(scrabbleFloat.getMyDouble() - this.getMyDouble()).build();
        return result;
    }

    @Override
    public STNumber multiplyToInteger(STInt scrabbleInt) {
        STFloat result = new STFloat.float_builder(scrabbleInt.getMyInt() * this.getMyDouble()).build();
        return result;
    }

    @Override
    public STNumber multiplyToFloat(STFloat scrabbleFloat) {
        STFloat result = new STFloat.float_builder(scrabbleFloat.getMyDouble() * this.getMyDouble()).build();
        return result;
    }

    @Override
    public STNumber divideToInteger(STInt scrabbleInt) {
        double value = scrabbleInt.getMyInt() / this.getMyDouble();
        STFloat result = new STFloat.float_builder(Math.round(value * 1000d) / 1000d).build();
        return result;
    }

    @Override
    public STNumber divideToFloat(STFloat scrabbleFloat) {
        double value = scrabbleFloat.getMyDouble() / this.getMyDouble();
        STFloat result = new STFloat.float_builder(Math.round(value * 1000d) / 1000d).build();
        return result;
    }

    // ------------------------------ Null Methods --------------------------

    @Override
    public ScrabbleType toSTInt() {
        return null;
    }

    @Override
    public ScrabbleType toSTBinary() {
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
}
