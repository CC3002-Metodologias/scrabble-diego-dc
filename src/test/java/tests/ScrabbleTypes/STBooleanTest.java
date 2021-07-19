package tests.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.Flyweight.STFactory.STFactory;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class STBooleanTest extends AbstractLogicOpTest {
    private STFactory stFactory = new STFactory();
    private STBoolean trueSTBoolean;
    private STBoolean falseSTBoolean;

    @BeforeEach
    void setUp() {
        trueSTBoolean = STFactory.createBoolean(true);
        falseSTBoolean = STFactory.createBoolean(false);
    }

    @Test
    protected void NotEquals()
    {
        assertNotEquals(trueSTBoolean, "true");
        assertNotEquals(trueSTBoolean, falseSTBoolean);
        assertNotEquals(trueSTBoolean, null);
    }

    @Override
    @Test
    protected void ConstructorTest() {
        var expectedSTBoolean = STFactory.createBoolean(true);
        var expectedNoParameterSTBoolean = STFactory.createBoolean(false);
        checkConstructor(expectedSTBoolean, trueSTBoolean);
        checkConstructor(expectedNoParameterSTBoolean, falseSTBoolean);
    }

    @Override
    @Test
    protected void STtoString() {
        String str = new String("true");
        checkSTtoString(str, trueSTBoolean);
    }

    @Override
    @Test
    protected void toSTString() {
        STString stString = STFactory.createString("true");
        checkToSTString(stString, trueSTBoolean);
    }

    @Override
    @Test
    protected void addToString()
    {
        STString completeStr = STFactory.createString("This boolean is: false");
        STString str = STFactory.createString("This boolean is: ");
        checkAddToString(completeStr, str, falseSTBoolean);
    }

    @Test
    void toSTBoolean() {
        var expected = trueSTBoolean.toSTBoolean();
        assertEquals(expected, trueSTBoolean);
    }

    @Override
    @Test
    protected void LogicOperationTests()
    {
        STBinary stBinary = STFactory.createBinary("00000000000000000000000000110110"); // 54
        STBinary stBinaryZero = STFactory.createBinary("00000000000000000000000000000000"); // 0
        STBinary stBinaryOnes = STFactory.createBinary("11111111111111111111111111111111"); // -1
        STBoolean TstBoolean = STFactory.createBoolean(true);
        STBoolean FstBoolean = STFactory.createBoolean(false);

        // Logical operations -> unary.
        checkNegation(FstBoolean, trueSTBoolean);
        checkNegation(TstBoolean, falseSTBoolean);

        // Logical operations -> binary.

        // CONJUNCTION (and)
        // bool|bool
        checkConjunction(TstBoolean, trueSTBoolean, trueSTBoolean); // true and true = true
        checkConjunction(FstBoolean, trueSTBoolean, falseSTBoolean); // true and false = false
        checkConjunction(FstBoolean, falseSTBoolean, trueSTBoolean); // false and true = false
        checkConjunction(FstBoolean, falseSTBoolean, falseSTBoolean); // false and false = false
        // bool|binary
        checkConjunction(stBinary, trueSTBoolean, stBinary); // true (1) and 00000000000000000000000000110110 = 00000000000000000000000000110110
        checkConjunction(stBinaryZero, falseSTBoolean, stBinary); // false (0) and 00000000000000000000000000110110 = 00000000000000000000000000000000
        // DISJUNCTION (or)
        // bool|bool
        checkDisjunction(TstBoolean, trueSTBoolean, trueSTBoolean); // true or true = true
        checkDisjunction(TstBoolean, trueSTBoolean, falseSTBoolean); // true or false = true
        checkDisjunction(TstBoolean, falseSTBoolean, trueSTBoolean); // false or true = true
        checkDisjunction(FstBoolean, falseSTBoolean, falseSTBoolean); // false or false = false
        // bool|binary
        checkDisjunction(stBinaryOnes, trueSTBoolean, stBinary); // true (1) or 00000000000000000000000000110110 = 11111111111111111111111111111111
        checkDisjunction(stBinary, falseSTBoolean, stBinary); // false (0) and 00000000000000000000000000110110 = 00000000000000000000000000110110

    }
}