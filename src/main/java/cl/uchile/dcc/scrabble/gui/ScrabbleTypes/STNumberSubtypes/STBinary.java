package cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.INumberBinaryCompatible;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;

/**
 * A new ScrabbleType STBinary -> references a Java String with only 0's & 1's.
 */
public class STBinary extends STNumber implements INumberBinaryCompatible {

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

    @Override
    public STNumber add(int numberToAdd) {
        STNumber result;
        result = numberToAdd.addToBinary(this);
        return result;
    }

    @Override
    public STNumber subtract(STNumber numberToSubtract) {
        STNumber result;
        result = numberToSubtract.subtractToBinary(this);
        return result;
    }

    @Override
    public STNumber multiply(STNumber numberToMultiply) {
        STNumber result;
        result = numberToMultiply.multiplyToBinary(this);
        return result;
    }

    @Override
    public STNumber divide(STNumber numberToDivide) {
        STNumber result;
        result = numberToDivide.divideToBinary(this);
        return result;
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
    public STNumber addToBinary(STBinary scrabbleBinary) {
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
    public STNumber subtractToBinary(STBinary scrabbleBinary) {
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
    public STNumber multiplyToBinary(STBinary scrabbleBinary) {
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
    public STNumber divideToBinary(STBinary scrabbleBinary) {
        return null;
    }
}
