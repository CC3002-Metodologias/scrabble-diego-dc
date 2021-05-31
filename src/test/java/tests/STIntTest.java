package tests;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class STIntTest {
    private STInt stInt;
    private STInt zeroInt = new STInt(0);
    private STInt negativestInt;

    @BeforeEach
    void setUp() {
        stInt = new STInt(134);
        negativestInt = new STInt(-21);
    }

    @Test
    void STtoString() {
        String str = new String("2");
        assertEquals(stInt.toSTString(), str);
    }

    @Test
    void toSTString() {
        STString stString = new STString("2");
        assertEquals(stInt.toSTString(), stString);
    }

    @Test
    void toSTFloat() {
        STFloat stFloat = new STFloat(2.0);
        assertEquals(stInt.toSTFloat(), stFloat);
    }

    @Test
    void toSTInt() {
        assertEquals(stInt, stInt.toSTInt());
    }

    @Test
    void toSTBinary() {
        STBinary stBinary = new STBinary("00000000000000000000000010000110");
        STBinary stBinary2 = new STBinary("00000000000000000000000000000000");
        STBinary stBinary3 = new STBinary("11111111111111111111111111101011");
        assertEquals(stInt.toSTBinary(), stBinary, "expected:" + (stInt.toSTBinary()).getMyString());
        assertEquals(zeroInt.toSTBinary(), stBinary2, "expected:" + (zeroInt.toSTBinary()).getMyString());
        assertEquals(negativestInt.toSTBinary(), stBinary3, "expected:" + (negativestInt.toSTBinary()).getMyString());
    }
}