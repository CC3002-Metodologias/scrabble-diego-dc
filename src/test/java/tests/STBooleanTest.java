package tests;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class STBooleanTest {
    STBoolean stBoolean;

    @BeforeEach
    void setUp() {
        stBoolean = new STBoolean(true);
    }

    @Test
    void STtoString() {
        String str = new String("true");
        assertEquals(stBoolean.STtoString(), str);
    }

    @Test
    void toSTString() {
        STString stString = new STString("true");
        assertEquals(stBoolean.toSTString(), stString);
    }

    @Test
    void toSTBoolean() {
        assertEquals(stBoolean, stBoolean.toSTBoolean());
    }
}