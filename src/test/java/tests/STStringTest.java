package tests;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class STStringTest extends AbstractScrabbleTypeTests{
    private STString aSTString;
    private STString emptySTString = new STString("");

    @BeforeEach
    void setUp()
    {
        aSTString = new STString("hello, world!");
    }

    @Override
    protected void ConstructorTest() {
        var expectedSTStr = new STString("hello, world!");
        var expectedNoParameterSTStr = new STString();
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

}