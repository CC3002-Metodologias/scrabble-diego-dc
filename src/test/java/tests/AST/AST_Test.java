package tests.AST;

import cl.uchile.dcc.scrabble.gui.AST.*;
import cl.uchile.dcc.scrabble.gui.AST.Operations.*;
import cl.uchile.dcc.scrabble.gui.AST.Transformations.*;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AST_Test extends AbstractASTtest{
    AST_Operator AST1;
    AST_Operator AST2;
    AST_Operator AST3;
    AST_Operator AST4;

    @BeforeEach
    void setUp() {
        AST1 = new STAddition(
                        new Constant(new STInt(1)),
                        new Constant(new STInt(1))
                     ); // 1 + 1 -> 2

        AST2 = new STAddition(
                        new Constant(new STString("Test Numero: ")),
                        new STDivision(
                                new STMultiplication(
                                        new STSubtraction(
                                                new Constant(new STInt(4)),
                                                new toSTFloat(
                                                    new Constant(new STInt(2))
                                                )
                                        ),
                                        new Constant(new STFloat(1.5))
                                        ),
                                new Constant(new STInt(2))
                        )
                    );     // "Test Numero:" + ((4-2.toFloat) * 1.5)/2 -> "Test Numero: 1.5"

        AST3 = new ST_AND(
                        new STAddition(
                                new Constant(new STBinary("00000000000000000000000000000010")),
                                new toSTBinary(
                                        new Constant(new STInt(3))
                                )
                        ),
                        new ST_OR(
                                new Constant(new STBoolean(true)),
                                new Constant(new STBoolean(false))
                        )
                    );  // (00000000000000000000000000000010 + 3.toBinary) and (true or false) -> 00000000000000000000000000000101 (5)

        AST4 = new toSTString(
                    new STAddition(
                            new Constant(new STInt(2)),
                            new toSTInt(
                                    new ST_OR(
                                            new toSTBoolean(
                                                    new Constant(new STBoolean(false))
                                            ),
                                            new STNegation(
                                                    new Constant(new STBinary("00000000000000000000000000000101"))
                                            )
                                    )
                            )
                    )
                );  // (2 + (false.toBoolean or 00000000000000000000000000000101.negation).toInt).toString -> "-4"

    }

    @Override
    @Test
    public void AST_test()
    {
        Constant expected1 = new Constant(new STInt(2));
        Constant expected2 = new Constant(new STString("Test Numero: 1.5"));
        Constant expected3 = new Constant(new STBinary("00000000000000000000000000000101"));
        Constant expected4 = new Constant(new STString("-4"));

        checkAST(expected1, AST1);
        checkAST(expected2, AST2);
        checkAST(expected3, AST3);
        checkAST(expected4, AST4);

    }

    @Override
    @Test
    public void AST_toString_test() {
        String expected1 = "1 + 1";
        String expected2 = "Test Numero:  + 4 - 2.toFloat * 1.5 / 2";
        String expected3 = "00000000000000000000000000000010 + 3.toBinary and true or false";
        String expected4 = "2 + false.toBoolean or 00000000000000000000000000000101.negation.toInt.toString";

        checkASTasString(expected1, AST1);
        checkASTasString(expected2, AST2);
        checkASTasString(expected3, AST3);
        checkASTasString(expected4, AST4);

    }
}