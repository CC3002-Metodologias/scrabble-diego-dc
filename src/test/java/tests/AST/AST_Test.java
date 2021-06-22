package tests.AST;

import cl.uchile.dcc.scrabble.gui.AST.NumericConstant;
import cl.uchile.dcc.scrabble.gui.AST.StringConstant;
import cl.uchile.dcc.scrabble.gui.AST.STAddition;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AST_Test {
    STAddition addition;

    @BeforeEach
    void setUp() {
        addition = new STAddition(new NumericConstant(new STInt(1)), new NumericConstant(new STInt(1)));
    }

    @Test
    public void AST_test()
    {
        assertEquals(new NumericConstant(new STInt(2)), addition.GetResult(), "result: " + addition.GetResult().toST().toString() );
    }
}