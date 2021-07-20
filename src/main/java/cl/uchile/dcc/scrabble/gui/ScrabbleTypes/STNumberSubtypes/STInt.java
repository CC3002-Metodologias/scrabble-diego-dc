package cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.*;

/**
 * A new ScrabbleType-Int, reference to an int.
 *
 * @author Diego Caviedes A.
 */

public class STInt extends STNumber implements INumberBinaryCompatible {

    private int myInt;

    /** Getter. Returns referenced int of this STInt */
    public int getMyInt() {
        return myInt;
    }

    /** Setter. Sets the given int to this STInts. */
    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    /**
     * Default Constructor of a STInt
     * Creates a STInt with a (int) 0 value as default.
     */
    public STInt()
    {
        this.myInt = 0;
    }


    /**
     * Parameterized Constructor for a STInt
     * Creates a STInt with a given int value.
     */
    public STInt(int newInt)
    {
        this.myInt = newInt;
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
        if (!(o instanceof STInt))
            return false;
        STInt STint = (STInt) o;
        // field comparison
        return this.getMyInt() == STint.getMyInt();
    }


    @Override
    public String STtoString() {
        Integer i = getMyInt();
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
        STFloat STFloatTransform = new STFloat(Double.valueOf(this.getMyInt()));
        return STFloatTransform;
    }


    /** Transformation of this STInt to a STInt */
    @Override
    public STInt toSTInt() {
        return this;
    }

    /**
     * Transformation of this STInt to a STBinary
     * @return
     *      A STBinary, represented as a 32bit binary on a Java String.
     */
    @Override
    public STBinary toSTBinary() {
        String myBinary;
        Integer i = Math.abs(getMyInt());
        myBinary = intToBinaryString(i);
        if(getMyInt() < 0)
        {
            StringBuffer strBf = new StringBuffer();
            strBf.append(myBinary);
            myBinary = findTwosComplement(strBf);
        }
        STBinary newSTBinary = new STBinary(myBinary);
        return newSTBinary;
    }

    /** Returns a String representing a 32bit binary number from an int */
    private String intToBinaryString (int n) {
        String binary = "";
        for(int i = 0; i < 32; ++i, n/=2) {
            switch (n % 2) {
                case 0:
                    binary = "0" + binary;
                    break;
                case 1:
                    binary = "1" + binary;
                    break;
            }
        }
        return binary;
    }

    /**
     * Returns a negative version of a given binary using twoComplement.
     * @param str
     *      A StringBuffer with a positive Binary, representing the
     *      absolute value of a negative int we want to transform.
     * @return
     *      A String with a 32bits binary.
     */
    static String findTwosComplement(StringBuffer str)
    {
        int n = str.length();

        // Traverse the string to get first '1' from
        // the last of string
        int i;
        for (i = n-1 ; i >= 0 ; i--)
            if (str.charAt(i) == '1')
                break;
        // If there exists no '1' concat 1 at the
        // starting of string
        if (i == -1)
            return "1" + str;
        // Continue traversal after the position of
        // first '1'
        for (int k = i-1 ; k >= 0; k--)
        {
            //Just flip the values
            if (str.charAt(k) == '1')
                str.replace(k, k+1, "0");
            else
                str.replace(k, k+1, "1");
        }
        // return the modified string
        return str.toString();
    }

    /** Addition Operation - allows any type of STNumber */
    public STNumber add(ScrabbleType numberToAdd) {
        STNumber result;
        result = numberToAdd.addToInteger(this);
        return result;
    }

    /** Subtraction Operation - allows any type of STNumber */
    public STNumber subtract(ScrabbleType numberToSubtract) {
        STNumber result;
        result = numberToSubtract.subtractToInteger(this);
        return result;
    }

    /** Multiplication Operation - allows any type of STNumber */
    public STNumber multiply(ScrabbleType numberToMultiply) {
        STNumber result;
        result = numberToMultiply.multiplyToInteger(this);
        return result;
    }

    /** Division Operation - allows any type of STNumber */
    public STNumber divide(ScrabbleType numberToDivide) {
        STNumber result;
        result = numberToDivide.divideToInteger(this);
        return result;
    }

    @Override
    public STNumber addToInteger(STInt scrabbleInt) {
        STInt result = new STInt();
        result.setMyInt(scrabbleInt.getMyInt() + this.getMyInt());
        return result;
    }

    @Override
    public STNumber addToFloat(STFloat scrabbleFloat) {
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleFloat.getMyDouble() + this.getMyInt()); // we round the double to 4 decimals
        return result;
    }

    @Override
    public STNumber addToBinary(STBinary scrabbleBinary) {
        STInt binaryLikeInt;
        binaryLikeInt = scrabbleBinary.toSTInt();
        STInt result = new STInt();
        result.setMyInt(binaryLikeInt.getMyInt() + this.getMyInt());
        return result.toSTBinary();
    }

    @Override
    public STNumber subtractToInteger(STInt scrabbleInt) {
        STInt result = new STInt();
        result.setMyInt(scrabbleInt.getMyInt() - this.getMyInt());
        return result;
    }

    @Override
    public STNumber subtractToFloat(STFloat scrabbleFloat) {
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleFloat.getMyDouble() - this.getMyInt());
        return result;
    }

    @Override
    public STNumber subtractToBinary(STBinary scrabbleBinary) {
        STInt binaryLikeInt;
        binaryLikeInt = scrabbleBinary.toSTInt();
        STInt result = new STInt();
        result.setMyInt(binaryLikeInt.getMyInt() - this.getMyInt());
        return result.toSTBinary();
    }

    @Override
    public STNumber multiplyToInteger(STInt scrabbleInt) {
        STInt result = new STInt();
        result.setMyInt(scrabbleInt.getMyInt() * this.getMyInt());
        return result;
    }

    @Override
    public STNumber multiplyToFloat(STFloat scrabbleFloat) {
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleFloat.getMyDouble() * this.getMyInt());
        return result;
    }

    @Override
    public STNumber multiplyToBinary(STBinary scrabbleBinary) {
        STInt binaryLikeInt;
        binaryLikeInt = scrabbleBinary.toSTInt();
        STInt result = new STInt();
        result.setMyInt(binaryLikeInt.getMyInt() * this.getMyInt());
        return result.toSTBinary();
    }

    @Override
    public STNumber divideToInteger(STInt scrabbleInt) {
        STInt result = new STInt();
        result.setMyInt(scrabbleInt.getMyInt() / this.getMyInt());
        return result;
    }

    @Override
    public STNumber divideToFloat(STFloat scrabbleFloat) {
        STFloat result = new STFloat();
        double value = scrabbleFloat.getMyDouble() / this.getMyInt();
        result.setMyDouble(Math.round(value * 1000d) / 1000d); // we round the double to 3 decimals
        return result;
    }

    @Override
    public STNumber divideToBinary(STBinary scrabbleBinary) {
        STInt binaryLikeInt;
        binaryLikeInt = scrabbleBinary.toSTInt();
        STInt result = new STInt();
        result.setMyInt(binaryLikeInt.getMyInt() / this.getMyInt());
        return result.toSTBinary();
    }

    // ------------------------------ Null Methods --------------------------

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

    @Override
    public ScrabbleType toSTBoolean() {
        return null;
    }
}
