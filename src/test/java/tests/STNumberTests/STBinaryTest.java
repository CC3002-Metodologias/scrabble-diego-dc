package tests.STNumberTests;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.AbstractScrabbleTypeTests;

import static org.junit.jupiter.api.Assertions.*;

class STBinaryTest extends AbstractScrabbleTypeTests {
    STBinary positiveSTBinary;
    STBinary zeroSTBinary = new STBinary("00000000000000000000000000000000"); // 0
    STBinary negativeSTBinary;

    @BeforeEach
    void setUp() {
        positiveSTBinary = new STBinary("00000000000000000000000000010101"); // 21
        negativeSTBinary = new STBinary("11111111111111111111111111111000"); // -8
    }

    @Override
    @Test
    protected void ConstructorTest() {
         var expectedSTBinary = new STBinary("00000000000000000000000000010101");
         var expectedNoParameterSTBinary = new STBinary();
         checkConstructor(expectedSTBinary, positiveSTBinary);
         checkConstructor(expectedNoParameterSTBinary, zeroSTBinary);
    }

    @Override
    @Test
    protected void STtoString() {
        String str = "00000000000000000000000000010101";
        String zeroStr = "00000000000000000000000000000000";
        String negStr = "11111111111111111111111111111000";
        checkSTtoString(str, positiveSTBinary);
        checkSTtoString(zeroStr, zeroSTBinary);
        checkSTtoString(negStr, negativeSTBinary);
    }

    @Override
    @Test
    protected void toSTString() {
        STString stString = new STString("00000000000000000000000000010101");
        STString negSTString = new STString("11111111111111111111111111111000");
        checkToSTString(stString, positiveSTBinary);
        checkToSTString(negSTString, negativeSTBinary);
    }

    @Override
    @Test
    protected void addToString() {
        STString completeStr = new STString("My binary is: 00000000000000000000000000010101");
        STString str = new STString("My binary is: ");
        checkAddToString(completeStr, str, positiveSTBinary);
    }

    @Test
    void toSTFloat() {
    }

    @Test
    void toSTInt() {
    }

    @Test
    void toSTBinary() {
    }
}