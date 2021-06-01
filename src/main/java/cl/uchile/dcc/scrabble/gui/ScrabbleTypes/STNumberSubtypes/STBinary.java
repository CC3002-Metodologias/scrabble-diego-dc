package cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.*;

/**
 * A new ScrabbleType STBinary -> references a Java String with only 0's & 1's.
 */
public class STBinary extends STNumber implements INumberBinaryCompatible, IScrabbleTypeLogicalOperationCompatible {

    private String myString;

    // Getter & Setter
    public String getMyString() {
        return myString;
    }
    public void setMyString(String myString) {
        this.myString = myString;
    }

    // Default Constructor of our class.
    public STBinary()
    {
        this.myString = "00000000000000000000000000000000";
    }


    // Constructor parameterized of our class.
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

    public STFloat toSTFloat() {
        Integer i = BinaryToInt(this.getMyString());
        STFloat STFloatTransform = new STFloat(Float.valueOf(i));
        return STFloatTransform;
    }

    public STInt toSTInt() {
        int i = BinaryToInt(this.getMyString());
        STInt STIntTransform = new STInt(i);
        return STIntTransform;
    }

    public STBinary toSTBinary() {
        return this;
    }


    // BinaryToInt receives a String which contains a Binary and returns the int this binary represents.
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

    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = - bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for(int i = n, j = 0; i > 0; i--, j++)
        {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }

    private int positiveBinaryToInt(String binary)
    {
        int w = 0;
        for(int i = binary.length() - 1, j = 0; i > 0; i--, j++)
        {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    private int bitToInt(char bit)
    {
        return bit == '0' ? 0 : 1;
    }

    public STNumber add(INumberBinaryCompatible numberToAdd) {
        STNumber result;
        result = numberToAdd.addToBinary(this);
        return result;
    }

    public STNumber subtract(INumberBinaryCompatible numberToSubtract) {
        STNumber result;
        result = numberToSubtract.subtractToBinary(this);
        return result;
    }

    public STNumber multiply(INumberBinaryCompatible numberToMultiply) {
        STNumber result;
        result = numberToMultiply.multiplyToBinary(this);
        return result;
    }

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
        result.setMyInt(result.getMyInt() / binaryLikeInt.getMyInt());
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
        result.setMyDouble(scrabbleFloat.getMyDouble() / binaryLikeInt.getMyInt());
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

    @Override
    public void negation() {
        StringBuffer strBf = new StringBuffer();
        strBf.append(this.getMyString());
        for(int i = 0; i < strBf.length(); i++)
        {
            if(strBf.charAt(i) == '0')
            {
                strBf.replace(i, i+1, "1");
            }
            if(strBf.charAt(i) == '1')
            {
                strBf.replace(i,i+1,"0");
            }
        }
        this.setMyString(strBf.toString());
    }

    @Override
    public IScrabbleTypeLogicalOperationCompatible conjunction(IScrabbleTypeLogicalOperationCompatible scrabbleType) {
        IScrabbleTypeLogicalOperationCompatible result;
        result = scrabbleType.conjunctionToBinary(this);
        return result;
    }

    @Override
    public IScrabbleTypeLogicalOperationCompatible disjunction(IScrabbleTypeLogicalOperationCompatible scrabbleType) {
        IScrabbleTypeLogicalOperationCompatible result;
        result = scrabbleType.disjunctionToBinary(this);
        return result;
    }

    @Override
    public STBinary conjunctionToBinary(STBinary scrabbleBinary) {
        STBinary result = new STBinary();
        StringBuffer strBf = new StringBuffer();
        StringBuffer strBf2 = new StringBuffer();
        strBf.append(this.getMyString());
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

    @Override
    public IScrabbleTypeLogicalOperationCompatible conjunctionToBoolean(STBoolean scrabbleBool) {
        if(scrabbleBool.getMyBoolean() == false)
        {
            String str = "00000000000000000000000000000000";
            this.setMyString(str);
        }
        return this;
    }

    @Override
    public STBinary disjunctionToBinary(STBinary scrabbleBinary) {
        STBinary result = new STBinary();
        StringBuffer strBf = new StringBuffer();
        StringBuffer strBf2 = new StringBuffer();
        strBf.append(this.getMyString());
        strBf2.append(this.getMyString());
        for(int i = 0; i < strBf.length(); i++)
        {
            if(strBf.charAt(i) == '0' && strBf2.charAt(i) == '1')
            {
                strBf.replace(i, i + 1, "0");
            }
        }
        result.setMyString(strBf.toString());
        return result;
    }

    @Override
    public IScrabbleTypeLogicalOperationCompatible disjunctionToBoolean(STBoolean scrabbleBool) {
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
            this.setMyString(strBf.toString());
        }
        return this;
    }
}
