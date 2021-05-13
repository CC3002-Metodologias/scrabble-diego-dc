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

    @BeforeEach
    void setUp() {
        stInt = new STInt(2);
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
        STBinary stBinary = new STBinary("10");
        assertEquals(stInt.toSTBinary(), stBinary);
    }
}