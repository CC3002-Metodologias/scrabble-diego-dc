package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;

/**
 * A new ScrabbleType STBoolean -> references a Java Boolean.
 */

public class STBoolean implements ScrabbleType, ISTLogicalOperationCompatible {

    private boolean myBoolean;

    // Getter & Setter
    public boolean getMyBoolean() {
        return myBoolean;
    }
    public void setMyBoolean(boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    // Default Constructor parameterized of our class
    public STBoolean()
    {
        this.myBoolean = false;
    }

    // Constructor parameterized of our class
    public STBoolean(boolean newBoolean)
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
        STString STStringTransform = new STString(this.STtoString());
        return STStringTransform;
    }

    public STBoolean toSTBoolean() {
        return this;
    }

    @Override
    public STString addToString(STString scrabbleStr) {
        STString result = new STString();
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
    public ISTLogicalOperationCompatible conjunction(ISTLogicalOperationCompatible scrabbleType) {
        ISTLogicalOperationCompatible result;
        result = scrabbleType.conjunctionToBoolean(this);
        return result;
    }

    @Override
    public ISTLogicalOperationCompatible disjunction(ISTLogicalOperationCompatible scrabbleType) {
        ISTLogicalOperationCompatible result;
        result = scrabbleType.disjunctionToBoolean(this);
        return result;
    }

    @Override
    public STBinary conjunctionToBinary(STBinary scrabbleBinary) {
        STBinary result = new STBinary();
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

    @Override
    public STBinary disjunctionToBinary(STBinary scrabbleBinary) {
        STBinary result = new STBinary();
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

}
