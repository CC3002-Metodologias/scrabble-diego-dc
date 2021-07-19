package tests.ScrabbleTypes.STNumberTests;

import cl.uchile.dcc.scrabble.gui.Flyweight.STFactory.STFactory;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class STFloatTest extends AbstractSTNumberOpTests {
    STFactory stFactory = new STFactory();
    STFloat positiveSTFloat;
    STFloat zeroSTFloat = stFactory.createFloat(0.0);
    STFloat negativeSTFloat;



    @BeforeEach
    void setUp() {
        positiveSTFloat = stFactory.createFloat(2.1);
        negativeSTFloat = stFactory.createFloat(-8.5);

    }

    @Test
    protected void NotEquals()
    {
        assertNotEquals(positiveSTFloat, "2.1");
        assertNotEquals(positiveSTFloat, negativeSTFloat);
        assertNotEquals(positiveSTFloat, null);
    }

    @Override
    @Test
    protected void ConstructorTest() {
        var expectedSTFloat = stFactory.createFloat(2.1);
        var expectedNoParameterSTFloat = stFactory.createFloat(0.0);
        checkConstructor(expectedSTFloat, positiveSTFloat);
        checkConstructor(expectedNoParameterSTFloat, zeroSTFloat);
    }

    @Override
    @Test
    protected void STtoString() {
        String str = new String("2.1");
        String zeroStr = new String("0.0");
        checkSTtoString(str, positiveSTFloat);
        checkSTtoString(zeroStr, zeroSTFloat);
    }

    @Override
    @Test
    protected void toSTString() {
        STString stString = stFactory.createString("2.1");
        STString stStringNeg = stFactory.createString("-8.5");
        checkToSTString(stString, positiveSTFloat);
        checkToSTString(stStringNeg, negativeSTFloat);
        }

    @Override
    @Test
    protected void addToString() {
        STString completeStr = stFactory.createString("My float is: 2.1");
        STString str = stFactory.createString("My float is: ");
        checkAddToString(completeStr, str, positiveSTFloat);
    }

    @Override
    @Test
    protected void toSTFloat() {
        checkToSTFloat(positiveSTFloat, positiveSTFloat);
    }

    // method to help us test addition for each subType of STNumber compatible with Float
    void checkAddition( STFloat leftNum, STFloat rightNum, STInt rightNum2, STBinary rightNum3,
                        STFloat expected1, STFloat expected2, STFloat expected3)
    {
        STNumber actual1 = leftNum.add(rightNum);
        STNumber actual2 = leftNum.add(rightNum2);
        STNumber actual3 = leftNum.add(rightNum3);
        assertEquals(expected1, actual1, "Addition Failed. Expected: " + expected1.STtoString() + ", Actual: " + actual1.STtoString());
        assertEquals(expected2, actual2, "Addition Failed. Expected: " + expected2.STtoString() + ", Actual: " + actual2.STtoString());
        assertEquals(expected3, actual3, "Addition Failed. Expected: " + expected3.STtoString() + ", Actual: " + actual3.STtoString());
    }

    // method to help us test subtraction for each subType of STNumber compatible with Float
    void checkSubtraction( STFloat leftNum, STFloat rightNum, STInt rightNum2, STBinary rightNum3,
                        STFloat expected1, STFloat expected2, STFloat expected3)
    {
        STNumber actual1 = leftNum.subtract(rightNum);
        STNumber actual2 = leftNum.subtract(rightNum2);
        STNumber actual3 = leftNum.subtract(rightNum3);
        assertEquals(expected1, actual1, "Addition Failed. Expected: " + expected1.STtoString() + ", Actual: " + actual1.STtoString());
        assertEquals(expected2, actual2, "Addition Failed. Expected: " + expected2.STtoString() + ", Actual: " + actual2.STtoString());
        assertEquals(expected3, actual3, "Addition Failed. Expected: " + expected3.STtoString() + ", Actual: " + actual3.STtoString());
    }

    // method to help us test multiplication for each subType of STNumber compatible with Float
    void checkMultiplication( STFloat leftNum, STFloat rightNum, STInt rightNum2, STBinary rightNum3,
                           STFloat expected1, STFloat expected2, STFloat expected3)
    {
        STNumber actual1 = leftNum.multiply(rightNum);
        STNumber actual2 = leftNum.multiply(rightNum2);
        STNumber actual3 = leftNum.multiply(rightNum3);
        assertEquals(expected1, actual1, "Addition Failed. Expected: " + expected1.STtoString() + ", Actual: " + actual1.STtoString());
        assertEquals(expected2, actual2, "Addition Failed. Expected: " + expected2.STtoString() + ", Actual: " + actual2.STtoString());
        assertEquals(expected3, actual3, "Addition Failed. Expected: " + expected3.STtoString() + ", Actual: " + actual3.STtoString());
    }

    // method to help us test division for each subType of STNumber compatible with Float
    void checkDivision( STFloat leftNum, STFloat rightNum, STInt rightNum2, STBinary rightNum3,
                              STFloat expected1, STFloat expected2, STFloat expected3)
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
        STFloat stFloat = stFactory.createFloat(10.5);
        STInt stInt = stFactory.createInt(5);
        STBinary stBinary = stFactory.createBinary("00000000000000000000000000010100"); // 20

        // Addition
        STFloat addSTFloatResult = stFactory.createFloat(2.0);
        STFloat addSTIntResult = stFactory.createFloat(-3.5);
        STFloat addSTBinaryResult = stFactory.createFloat(11.5);
        checkAddition(negativeSTFloat, stFloat, stInt, stBinary, addSTFloatResult, addSTIntResult, addSTBinaryResult);

        // Subtraction
        STFloat subtractSTFloatResult = stFactory.createFloat(-8.4);
        STFloat subtractSTIntResult = stFactory.createFloat(-2.9);
        STFloat subtractSTBinaryResult = stFactory.createFloat(-17.9);
        checkSubtraction(positiveSTFloat, stFloat, stInt, stBinary, subtractSTFloatResult, subtractSTIntResult, subtractSTBinaryResult);

        // Multiplication
        STFloat multSTFloatResult = stFactory.createFloat(22.05);
        STFloat multSTIntResult = stFactory.createFloat(10.5);
        STFloat multSTBinaryResult = stFactory.createFloat(42.0);
        checkMultiplication(positiveSTFloat, stFloat, stInt, stBinary, multSTFloatResult, multSTIntResult, multSTBinaryResult);

        // Division
        STFloat divSTFloatResult = stFactory.createFloat(0.20);
        STFloat divSTIntResult = stFactory.createFloat(0.420);
        STFloat divSTBinaryResult = stFactory.createFloat(0.105);
        checkDivision(positiveSTFloat, stFloat, stInt, stBinary, divSTFloatResult, divSTIntResult, divSTBinaryResult);
    }
}