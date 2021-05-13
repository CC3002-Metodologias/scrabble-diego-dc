package tests;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class STStringTest {
    private STString stString;

    @BeforeEach
    void setUp()
    {
        stString = new STString("hello, world!");
    }

    @org.junit.jupiter.api.Test
    void STtoString() {
        assertEquals(stString.STtoString(), "hello, world!");
    }

    @org.junit.jupiter.api.Test
    void toSTString() {
        assertEquals(stString, stString.toSTString());
    }
}