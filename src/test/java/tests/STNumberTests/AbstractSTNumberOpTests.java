package tests.STNumberTests;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import tests.AbstractScrabbleTypeTests;
import org.junit.jupiter.api.Test;

import java.util.SplittableRandom;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractSTNumberOpTests extends AbstractScrabbleTypeTests {

    protected void checkToSTFloat(STNumber expected, STNumber actual){
        STFloat Actual = actual.toSTFloat();
        assertEquals(expected, Actual,
                "Transformation to float Failed. Expected: " + expected.STtoString() + ", Actual: " + Actual.STtoString());
    }

    @Test
    protected abstract void toSTFloat();
    @Test
    protected abstract void NumericalOperationTests();
}
