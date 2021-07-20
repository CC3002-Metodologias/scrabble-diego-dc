package cl.uchile.dcc.scrabble.tests.ScrabbleTypes.STNumberTests;

import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.tests.ScrabbleTypes.AbstractScrabbleTypeTests;
import org.junit.jupiter.api.Test;

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
