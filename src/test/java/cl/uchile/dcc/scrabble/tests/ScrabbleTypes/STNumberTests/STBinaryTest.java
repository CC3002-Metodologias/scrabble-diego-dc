package cl.uchile.dcc.scrabble.tests.ScrabbleTypes.STNumberTests;

import cl.uchile.dcc.scrabble.model.Flyweight.STFactory.STFactory;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cl.uchile.dcc.scrabble.tests.ScrabbleTypes.AbstractLogicOpTest;

import static org.junit.jupiter.api.Assertions.*;

class STBinaryTest extends AbstractLogicOpTest {
    STFactory stFactory = new STFactory();
    STBinary positiveSTBinary;
    STBinary zeroSTBinary = stFactory.createBinary("00000000000000000000000000000000"); // 0
    STBinary negativeSTBinary;

    @BeforeEach
    void setUp() {
        positiveSTBinary = stFactory.createBinary("00000000000000000000000000010101"); // 21
        negativeSTBinary = stFactory.createBinary("11111111111111111111111111111000"); // -8
    }

    @Test
    protected void NotEquals()
    {
        assertNotEquals(positiveSTBinary, "2.1");
        assertNotEquals(positiveSTBinary, negativeSTBinary);
        assertNotEquals(positiveSTBinary, null);
    }

    @Override
    @Test
    protected void ConstructorTest() {
         var expectedSTBinary = stFactory.createBinary("00000000000000000000000000010101");
         var expectedNoParameterSTBinary = stFactory.createBinary("00000000000000000000000000000000");
         checkConstructor(expectedSTBinary, positiveSTBinary);
         checkConstructor(expectedNoParameterSTBinary, zeroSTBinary);
    }

    @Override
    @Test
    protected void STtoString() {
        String str = "00000000000000000000000000010101";
        String zeroStr = "00000000000000000000000000000000";
        String negStr = "11111111111111111111111111111000";
        checkSTtoString(str, positiveSTBinary);
        checkSTtoString(zeroStr, zeroSTBinary);
        checkSTtoString(negStr, negativeSTBinary);
    }

    @Override
    @Test
    protected void toSTString() {
        STString stString = stFactory.createString("00000000000000000000000000010101");
        STString negSTString = stFactory.createString("11111111111111111111111111111000");
        checkToSTString(stString, positiveSTBinary);
        checkToSTString(negSTString, negativeSTBinary);
    }

    @Override
    @Test
    protected void addToString() {
        STString completeStr = stFactory.createString("My binary is: 00000000000000000000000000010101");
        STString str = stFactory.createString("My binary is: ");
        checkAddToString(completeStr, str, positiveSTBinary);
    }

    @Test
    void toSTFloat() {
        STFloat positiveSTFloat = stFactory.createFloat(21.0);
        STFloat negativeSTFloat = stFactory.createFloat(-8.0);
        STFloat zeroSTFloat = stFactory.createFloat(0);
        assertEquals(positiveSTFloat, positiveSTBinary.toSTFloat(),
                "Transformation Failed. Expected: " + positiveSTFloat.STtoString() + ", Actual: " + positiveSTBinary.toSTInt().STtoString());
        assertEquals(negativeSTFloat, negativeSTBinary.toSTFloat(),
                "Transformation Failed. Expected: " + negativeSTFloat.STtoString() + ", Actual: " + negativeSTBinary.toSTInt().STtoString());
        assertEquals(zeroSTFloat, zeroSTBinary.toSTFloat(),
                "Transformation Failed. Expected: " + zeroSTFloat.STtoString() + ", Actual: " + zeroSTBinary.toSTInt().STtoString());
    }

    @Test
    void toSTInt() {
        STInt positiveSTInt = stFactory.createInt(21);
        STInt negativeSTInt = stFactory.createInt(-8);
        STInt zeroSTInt = stFactory.createInt(0);
        assertEquals(positiveSTInt, positiveSTBinary.toSTInt(),
                "Transformation Failed. Expected: " + positiveSTInt.STtoString() + ", Actual: " + positiveSTBinary.toSTInt().STtoString());
        assertEquals(negativeSTInt, negativeSTBinary.toSTInt(),
                "Transformation Failed. Expected: " + negativeSTInt.STtoString() + ", Actual: " + negativeSTBinary.toSTInt().STtoString());
        assertEquals(zeroSTInt, zeroSTBinary.toSTInt(),
                "Transformation Failed. Expected: " + zeroSTInt.STtoString() + ", Actual: " + zeroSTBinary.toSTInt().STtoString());
    }

    @Test
    void toSTBinary() {
        STBinary sameBinary = stFactory.createBinary("00000000000000000000000000010101");
        assertEquals(sameBinary, positiveSTBinary.toSTBinary());
    }

    @Override
    @Test
    protected void LogicOperationTests() {
        STBinary stBinaryZero = stFactory.createBinary("00000000000000000000000000000000"); // 0
        STBinary stBinaryOnes = stFactory.createBinary("11111111111111111111111111111111"); // -1
        STBinary stBinaryOpposite = stFactory.createBinary("11111111111111111111111111101010"); // negation of PositiveSTBinary
        STBinary stBinaryConjunction = stFactory.createBinary("00000000000000000000000000010000"); // PosSTB and NegSTB
        STBinary stBinaryDisjunction = stFactory.createBinary("11111111111111111111111111111101"); // PosSTB or NegSTB
        STBoolean TstBoolean = stFactory.createBoolean(true);
        STBoolean FstBoolean = stFactory.createBoolean(false);

        // Logical operations -> unary.
        checkNegation(stBinaryOpposite, positiveSTBinary);

        // Logical operations -> binary.

        // CONJUNCTION (and)
        // binary|binary
        checkConjunction(positiveSTBinary, positiveSTBinary, stBinaryOnes); // 00000000000000000000000000010101 and 11111111111111111111111111111111 = 00000000000000000000000000010101
        checkConjunction(stBinaryZero, positiveSTBinary, stBinaryZero); // 00000000000000000000000000010101 and 00000000000000000000000000000000 = 00000000000000000000000000000000
        checkConjunction(stBinaryConjunction, positiveSTBinary, negativeSTBinary); // 00000000000000000000000000010101 and 11111111111111111111111111111000 = 0000000000000000000000000010000
        // binary|bool
        checkConjunction(positiveSTBinary, positiveSTBinary, TstBoolean); // 00000000000000000000000000010101 and true (1) = 00000000000000000000000000010101
        checkConjunction(stBinaryZero, positiveSTBinary, FstBoolean); // 00000000000000000000000000010101 and false (0) = 00000000000000000000000000000000
        // DISJUNCTION (or)
        // binary|binary
        checkDisjunction(stBinaryOnes, positiveSTBinary, stBinaryOnes); // 00000000000000000000000000010101 or 11111111111111111111111111111111 = 11111111111111111111111111111111
        checkDisjunction(positiveSTBinary, positiveSTBinary, stBinaryZero); // 00000000000000000000000000010101 or 00000000000000000000000000000000 = 00000000000000000000000000010101
        checkDisjunction(stBinaryDisjunction, positiveSTBinary, negativeSTBinary); // 00000000000000000000000000010101 or 11111111111111111111111111111000 = 11111111111111111111111111111101
        // binary|bool
        checkDisjunction(stBinaryOnes, positiveSTBinary, TstBoolean); // 00000000000000000000000000010101 or true (1) = 11111111111111111111111111111111
        checkDisjunction(positiveSTBinary, positiveSTBinary, FstBoolean); // 00000000000000000000000000010101 or false (0) = 00000000000000000000000000010101
    }

    // method to help us test addition for each subType of STNumber compatible with Float
    void checkAddition(STBinary leftNum, STInt rightNum, STBinary rightNum2,
                       STBinary expected1, STBinary expected2)
    {
        STNumber actual1 = leftNum.add(rightNum);
        STNumber actual2 = leftNum.add(rightNum2);
        assertEquals(expected1, actual1, "Addition Failed. Expected: " + expected1.STtoString() + ", Actual: " + actual1.STtoString());
        assertEquals(expected2, actual2, "Addition Failed. Expected: " + expected2.STtoString() + ", Actual: " + actual2.STtoString());
    }

    // method to help us test subtraction for each subType of STNumber compatible with Float
    void checkSubtraction( STBinary leftNum, STInt rightNum, STBinary rightNum2,
                           STBinary expected1, STBinary expected2 )
    {
        STNumber actual1 = leftNum.subtract(rightNum);
        STNumber actual2 = leftNum.subtract(rightNum2);
        assertEquals(expected1, actual1, "Addition Failed. Expected: " + expected1.STtoString() + ", Actual: " + actual1.STtoString());
        assertEquals(expected2, actual2, "Addition Failed. Expected: " + expected2.STtoString() + ", Actual: " + actual2.STtoString());
    }

    // method to help us test multiplication for each subType of STNumber compatible with Float
    void checkMultiplication( STBinary leftNum, STInt rightNum, STBinary rightNum2,
                              STBinary expected1, STBinary expected2)
    {
        STNumber actual1 = leftNum.multiply(rightNum);
        STNumber actual2 = leftNum.multiply(rightNum2);
        assertEquals(expected1, actual1, "Addition Failed. Expected: " + expected1.STtoString() + ", Actual: " + actual1.STtoString());
        assertEquals(expected2, actual2, "Addition Failed. Expected: " + expected2.STtoString() + ", Actual: " + actual2.STtoString());
    }

    // method to help us test division for each subType of STNumber compatible with Float
    void checkDivision( STBinary leftNum, STInt rightNum, STBinary rightNum2,
                        STBinary expected1, STBinary expected2)
    {
        STNumber actual1 = leftNum.divide(rightNum);
        STNumber actual2 = leftNum.divide(rightNum2);
        assertEquals(expected1, actual1, "Addition Failed. Expected: " + expected1.STtoString() + ", Actual: " + actual1.STtoString());
        assertEquals(expected2, actual2, "Addition Failed. Expected: " + expected2.STtoString() + ", Actual: " + actual2.STtoString());
    }

    @Test
    protected void NumericalOperationTests() {
        STInt stInt = stFactory.createInt(9);
        STBinary stBinary = stFactory.createBinary("00000000000000000000000000100010"); // 34

        // Addition
        STBinary addSTIntResult =stFactory.createBinary("00000000000000000000000000000001"); // 1
        STBinary addSTBinaryResult = stFactory.createBinary("00000000000000000000000000011010"); // 26
        checkAddition(negativeSTBinary, stInt, stBinary, addSTIntResult, addSTBinaryResult);

        // Subtraction
        STBinary subtractSTIntResult  = stFactory.createBinary("00000000000000000000000000001100"); // 12
        STBinary subtractSTBinaryResult = stFactory.createBinary("11111111111111111111111111110011"); // -13
        checkSubtraction(positiveSTBinary, stInt, stBinary, subtractSTIntResult, subtractSTBinaryResult);

        // Multiplication
        STBinary multSTIntResult  = stFactory.createBinary("00000000000000000000000010111101"); // 189
        STBinary multSTBinaryResult = stFactory.createBinary("00000000000000000000001011001010"); // 714
        checkMultiplication(positiveSTBinary, stInt, stBinary, multSTIntResult, multSTBinaryResult);

        // Division
        STBinary divSTIntResult  = stFactory.createBinary("00000000000000000000000000000010"); // 2
        STBinary divSTBinaryResult = stFactory.createBinary("00000000000000000000000000000000"); // 0
        checkDivision(positiveSTBinary, stInt, stBinary, divSTIntResult, divSTBinaryResult);
    }
}