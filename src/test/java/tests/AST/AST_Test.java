package tests.AST;

import cl.uchile.dcc.scrabble.gui.AST.*;
import cl.uchile.dcc.scrabble.gui.AST.Operations.*;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AST_Test extends AbstractASTtest{
    AST_Operator numericAST;
    AST_Operator stringAST;
    AST_Operator logicalAST;
    AST_Operator transformsAST;

    @BeforeEach
    void setUp() {
        numericAST = new STAddition(
                        new Constant(new STInt(1)),
                        new Constant(new STInt(1))
                     ); // 1 + 1 -> 2

        stringAST = new STAddition(
                        new Constant(new STString("Test Numero: ")),
                        new STDivision(
                                new STMultiplication(
                                        new STSubtraction(
                                                new Constant(new STInt(4)),
                                                new Constant(new STInt(2))
                                        ),
                                        new Constant(new STFloat(1.5))
                                        ),
                                new Constant(new STInt(2))
                        )
                    );     // "Test Numero:" + ((4-2) * 1.5)/2 -> "Test Numero: 1.5"

        logicalAST = new ST_AND(
                        new STAddition(
                                new Constant(new STBinary("00000000000000000000000000000010")),
                                new Constant(new STInt(3))
                        ),
                        new ST_OR(
                                new Constant(new STBoolean(true)),
                                new Constant(new STBoolean(false))
                        )
                    );  // (00000000000000000000000000000010 + 3) and (true or false) -> 00000000000000000000000000000101 (5)

    }

    @Override
    @Test
    public void AST_test()
    {
        Constant expected1 = new Constant(new STInt(2));
        Constant expected2 = new Constant(new STString("Test Numero: 1.5"));
        Constant expected3 = new Constant(new STBinary("00000000000000000000000000000101"));

        checkAST(expected1, numericAST);
        checkAST(expected2, stringAST);
        checkAST(expected3, logicalAST);

    }

    @Override
    @Test
    public void AST_toString_test() {
        String expected1 = "1 + 1";
        String expected2 = "Test Numero:  + 4 - 2 * 1.5 / 2";
        String expected3 = "00000000000000000000000000000010 + 3 and true or false";

        checkASTasString(expected1, numericAST);
        checkASTasString(expected2, stringAST);
        checkASTasString(expected3, logicalAST);

    }
}