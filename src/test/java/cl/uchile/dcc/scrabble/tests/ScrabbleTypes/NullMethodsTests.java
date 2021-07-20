package cl.uchile.dcc.scrabble.tests.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.AST.Operations.STSubtraction;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.*;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NullMethodsTests {
    STString string_st = new STString("Hola");
    STBoolean bool_st = new STBoolean(true);
    STInt int_st = new STInt(1);
    STFloat float_st = new STFloat(1.5);
    STBinary binary_st = new STBinary("00000000000000000000000000000001");

    void checkNullMethod(ScrabbleType actual)
    {
        assertEquals(null, actual, "Result not Null, instead: " + actual);
    }

    @Test
    void NullOperationsTests()
    {
        //STString null methods

        checkNullMethod(string_st.subtract(float_st));
        checkNullMethod(string_st.multiply(float_st));
        checkNullMethod(string_st.divide(float_st));
        checkNullMethod(string_st.conjunction(float_st));
        checkNullMethod(string_st.disjunction(float_st));
        checkNullMethod(string_st.negation());
        checkNullMethod(string_st.addToInteger(int_st));
        checkNullMethod(string_st.addToFloat( float_st));
        checkNullMethod(string_st.subtractToInteger(int_st));
        checkNullMethod(string_st.subtractToFloat(float_st));
        checkNullMethod(string_st.multiplyToInteger(int_st));
        checkNullMethod(string_st.multiplyToFloat( float_st));
        checkNullMethod(string_st.divideToInteger( int_st));
        checkNullMethod(string_st.divideToFloat( float_st));
        checkNullMethod(string_st.addToBinary( binary_st));
        checkNullMethod(string_st.subtractToBinary( binary_st));
        checkNullMethod(string_st.multiplyToBinary( binary_st));
        checkNullMethod(string_st.divideToBinary( binary_st) );
        checkNullMethod(string_st.conjunctionToBinary( binary_st) );
        checkNullMethod(string_st.conjunctionToBoolean( bool_st) );
        checkNullMethod(string_st.disjunctionToBinary( binary_st) );
        checkNullMethod(string_st.disjunctionToBoolean( bool_st) );

        //STBoolean null methods

        checkNullMethod(bool_st.addToInteger(int_st ) );
        checkNullMethod(bool_st.addToFloat(float_st ) );
        checkNullMethod(bool_st.subtractToInteger(int_st ) );
        checkNullMethod(bool_st.subtractToFloat(float_st ));
        checkNullMethod(bool_st.multiplyToInteger(int_st ));
        checkNullMethod(bool_st.multiplyToFloat(float_st ));
        checkNullMethod(bool_st.divideToInteger(int_st ) );
        checkNullMethod(bool_st.divideToFloat(float_st ) );
        checkNullMethod(bool_st.addToBinary(binary_st ) );
        checkNullMethod(bool_st.subtractToBinary(binary_st ) );
        checkNullMethod(bool_st.multiplyToBinary(binary_st ));
        checkNullMethod(bool_st.divideToBinary(binary_st ));
        checkNullMethod(bool_st.add(int_st ) );
        checkNullMethod(bool_st.subtract(int_st ) );
        checkNullMethod(bool_st.multiply(int_st ) );
        checkNullMethod(bool_st.divide(int_st ) );

        //STFloat null methods

        checkNullMethod(float_st.addToBinary(binary_st ) );
        checkNullMethod(float_st.subtractToBinary(binary_st ) );
        checkNullMethod(float_st.multiplyToBinary(binary_st ) );
        checkNullMethod(float_st.divideToBinary(binary_st ) );
        checkNullMethod(float_st.conjunctionToBinary(binary_st ) );
        checkNullMethod(float_st.conjunctionToBoolean(bool_st ) );
        checkNullMethod(float_st.disjunctionToBinary(binary_st ) );
        checkNullMethod(float_st.disjunctionToBoolean(bool_st ));
        checkNullMethod(float_st.conjunction(bool_st ) );
        checkNullMethod(float_st.disjunction(bool_st ) );
        checkNullMethod(float_st.negation());

        //STInt null methods

        checkNullMethod(int_st.conjunctionToBinary(binary_st ) );
        checkNullMethod(int_st.conjunctionToBoolean(bool_st ) );
        checkNullMethod(int_st.disjunctionToBinary(binary_st ) );
        checkNullMethod(int_st.disjunctionToBoolean(bool_st ) );
        checkNullMethod(int_st.conjunction(binary_st ) );
        checkNullMethod(int_st.disjunction(binary_st ) );
        checkNullMethod(int_st.negation());

        //STBinary null methods



    }

    @Test
    void NullTransformationsTests()
    {
        //STString null methods

        checkNullMethod(string_st.toSTBoolean() );
        checkNullMethod(string_st.toSTFloat() );
        checkNullMethod(string_st.toSTInt() );
        checkNullMethod(string_st.toSTBinary() );

        //STBoolean null methods

        checkNullMethod(bool_st.toSTFloat() );
        checkNullMethod(bool_st.toSTInt() );
        checkNullMethod(bool_st.toSTBinary() );

        //STFloat null methods

        checkNullMethod(float_st.toSTInt() );
        checkNullMethod(float_st.toSTBinary() );

        //STInt null methods

        checkNullMethod(int_st.toSTBoolean() );

        //STBinary null methods

        checkNullMethod(binary_st.toSTBoolean() );

    }

}
