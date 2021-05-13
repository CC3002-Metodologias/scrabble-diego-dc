package cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;

/**
 * A new ScrabbleType STInt -> references a Java int.
 */
public class STInt extends STNumber{

    private Integer myInt;

    // Getter & Setter
    public Integer getMyInt() {
        return myInt;
    }
    public void setMyInt(Integer myInt) {
        this.myInt = myInt;
    }

    // Constructor for our Class STInt
    public STInt(Integer newInt)
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
        return getMyInt().toString();
    }

    @Override
    public STString toSTString() {
        STString STStringTransform = new STString(this.getMyInt().toString());
        return STStringTransform;
    }

    public STNumber toSTFloat() {
        STFloat STFloatTransform = new STFloat(Double.valueOf(this.getMyInt()));
        return STFloatTransform;
    }

    public STInt toSTInt() {
        return this;
    }

    public STBinary toSTBinary() {
        String myBinary;
        Integer i = Math.abs(getMyInt());
        myBinary = Integer.toBinaryString(i);
        if(getMyInt() < 0)
        {
            myBinary = TwosComplement(myBinary);
        }
        STBinary newSTBinary = new STBinary(myBinary);
        return newSTBinary;
    }

    private String TwosComplement(String str)
    {
        int n = str.length();
        char[] ch = new char[n];
        int i;
        for (i = n-1 ; i >= 0 ; i--)
            if (ch[i] == '1')
                break;
        if (i == -1)
            return '1' + str;
        for (int k = i-1 ; k >= 0; k--)
        {
            //Just flip the values
            if (ch[k] == '1')
                ch[k] = '0';
            else
                ch[k] = '1';
        }
        String newStr = new String(ch);
        return newStr;
    }

}
