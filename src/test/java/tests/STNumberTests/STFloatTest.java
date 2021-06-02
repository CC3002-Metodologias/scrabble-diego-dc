package tests.STNumberTests;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.AbstractScrabbleTypeTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

class STFloatTest extends AbstractScrabbleTypeTests {
    STFloat positiveSTFloat;
    STFloat zeroSTFloat = new STFloat(0.0);
    STFloat negativeSTFloat;



    @BeforeEach
    void setUp() {
        positiveSTFloat = new STFloat(2.1);
        negativeSTFloat = new STFloat(-8.5);

    }

    @Override
    @Test
    protected void ConstructorTest() {
        var expectedSTFloat = new STFloat(2.1);
        var expectedNoParameterSTFloat = new STFloat();
        checkConstructor(expectedSTFloat, positiveSTFloat);
        checkConstructor(expectedNoParameterSTFloat, zeroSTFloat);
    }

    @Override
    @Test
    protected void STtoString() {
        String str = new String("2.1");
        String zeroStr = new String("0.0");
        checkSTtoString(str, positiveSTFloat);
        checkSTtoString(zeroStr, zeroSTFloat);
    }

    @Override
    @Test
    protected void toSTString() {
        STString stString = new STString("2.1");
        STString stStringNeg = new STString("-8.5");
        checkToSTString(stString, positiveSTFloat);
        checkToSTString(stStringNeg, negativeSTFloat);
        }

    @Override
    @Test
    protected void addToString() {
        STString completeStr = new STString("My float is: 2.1");
        STString str = new STString("My float is: ");
        checkAddToString(completeStr, str, positiveSTFloat);
    }

    @Test
    void toSTFloat() {
        assertEquals(positiveSTFloat, positiveSTFloat.toSTFloat());
    }
}