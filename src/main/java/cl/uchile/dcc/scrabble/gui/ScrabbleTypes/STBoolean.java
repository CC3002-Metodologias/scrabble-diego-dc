package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.Flyweight.ScrabbleTypeFlyweight;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;

/**
 * A new ScrabbleType-Boolean, reference to a boolean.
 *
 * @author Diego Caviedes A.
 */

public class STBoolean implements ScrabbleType, ISTLogicalOperationCompatible {

    public static class boolean_builder {
        boolean myValue;

        public boolean_builder() {
            this.myValue = false;
        }

        public boolean_builder(boolean newBoolean) {
            this.myValue = newBoolean;
        }

        /**
         * Public constructor for a STFloat.
         * The purpose is to save Memory:
         * will only create a STInt if there is no other
         * STInt created with the same value before.
         */
        public STBoolean build() {
            // check if there is already an STInt with this value created.
            ScrabbleType result = ScrabbleTypeFlyweight.checkDictionary(myValue);
            // if not
            if (result == null) {
                // Create a new STInt and add to the Dictionary.
                result = new STBoolean(myValue);
                ScrabbleTypeFlyweight.addElement(myValue, result);
            }
            // it can only be a STInt
            return (STBoolean)result;
        }
    }

    private boolean myBoolean;

    /** Getter. Returns referenced boolean of this STBoolean */
    public boolean getMyBoolean() {
        return myBoolean;
    }

    /** Setter. Sets the given boolean to this STBoolean */
    public void setMyBoolean(boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    /**
     * Default Constructor for a STSBoolean
     * Creates a STBoolean with a false value as default.
     */
    private STBoolean()
    {
        this.myBoolean = false;
    }

    /**
     * Parameterized Constructor for a STSBoolean
     * Creates a STBoolean with a given boolean value.
     */
    private STBoolean(boolean newBoolean)
    {
        this.myBoolean = newBoolean;
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
        if (!(o instanceof STBoolean))
            return false;
        STBoolean STboolean = (STBoolean) o;
        // field comparison
        return this.getMyBoolean() == STboolean.getMyBoolean();
    }

    @Override
    public String STtoString() {
        Boolean i = getMyBoolean();
        return i.toString();
    }

    @Override
    public STString toSTString() {
        STString STStringTransform = new STString.string_builder(this.STtoString()).build();
        return STStringTransform;
    }

    /** Transformation of this STBoolean to a STBoolean */
    public STBoolean toSTBoolean() {
        return this;
    }



    @Override
    public STString addToString(STString scrabbleStr) {
        STString result = new STString.string_builder().build();
        STString thisToString = this.toSTString();
        result.setMyString(scrabbleStr.getMyString() + thisToString.getMyString());
        return result;
    }

    @Override
    public ISTLogicalOperationCompatible negation(){
        STBoolean result = new STBoolean();
        result.setMyBoolean(!this.getMyBoolean());
        return result;
    }


    @Override
    public ISTLogicalOperationCompatible conjunction(ScrabbleType scrabbleType) {
        ISTLogicalOperationCompatible result;
        result = (ISTLogicalOperationCompatible)scrabbleType.conjunctionToBoolean(this);
        return result;
    }

    @Override
    public ISTLogicalOperationCompatible disjunction(ScrabbleType scrabbleType) {
        ISTLogicalOperationCompatible result;
        result = scrabbleType.disjunctionToBoolean(this);
        return result;
    }


    /**
     * {@inheritDoc}
     *
     * Conjunction to a binary is bit to bit.
     * If boolean false -> 0
     * If boolean true -> 1
     * @param scrabbleBinary
     *      Binary Operated with this STBoolean
     * @return
     *      A STSBinary as result of the operation.
     */
    @Override
    public STBinary conjunctionToBinary(STBinary scrabbleBinary) {
        STBinary result = new STBinary.binary_builder().build();
        if(this.getMyBoolean() == false)
        {
            return result;
        }
        result.setMyString(scrabbleBinary.getMyString());
        return result;
    }

    @Override
    public ISTLogicalOperationCompatible conjunctionToBoolean(STBoolean scrabbleBool) {
        STBoolean result = new STBoolean();
        result.setMyBoolean(scrabbleBool.getMyBoolean() && this.getMyBoolean());
        return result;
    }

    /**
     * {@inheritDoc}
     *
     * Disjunction to a binary is bit to bit.
     * If boolean false -> 0
     * If boolean true -> 1
     * @param scrabbleBinary
     *      Binary Operated with this STBoolean
     * @return
     *      A STSBinary as result of the operation.
     */
    @Override
    public STBinary disjunctionToBinary(STBinary scrabbleBinary) {
        STBinary result = new STBinary.binary_builder().build();
        if(this.getMyBoolean() == true)
        {
            StringBuffer strBf = new StringBuffer();
            strBf.append(scrabbleBinary.getMyString());
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
        result.setMyString(scrabbleBinary.getMyString());
        return result;
    }

    @Override
    public ISTLogicalOperationCompatible disjunctionToBoolean(STBoolean scrabbleBool) {
        STBoolean result = new STBoolean();
        result.setMyBoolean(scrabbleBool.getMyBoolean() || this.getMyBoolean());
        return result;
    }

    // ------------------------------ Null Methods --------------------------


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
    public ScrabbleType add(ScrabbleType n) {
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
}
