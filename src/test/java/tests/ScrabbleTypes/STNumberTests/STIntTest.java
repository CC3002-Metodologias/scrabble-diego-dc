package tests.ScrabbleTypes.STNumberTests;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class STIntTest extends AbstractSTNumberOpTests {
    private STInt positiveSTInt;
    private STInt zeroSTInt = new STInt.int_builder(0).build();
    private STInt negativeSTInt;

    @BeforeEach
    void setUp() {
        positiveSTInt = new STInt(134);
        negativeSTInt = new STInt(-21);
    }

    @Override
    protected void ConstructorTest() {
        var expectedSTInt = new STInt(134);
        var expectedNoParameterSTInt = new STInt();
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
        STString stString = new STString("134");
        STString zeroSTString = new STString("0");
        checkToSTString(stString, positiveSTInt);
        checkToSTString(zeroSTString, zeroSTString);
    }

    @Override
    @Test
    protected void addToString() {
        STString completeStr = new STString("My int is: 134");
        STString str = new STString("My int is: ");
        checkAddToString(completeStr, str, positiveSTInt);
    }

    @Override
    @Test
    protected void toSTFloat() {
        STFloat stFloat = new STFloat(134.0);
        checkToSTFloat(stFloat , positiveSTInt);
    }


    @Test
    void toSTInt() {
        assertEquals(positiveSTInt, positiveSTInt.toSTInt());
    }

    @Test
    void toSTBinary() {
        STBinary stBinary = new STBinary("00000000000000000000000010000110");
        STBinary stBinary2 = new STBinary("00000000000000000000000000000000");
        STBinary stBinary3 = new STBinary("11111111111111111111111111101011");
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
        STFloat stFloat = new STFloat(5.5);
        STInt stInt = new STInt(7);
        STBinary stBinary = new STBinary("00000000000000000000000000010100"); // 20

        // Addition
        STFloat addSTFloatResult = new STFloat(-15.5);
        STInt addSTIntResult = new STInt(-14);
        STInt addSTBinaryResult = new STInt(-1);
        checkAddition(negativeSTInt, stFloat, stInt, stBinary, addSTFloatResult, addSTIntResult, addSTBinaryResult);

        // Subtraction
        STFloat subtractSTFloatResult = new STFloat(128.5);
        STInt subtractSTIntResult = new STInt(127);
        STInt subtractSTBinaryResult = new STInt(114);
        checkSubtraction(positiveSTInt, stFloat, stInt, stBinary, subtractSTFloatResult, subtractSTIntResult, subtractSTBinaryResult);

        // Multiplication
        STFloat multSTFloatResult = new STFloat(737);
        STInt multSTIntResult = new STInt(938);
        STInt multSTBinaryResult = new STInt(2680);
        checkMultiplication(positiveSTInt, stFloat, stInt, stBinary, multSTFloatResult, multSTIntResult, multSTBinaryResult);

        // Division
        STFloat divSTFloatResult = new STFloat(24.364);
        STInt divSTIntResult = new STInt(19);
        STInt divSTBinaryResult = new STInt(6);
        checkDivision(positiveSTInt, stFloat, stInt, stBinary, divSTFloatResult, divSTIntResult, divSTBinaryResult);
    }
}