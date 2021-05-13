package tests;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class STFloatTest {
    STFloat stFloat;

    @BeforeEach
    void setUp() {
        stFloat = new STFloat(2.2);
    }

    @Test
    void STtoString() {
        String str = new String("2.1");
        assertEquals(stFloat.STtoString(), str);
    }

    @Test
    void toSTString() {
        STString stString = new STString("2.1");
        assertEquals(stFloat.toSTString(), stString);
        }

    @Test
    void toSTFloat() {
        assertEquals(stFloat, stFloat.toSTFloat());
    }
}