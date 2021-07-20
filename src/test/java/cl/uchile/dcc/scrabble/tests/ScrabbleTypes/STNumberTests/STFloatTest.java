package cl.uchile.dcc.scrabble.tests.ScrabbleTypes.STNumberTests;

import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class STFloatTest extends AbstractSTNumberOpTests {
    STFloat positiveSTFloat;
    STFloat zeroSTFloat = new STFloat(0.0);
    STFloat negativeSTFloat;



    @BeforeEach
    void setUp() {
        positiveSTFloat = new STFloat(2.1);
        negativeSTFloat = new STFloat(-8.5);

    }

    @Override
    @Test
    protected void ConstructorTest() {
        var expectedSTFloat = new STFloat(2.1);
        var expectedNoParameterSTFloat = new STFloat();
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
        STString stString = new STString("2.1");
        STString stStringNeg = new STString("-8.5");
        checkToSTString(stString, positiveSTFloat);
        checkToSTString(stStringNeg, negativeSTFloat);
        }

    @Override
    @Test
    protected void addToString() {
        STString completeStr = new STString("My float is: 2.1");
        STString str = new STString("My float is: ");
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
        STFloat stFloat = new STFloat(10.5);
        STInt stInt = new STInt(5);
        STBinary stBinary = new STBinary("00000000000000000000000000010100"); // 20

        // Addition
        STFloat addSTFloatResult = new STFloat(2.0);
        STFloat addSTIntResult = new STFloat(-3.5);
        STFloat addSTBinaryResult = new STFloat(11.5);
        checkAddition(negativeSTFloat, stFloat, stInt, stBinary, addSTFloatResult, addSTIntResult, addSTBinaryResult);

        // Subtraction
        STFloat subtractSTFloatResult = new STFloat(-8.4);
        STFloat subtractSTIntResult = new STFloat(-2.9);
        STFloat subtractSTBinaryResult = new STFloat(-17.9);
        checkSubtraction(positiveSTFloat, stFloat, stInt, stBinary, subtractSTFloatResult, subtractSTIntResult, subtractSTBinaryResult);

        // Multiplication
        STFloat multSTFloatResult = new STFloat(22.05);
        STFloat multSTIntResult = new STFloat(10.5);
        STFloat multSTBinaryResult = new STFloat(42.0);
        checkMultiplication(positiveSTFloat, stFloat, stInt, stBinary, multSTFloatResult, multSTIntResult, multSTBinaryResult);

        // Division
        STFloat divSTFloatResult = new STFloat(0.20);
        STFloat divSTIntResult = new STFloat(0.420);
        STFloat divSTBinaryResult = new STFloat(0.105);
        checkDivision(positiveSTFloat, stFloat, stInt, stBinary, divSTFloatResult, divSTIntResult, divSTBinaryResult);
    }
}