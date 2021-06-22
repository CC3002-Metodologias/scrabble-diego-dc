package tests.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class STStringTest extends AbstractScrabbleTypeTests{
    private STString aSTString;
    private STString emptySTString = new STString("");

    @BeforeEach
    void setUp()
    {
        aSTString = new STString("hello, world!");
    }

    @Override
    @Test
    protected void ConstructorTest() {
        var expectedSTStr = new STString("hello, world!");
        var expectedNoParameterSTStr = new STString();
        checkConstructor(aSTString, aSTString);
        checkConstructor(expectedSTStr, aSTString);
        checkConstructor(expectedNoParameterSTStr, emptySTString);
    }

    @Override
    @Test
    protected void STtoString() {
        checkSTtoString("hello, world!", aSTString);
    }

    @Override
    @Test
    protected void toSTString() {
        var actual = aSTString.toSTString();
        checkToSTString(aSTString, actual);
    }

    @Override
    @Test
    protected void addToString() {
        STString completeStr = new STString("My String is: hello, world!");
        STString str = new STString("My String is: ");
        checkAddToString(completeStr, str, aSTString);
    }

    @Test
    void OperationTest()
    {
        STString completeSTR = new STString("My string is: hello, world!");
        STString str = new STString("My string is: ");
        assertEquals(completeSTR, str.add(aSTString), "Addition Failed. Expected: " + completeSTR.STtoString() + ", Actual: " + str.add(aSTString).STtoString());
    }

}