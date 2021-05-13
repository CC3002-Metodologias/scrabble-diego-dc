package tests;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class STBinaryTest {
    STBinary stBinary;

    @BeforeEach
    void setUp() {
        stBinary = new STBinary("1101");
    }

    @Test
    void STtoString() {
        String str = new String("1101");
        assertEquals(stBinary.STtoString(), str);
    }

    @Test
    void toSTString() {
        STString stString = new STString("1101");
        assertEquals(stBinary.toSTString(), stString);
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