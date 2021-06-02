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

    // Default constructor
    public STFloat(){
        this.myDouble = 0.0;
    }

    // Constructor parameterized  for our class
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

    public STNumber add(STNumber numberToAdd) {
        STNumber result;
        result = numberToAdd.addToFloat(this);
        return result;
    }

    public STNumber subtract(STNumber numberToSubtract) {
        STNumber result;
        result = numberToSubtract.subtractToFloat(this);
        return result;
    }

    public STNumber multiply(STNumber numberToMultiply) {
        STNumber result;
        result = numberToMultiply.multiplyToFloat(this);
        return result;
    }

    public STNumber divide(STNumber numberToDivide) {
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
        result.setMyDouble(scrabbleInt.getMyInt() / this.getMyDouble());
        return result;
    }

    @Override
    public STNumber divideToFloat(STFloat scrabbleFloat) {
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleFloat.getMyDouble() / this.getMyDouble());
        return result;
    }


}
