package cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.*;

/**
 * A new ScrabbleType-Float, reference to a double.
 *
 * @author Diego Caviedes A.
 */
public class STFloat extends STNumber{

    private double myDouble;

    /** Getter. Returns referenced double of this STFloat. */
    public double getMyDouble() {
        return myDouble;
    }

    /** Setter. Sets the given double to this STFloat. */
    public void setMyDouble(double myDouble) {
        this.myDouble = myDouble;
    }

    /**
     * Default Constructor of a STFloat
     * Creates a STFloat with a (double) 0.0 value as default.
     */
    public STFloat(){
        this.myDouble = 0.0;
    }

    /**
     * Parameterized Constructor for a STFloat
     * Creates a STFloat with a given double value.
     */
    public STFloat(double newFloat){
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
        STString STStringTransform = new STString(this.STtoString());
        return STStringTransform;
    }

    @Override
    public STString addToString(STString scrabbleStr) {
        STString result = new STString();
        STString thisToString = this.toSTString();
        result.setMyString(scrabbleStr.getMyString() + thisToString.getMyString());
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
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleInt.getMyInt() + this.getMyDouble());
        return result;
    }

    @Override
    public STNumber addToFloat(STFloat scrabbleFloat) {
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleFloat.getMyDouble() + this.getMyDouble());
        return result;
    }


    @Override
    public STNumber subtractToInteger(STInt scrabbleInt) {
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleInt.getMyInt() - this.getMyDouble());
        return result;
    }

    @Override
    public STNumber subtractToFloat(STFloat scrabbleFloat) {
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleFloat.getMyDouble() - this.getMyDouble());
        return result;
    }

    @Override
    public STNumber multiplyToInteger(STInt scrabbleInt) {
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleInt.getMyInt() * this.getMyDouble());
        return result;
    }

    @Override
    public STNumber multiplyToFloat(STFloat scrabbleFloat) {
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleFloat.getMyDouble() * this.getMyDouble());
        return result;
    }

    @Override
    public STNumber divideToInteger(STInt scrabbleInt) {
        STFloat result = new STFloat();
        double value = scrabbleInt.getMyInt() / this.getMyDouble();
        result.setMyDouble(Math.round(value * 1000d) / 1000d);
        return result;
    }

    @Override
    public STNumber divideToFloat(STFloat scrabbleFloat) {
        STFloat result = new STFloat();
        double value = scrabbleFloat.getMyDouble() / this.getMyDouble();
        result.setMyDouble(Math.round(value * 1000d) / 1000d);
        return result;
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
}
