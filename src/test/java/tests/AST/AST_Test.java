package tests.AST;

import cl.uchile.dcc.scrabble.gui.AST.Constant;
import cl.uchile.dcc.scrabble.gui.AST.STAddition;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AST_Test {
    STAddition addition;

    @BeforeEach
    void setUp() {
        addition = new STAddition(new Constant(new STInt(1)), new Constant(new STInt(1)));
    }

    @Test
    public void AST_test()
    {
        Constant expected = new Constant(new STInt(2));
        assertEquals(expected, addition.GetResult(), "Expected: " + expected.toST().STtoString() +", Actual: " + addition.GetResult().toST().STtoString());
    }
}