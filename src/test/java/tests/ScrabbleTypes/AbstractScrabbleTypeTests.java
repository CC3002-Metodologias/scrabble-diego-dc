package tests.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.Scrabble;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public abstract class AbstractScrabbleTypeTests {

    protected void checkConstructor(ScrabbleType expected, ScrabbleType actual) {
        assertEquals(expected, actual,
                "Constructor Error");
    }

    protected void checkSTtoString( String expected, ScrabbleType actual) {
        String Actual = actual.STtoString();
        assertEquals(expected, Actual,
                "String conversion wrong. Expected String: " + expected + ", Actual: " + Actual);
    }

    protected void checkToSTString(STString expected, ScrabbleType actual) {
        var Actual = actual.toSTString();
        assertEquals(expected, Actual,
                "STString conversion wrong. Expected STString " + expected.toString() + ", Actual: " + Actual.toString());
    }

    protected void checkAddToString(STString expected, STString scrabbleString, ScrabbleType scrabbleTypeToAdd)
    {
        var actual = scrabbleTypeToAdd.addToString(scrabbleString);
        assertEquals(expected, actual,
                "AddToString Error. Expected STString: " + expected.STtoString() + ", Actual STString: " + actual.STtoString());
    }

    @Test
    abstract protected void ConstructorTest();
    @Test
    abstract protected void STtoString();
    @Test
    abstract protected void toSTString();
    @Test
    abstract protected void addToString();

}
