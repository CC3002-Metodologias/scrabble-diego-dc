package tests.STNumberTests;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.AbstractScrabbleTypeTests;

import static org.junit.jupiter.api.Assertions.*;

class STIntTest extends AbstractScrabbleTypeTests {
    private STInt positiveSTInt;
    private STInt zeroSTInt = new STInt(0);
    private STInt negativeSTInt;

    @BeforeEach
    void setUp() {
        positiveSTInt = new STInt(134);
        negativeSTInt = new STInt(-21);
    }

    @Override
    protected void ConstructorTest() {
        var expectedSTInt = new STInt(134);
        var expectedNoParameterSTInt = new STInt();
        checkConstructor(expectedSTInt, positiveSTInt);
        checkConstructor(expectedNoParameterSTInt, zeroSTInt);
    }

    @Override
    @Test
    protected void STtoString() {
        String str = "134";
        String zeroStr = "0";
        String negInt = "-21";
        checkSTtoString(str, positiveSTInt);
        checkSTtoString(zeroStr, zeroSTInt);
        checkSTtoString(negInt, negativeSTInt);
    }

    @Override
    @Test
    protected void toSTString() {
        STString stString = new STString("134");
        STString zeroSTString = new STString("0");
        checkToSTString(stString, positiveSTInt);
        checkToSTString(zeroSTString, zeroSTString);
    }

    @Override
    @Test
    protected void addToString() {
        STString completeStr = new STString("My int is: 134");
        STString str = new STString("My int is: ");
        checkAddToString(completeStr, str, positiveSTInt);
    }

    @Test
    void toSTFloat() {
        STFloat stFloat = new STFloat(134.0);
        assertEquals(positiveSTInt.toSTFloat(), stFloat);
    }

    @Test
    void toSTInt() {
        assertEquals(positiveSTInt, positiveSTInt.toSTInt());
    }

    @Test
    void toSTBinary() {
        STBinary stBinary = new STBinary("00000000000000000000000010000110");
        STBinary stBinary2 = new STBinary("00000000000000000000000000000000");
        STBinary stBinary3 = new STBinary("11111111111111111111111111101011");
        assertEquals(positiveSTInt.toSTBinary(), stBinary, "expected:" + (positiveSTInt.toSTBinary()).getMyString());
        assertEquals(zeroSTInt.toSTBinary(), stBinary2, "expected:" + (zeroSTInt.toSTBinary()).getMyString());
        assertEquals(negativeSTInt.toSTBinary(), stBinary3, "expected:" + (negativeSTInt.toSTBinary()).getMyString());
    }
}