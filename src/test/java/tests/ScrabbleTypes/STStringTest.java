package tests.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.Flyweight.STFactory.STFactory;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class STStringTest extends AbstractScrabbleTypeTests{
    private STFactory stFactory = new STFactory();
    private STString aSTString;
    private STString emptySTString = STFactory.createString("");

    @BeforeEach
    void setUp()
    {
        aSTString = STFactory.createString("hello, world!");
    }

    @Test
    protected void NotEquals()
    {
        STString notEqual = STFactory.createString("hello, my world!");
        assertNotEquals(aSTString, "hello");
        assertNotEquals(aSTString, notEqual);
        assertNotEquals(aSTString, null);
    }

    @Override
    @Test
    protected void ConstructorTest() {
        var expectedSTStr = STFactory.createString("hello, world!");
        var expectedNoParameterSTStr = STFactory.createString("");
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
        STString completeStr = STFactory.createString("My String is: hello, world!");
        STString str = STFactory.createString("My String is: ");
        checkAddToString(completeStr, str, aSTString);
    }

    @Test
    void OperationTest()
    {
        STString completeSTR = STFactory.createString("My string is: hello, world!");
        STString str = STFactory.createString("My string is: ");
        assertEquals(completeSTR, str.add(aSTString), "Addition Failed. Expected: " + completeSTR.STtoString() + ", Actual: " + str.add(aSTString).STtoString());
    }

}