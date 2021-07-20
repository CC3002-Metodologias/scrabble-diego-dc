package cl.uchile.dcc.scrabble.tests.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class STBooleanTest extends AbstractLogicOpTest {
    STBoolean trueSTBoolean;
    STBoolean falseSTBoolean;

    @BeforeEach
    void setUp() {
        trueSTBoolean = new STBoolean(true);
        falseSTBoolean = new STBoolean(false);
    }

    @Override
    @Test
    protected void ConstructorTest() {
        var expectedSTBoolean = new STBoolean(true);
        var expectedNoParameterSTBoolean = new STBoolean();
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
        STString stString = new STString("true");
        checkToSTString(stString, trueSTBoolean);
    }

    @Override
    @Test
    protected void addToString()
    {
        STString completeStr = new STString("This boolean is: false");
        STString str = new STString("This boolean is: ");
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
        STBinary stBinary = new STBinary("00000000000000000000000000110110"); // 54
        STBinary stBinaryZero = new STBinary("00000000000000000000000000000000"); // 0
        STBinary stBinaryOnes = new STBinary("11111111111111111111111111111111"); // -1
        STBoolean TstBoolean = new STBoolean(true);
        STBoolean FstBoolean = new STBoolean(false);

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