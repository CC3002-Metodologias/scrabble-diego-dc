package cl.uchile.dcc.scrabble.gui.Flyweight.STFactory;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;

public class STFactory {

    private static STStringFactory STStringFactory = new STStringFactory();
    private static STBooleanFactory STBooleanFactory = new STBooleanFactory();
    private static STFloatFactory STFloatFactory = new STFloatFactory();
    private static STIntFactory STIntFactory = new STIntFactory();
    private static STBinaryFactory STBinaryFactory = new STBinaryFactory();


    public static STString createString(String value)
    {
        return STStringFactory.make(value);
    }

    public static STBoolean createBoolean(boolean value)
    {
        return STBooleanFactory.make(value);
    }

    public static STFloat createFloat(double value)
    {
        return STFloatFactory.make(value);
    }

    public static STInt createInt(int value)
    {
        return STIntFactory.make(value);
    }

    public static STBinary createBinary(String value)
    {
        return STBinaryFactory.make(value);
    }

}
