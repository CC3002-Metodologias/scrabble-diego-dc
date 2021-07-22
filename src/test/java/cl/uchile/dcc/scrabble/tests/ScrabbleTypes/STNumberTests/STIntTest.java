package cl.uchile.dcc.scrabble.tests.ScrabbleTypes.STNumberTests;

import cl.uchile.dcc.scrabble.model.Flyweight.STFactory.STFactory;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class STIntTest extends AbstractSTNumberOpTests {
    private STFactory stFactory = new STFactory();

    private STInt positiveSTInt;
    private STInt zeroSTInt = stFactory.createInt(0);
    private STInt negativeSTInt;

    @BeforeEach
    void setUp() {
        positiveSTInt = stFactory.createInt(134);
        negativeSTInt = stFactory.createInt(-21);
    }

    @Test
    protected void NotEquals()
    {
        assertNotEquals(positiveSTInt, "134");
        assertNotEquals(positiveSTInt, negativeSTInt);
        assertNotEquals(positiveSTInt, null);
    }

    @Override
    protected void ConstructorTest() {
        var expectedSTInt = stFactory.createInt(134);
        var expectedNoParameterSTInt = stFactory.createInt(0);
        checkConstructor(expectedSTInt, positiveSTInt);
        checkConstructor(expectedNoParameterSTInt, zeroSTInt);
    }

    @Override
    @Test
    protected void STtoString() {
        String str = "134";
        String zeroStr = "0";
        String negInt = "-21";
        checkSTtoString(str, positiveSTInt);
        checkSTtoString(zeroStr, zeroSTInt);
        checkSTtoString(negInt, negativeSTInt);
    }

    @Override
    @Test
    protected void toSTString() {
        STString stString = stFactory.createString("134");
        STString zeroSTString = stFactory.createString("0");
        checkToSTString(stString, positiveSTInt);
        checkToSTString(zeroSTString, zeroSTString);
    }

    @Override
    @Test
    protected void addToString() {
        STString completeStr = stFactory.createString("My int is: 134");
        STString str = stFactory.createString("My int is: ");
        checkAddToString(completeStr, str, positiveSTInt);
    }

    @Override
    @Test
    protected void toSTFloat() {
        STFloat stFloat = stFactory.createFloat(134.0);
        checkToSTFloat(stFloat , positiveSTInt);
    }


    @Test
    void toSTInt() {
        assertEquals(positiveSTInt, positiveSTInt.toSTInt());
    }

    @Test
    void toSTBinary() {
        STBinary stBinary = stFactory.createBinary("00000000000000000000000010000110");
        STBinary stBinary2 = stFactory.createBinary("00000000000000000000000000000000");
        STBinary stBinary3 = stFactory.createBinary("11111111111111111111111111101011");
        assertEquals(positiveSTInt.toSTBinary(), stBinary, "expected:" + (positiveSTInt.toSTBinary()).getMyString());
        assertEquals(zeroSTInt.toSTBinary(), stBinary2, "expected:" + (zeroSTInt.toSTBinary()).getMyString());
        assertEquals(negativeSTInt.toSTBinary(), stBinary3, "expected:" + (negativeSTInt.toSTBinary()).getMyString());
    }

    // method to help us test addition for each subType of STNumber compatible with Float
    void checkAddition( STInt leftNum, STFloat rightNum, STInt rightNum2, STBinary rightNum3,
                        STFloat expected1, STInt expected2, STInt expected3)
    {
        STNumber actual1 = leftNum.add(rightNum);
        STNumber actual2 = leftNum.add(rightNum2);
        STNumber actual3 = leftNum.add(rightNum3);
        assertEquals(expected1, actual1, "Addition Failed. Expected: " + expected1.STtoString() + ", Actual: " + actual1.STtoString());
        assertEquals(expected2, actual2, "Addition Failed. Expected: " + expected2.STtoString() + ", Actual: " + actual2.STtoString());
        assertEquals(expected3, actual3, "Addition Failed. Expected: " + expected3.STtoString() + ", Actual: " + actual3.STtoString());
    }

    // method to help us test subtraction for each subType of STNumber compatible with Float
    void checkSubtraction( STInt leftNum, STFloat rightNum, STInt rightNum2, STBinary rightNum3,
                           STFloat expected1, STInt expected2, STInt expected3)
    {
        STNumber actual1 = leftNum.subtract(rightNum);
        STNumber actual2 = leftNum.subtract(rightNum2);
        STNumber actual3 = leftNum.subtract(rightNum3);
        assertEquals(expected1, actual1, "Addition Failed. Expected: " + expected1.STtoString() + ", Actual: " + actual1.STtoString());
        assertEquals(expected2, actual2, "Addition Failed. Expected: " + expected2.STtoString() + ", Actual: " + actual2.STtoString());
        assertEquals(expected3, actual3, "Addition Failed. Expected: " + expected3.STtoString() + ", Actual: " + actual3.STtoString());
    }

    // method to help us test multiplication for each subType of STNumber compatible with Float
    void checkMultiplication( STInt leftNum, STFloat rightNum, STInt rightNum2, STBinary rightNum3,
                              STFloat expected1, STInt expected2, STInt expected3)
    {
        STNumber actual1 = leftNum.multiply(rightNum);
        STNumber actual2 = leftNum.multiply(rightNum2);
        STNumber actual3 = leftNum.multiply(rightNum3);
        assertEquals(expected1, actual1, "Addition Failed. Expected: " + expected1.STtoString() + ", Actual: " + actual1.STtoString());
        assertEquals(expected2, actual2, "Addition Failed. Expected: " + expected2.STtoString() + ", Actual: " + actual2.STtoString());
        assertEquals(expected3, actual3, "Addition Failed. Expected: " + expected3.STtoString() + ", Actual: " + actual3.STtoString());
    }
    // method to help us test division for each subType of STNumber compatible with Float
    void checkDivision( STInt leftNum, STFloat rightNum, STInt rightNum2, STBinary rightNum3,
                        STFloat expected1, STInt expected2, STInt expected3)
    {
        STNumber actual1 = leftNum.divide(rightNum);
        STNumber actual2 = leftNum.divide(rightNum2);
        STNumber actual3 = leftNum.divide(rightNum3);
        assertEquals(expected1, actual1, "Addition Failed. Expected: " + expected1.STtoString() + ", Actual: " + actual1.STtoString());
        assertEquals(expected2, actual2, "Addition Failed. Expected: " + expected2.STtoString() + ", Actual: " + actual2.STtoString());
        assertEquals(expected3, actual3, "Addition Failed. Expected: " + expected3.STtoString() + ", Actual: " + actual3.STtoString());
    }

    @Override
    @Test
    protected void NumericalOperationTests() {
        STFloat stFloat = stFactory.createFloat(5.5);
        STInt stInt = stFactory.createInt(7);
        STBinary stBinary = stFactory.createBinary("00000000000000000000000000010100"); // 20

        // Addition
        STFloat addSTFloatResult = stFactory.createFloat(-15.5);
        STInt addSTIntResult = stFactory.createInt(-14);
        STInt addSTBinaryResult = stFactory.createInt(-1);
        checkAddition(negativeSTInt, stFloat, stInt, stBinary, addSTFloatResult, addSTIntResult, addSTBinaryResult);

        // Subtraction
        STFloat subtractSTFloatResult = stFactory.createFloat(128.5);
        STInt subtractSTIntResult = stFactory.createInt(127);
        STInt subtractSTBinaryResult = stFactory.createInt(114);
        checkSubtraction(positiveSTInt, stFloat, stInt, stBinary, subtractSTFloatResult, subtractSTIntResult, subtractSTBinaryResult);

        // Multiplication
        STFloat multSTFloatResult = stFactory.createFloat(737);
        STInt multSTIntResult = stFactory.createInt(938);
        STInt multSTBinaryResult = stFactory.createInt(2680);
        checkMultiplication(positiveSTInt, stFloat, stInt, stBinary, multSTFloatResult, multSTIntResult, multSTBinaryResult);

        // Division
        STFloat divSTFloatResult = stFactory.createFloat(24.364);
        STInt divSTIntResult = stFactory.createInt(19);
        STInt divSTBinaryResult = stFactory.createInt(6);
        checkDivision(positiveSTInt, stFloat, stInt, stBinary, divSTFloatResult, divSTIntResult, divSTBinaryResult);
    }
}