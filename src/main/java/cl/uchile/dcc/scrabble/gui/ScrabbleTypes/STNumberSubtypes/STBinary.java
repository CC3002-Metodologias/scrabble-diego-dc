package cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.*;

/**
 * A new ScrabbleType-Binary, references to a Java String with only 0's & 1's.
 *
 * @author Diego Caviedes A.
 */

public class STBinary extends STNumber implements INumberBinaryCompatible, ISTLogicalOperationCompatible {

    private String myString;

    /** Getter. Returns referenced Java String of this STBinary. */
    public String getMyString() {
        return myString;
    }

    /** Setter. Sets the given 32bit binary as a Java String to this STBinary. */
    public void setMyString(String myString) {
        this.myString = myString;
    }

    /**
     * Default Constructor of a STBinary
     * Creates a STBinary with a 0 in binary as a Java String value as default.
     */
    public STBinary()
    {
        this.myString = "00000000000000000000000000000000";
    }

    /**
     * Parameterized Constructor for a STBinary
     * Creates a STBinary with a given binary as Java String value.
     */
    public STBinary(String newString)
    {
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
        if (!(o instanceof STBinary))
            return false;
        STBinary binary = (STBinary) o;
        // field comparison
        return this.getMyString().equals(binary.getMyString());
    }


    @Override
    public String STtoString() {
        return getMyString();
    }

    @Override
    public STString toSTString() {
        STString STStringTransform = new STString(this.getMyString().toString());
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
        Integer i = BinaryToInt(this.getMyString());
        STFloat STFloatTransform = new STFloat(Float.valueOf(i));
        return STFloatTransform;
    }

    /** Transformation of this STBinary to a STInt */
    @Override
    public STInt toSTInt() {
        int i = BinaryToInt(this.getMyString());
        STInt STIntTransform = new STInt(i);
        return STIntTransform;
    }

    /** Transformation of this STBinary to a STBinary */
    @Override
    public STBinary toSTBinary() {
        return this;
    }


    /** BinaryToInt receives a String which contains a Binary and returns the int this binary represents. */
    public int BinaryToInt(String binary) {
        if(bitToInt(binary.charAt(0))==0)
        {
            return positiveBinaryToInt(binary);
        }
        else
        {
            return negativeBinaryToInt(binary);
        }
    }

    /** Transforms a negative binary contained in a String to an int */
    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = - bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for(int i = n, j = 0; i > 0; i--, j++)
        {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w - 1; // somehow we get negative number + 1, so for now we will fix it just like this.
    }

    /** Transforms a positive binary contained in a String to an int */
    private int positiveBinaryToInt(String binary)
    {
        int w = 0;
        for(int i = binary.length() - 1, j = 0; i > 0; i--, j++)
        {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    /** flips values of a given bit from a binary */
    private int bitToInt(char bit)
    {
        return bit == '0' ? 0 : 1;
    }

    /** Addition Operation - only allows STNumbers Compatible with STBinaries */
    public STNumber add(INumberBinaryCompatible numberToAdd) {
        STNumber result;
        result = numberToAdd.addToBinary(this);
        return result;
    }

    /** Subtraction Operation - only allows STNumbers Compatible with STBinaries */
    public STNumber subtract(INumberBinaryCompatible numberToSubtract) {
        STNumber result;
        result = numberToSubtract.subtractToBinary(this);
        return result;
    }

    /** Multiplication Operation - only allows STNumbers Compatible with STBinaries */
    public STNumber multiply(INumberBinaryCompatible numberToMultiply) {
        STNumber result;
        result = numberToMultiply.multiplyToBinary(this);
        return result;
    }

    /** Division Operation - only allows STNumbers Compatible with STBinaries */
    public STNumber divide(INumberBinaryCompatible numberToDivide) {
        STNumber result;
        result = numberToDivide.divideToBinary(this);
        return result;
    }


    @Override
    public STNumber addToInteger(STInt scrabbleInt) {
        STInt binaryLikeInt;
        binaryLikeInt = this.toSTInt();
        STInt result = new STInt();
        result.setMyInt(scrabbleInt.getMyInt() + binaryLikeInt.getMyInt());
        return result;
    }

    @Override
    public STNumber addToFloat(STFloat scrabbleFloat) {
        STInt binaryLikeInt;
        binaryLikeInt = this.toSTInt();
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleFloat.getMyDouble() + binaryLikeInt.getMyInt());
        return result;
    }

    @Override
    public STNumber addToBinary(STBinary scrabbleBinary) {
        STInt binaryLikeInt;
        binaryLikeInt = this.toSTInt();
        STInt result = scrabbleBinary.toSTInt();
        result.setMyInt(result.getMyInt() + binaryLikeInt.getMyInt());
        return result.toSTBinary();
    }

    @Override
    public STNumber subtractToInteger(STInt scrabbleInt) {
        STInt binaryLikeInt;
        binaryLikeInt = this.toSTInt();
        STInt result = new STInt();
        result.setMyInt(scrabbleInt.getMyInt() - binaryLikeInt.getMyInt());
        return result;
    }

    @Override
    public STNumber subtractToFloat(STFloat scrabbleFloat) {
        STInt binaryLikeInt;
        binaryLikeInt = this.toSTInt();
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleFloat.getMyDouble() - binaryLikeInt.getMyInt());
        return result;
    }

    @Override
    public STNumber subtractToBinary(STBinary scrabbleBinary) {
        STInt binaryLikeInt;
        binaryLikeInt = this.toSTInt();
        STInt result = scrabbleBinary.toSTInt();
        result.setMyInt(result.getMyInt() - binaryLikeInt.getMyInt());
        return result.toSTBinary();
    }

    @Override
    public STNumber multiplyToInteger(STInt scrabbleInt) {
        STInt binaryLikeInt;
        binaryLikeInt = this.toSTInt();
        STInt result = new STInt();
        result.setMyInt(scrabbleInt.getMyInt() * binaryLikeInt.getMyInt());
        return result;
    }

    @Override
    public STNumber multiplyToFloat(STFloat scrabbleFloat) {
        STInt binaryLikeInt;
        binaryLikeInt = this.toSTInt();
        STFloat result = new STFloat();
        result.setMyDouble(scrabbleFloat.getMyDouble() * binaryLikeInt.getMyInt());
        return result;
    }

    @Override
    public STNumber multiplyToBinary(STBinary scrabbleBinary) {
        STInt binaryLikeInt;
        binaryLikeInt = this.toSTInt();
        STInt result = scrabbleBinary.toSTInt();
        result.setMyInt(result.getMyInt() * binaryLikeInt.getMyInt());
        return result.toSTBinary();
    }

    @Override
    public STNumber divideToInteger(STInt scrabbleInt) {
        STInt binaryLikeInt;
        binaryLikeInt = this.toSTInt();
        STInt result = new STInt();
        result.setMyInt(scrabbleInt.getMyInt() / binaryLikeInt.getMyInt());
        return result;
    }

    @Override
    public STNumber divideToFloat(STFloat scrabbleFloat) {
        STInt binaryLikeInt;
        binaryLikeInt = this.toSTInt();
        STFloat result = new STFloat();
        double value = scrabbleFloat.getMyDouble() / binaryLikeInt.getMyInt();
        result.setMyDouble(Math.round(value * 1000d) / 1000d); // we round the value to the 3rd decimal
        return result;
    }

    @Override
    public STNumber divideToBinary(STBinary scrabbleBinary) {
        STInt binaryLikeInt;
        binaryLikeInt = this.toSTInt();
        STInt result = scrabbleBinary.toSTInt();
        result.setMyInt(result.getMyInt() / binaryLikeInt.getMyInt());
        return result.toSTBinary();
    }

    /**
     * {@inheritDoc}
     *
     * Negation of this binary consists in the flipping of every bit to the opposite value
     *
     * @return
     *      new String containing the new binary.
     */
    @Override
    public ISTLogicalOperationCompatible negation() {
        STBinary result = new STBinary();
        StringBuffer strBf = new StringBuffer();
        strBf.append(this.getMyString());
        for(int i = 0; i < strBf.length(); i++)
        {
            if(strBf.charAt(i) == '0')
            {
                strBf.replace(i, i+1, "1");
            }
            else
            {
                strBf.replace(i,i+1,"0");
            }
        }
        result.setMyString(strBf.toString());
        return result;
    }

    @Override
    public ISTLogicalOperationCompatible conjunction(ISTLogicalOperationCompatible scrabbleType) {
        ISTLogicalOperationCompatible result;
        result = scrabbleType.conjunctionToBinary(this);
        return result;
    }

    @Override
    public ISTLogicalOperationCompatible disjunction(ISTLogicalOperationCompatible scrabbleType) {
        ISTLogicalOperationCompatible result;
        result = scrabbleType.disjunctionToBinary(this);
        return result;
    }

    /**
     * {@inheritDoc}
     *
     * Conjunction between binaries are bit to bit.
     * Consists on the evaluation of the tuples (B1_i, B2_i)
     * true = 1 and false = 0.
     *
     * @param scrabbleBinary
     *      STBinary operated with this STBinary.
     * @return
     *      a new STBinary with the result of the conjunction.
     */
    @Override
    public STBinary conjunctionToBinary(STBinary scrabbleBinary) {
        STBinary result = new STBinary();
        StringBuffer strBf = new StringBuffer();
        StringBuffer strBf2 = new StringBuffer();
        strBf.append(scrabbleBinary.getMyString());
        strBf2.append(this.getMyString());
        for(int i = 0; i < strBf.length(); i++)
        {
            if(strBf.charAt(i) == '1' && strBf2.charAt(i) == '0')
            {
                strBf.replace(i, i+1, "0");
            }
        }
        result.setMyString(strBf.toString());
        return result;
    }

    /**
     * {@inheritDoc}
     *
     * Conjunction to a binary is bit to bit.
     * If boolean false -> 0
     * If boolean true -> 1
     * @param scrabbleBool
     *      Binary Operated with this STBoolean
     * @return
     *      A STSBinary as result of the operation.
     */
    @Override
    public ISTLogicalOperationCompatible conjunctionToBoolean(STBoolean scrabbleBool) {
        STBinary result = new STBinary();
        if(scrabbleBool.getMyBoolean() == false)
        {
            return result;
        }
        result.setMyString(this.getMyString());
        return result;
    }

    /**
     * {@inheritDoc}
     *
     * Conjunction between binaries are bit to bit.
     * Consists on the evaluation of the tuples (B1_i, B2_i)
     * true = 1 and false = 0.
     *
     * @param scrabbleBinary
     *      STBinary operated with this STBinary.
     * @return
     *      a new STBinary with the result of the conjunction.
     */
    @Override
    public STBinary disjunctionToBinary(STBinary scrabbleBinary) {
        STBinary result = new STBinary();
        StringBuffer strBf = new StringBuffer();
        StringBuffer strBf2 = new StringBuffer();
        strBf.append(scrabbleBinary.getMyString());
        strBf2.append(this.getMyString());
        for(int i = 0; i < strBf.length(); i++)
        {
            if(strBf.charAt(i) == '0' && strBf2.charAt(i) == '1')
            {
                strBf.replace(i, i + 1, "1");
            }
        }
        result.setMyString(strBf.toString());
        return result;
    }


    /**
     * {@inheritDoc}
     *
     * Disjunction to a binary is bit to bit.
     * If boolean false -> 0
     * If boolean true -> 1
     * @param scrabbleBool
     *      Binary Operated with this STBoolean
     * @return
     *      A STSBinary as result of the operation.
     */
    @Override
    public ISTLogicalOperationCompatible disjunctionToBoolean(STBoolean scrabbleBool) {
        STBinary result = new STBinary();
        if(scrabbleBool.getMyBoolean() == true)
        {
            StringBuffer strBf = new StringBuffer();
            strBf.append(this.getMyString());
            for(int i = 0; i < strBf.length(); i++)
            {
                if(strBf.charAt(i) == '0')
                {
                    strBf.replace(i, i+1, "1");
                }
            }
            result.setMyString(strBf.toString());
            return result;
        }
        result.setMyString(this.getMyString());
        return result;
    }
}
