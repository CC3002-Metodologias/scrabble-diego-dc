package cl.uchile.dcc.scrabble.tests.AST;

import cl.uchile.dcc.scrabble.model.AST.*;
import cl.uchile.dcc.scrabble.model.AST.Operations.*;
import cl.uchile.dcc.scrabble.model.AST.Transformations.*;
import cl.uchile.dcc.scrabble.model.Flyweight.STFactory.STFactory;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STBoolean;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STFloat;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STInt;
import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AST_Test extends AbstractASTtest{
    STFactory stFactory = new STFactory();

    AST_Operator AST1;
    AST_Operator AST2;
    AST_Operator AST3;
    AST_Operator AST4;

    @BeforeEach
    void setUp() {
        AST1 = new STAddition(
                        new Constant(stFactory.createInt(1)),
                        new Constant(stFactory.createInt(1))
                     ); // 1 + 1 -> 2

        AST2 = new STAddition(
                        new Constant(stFactory.createString("Test Numero: ")),
                        new STDivision(
                                new STMultiplication(
                                        new STSubtraction(
                                                new Constant(stFactory.createInt(4)),
                                                new toSTFloat(
                                                    new Constant(stFactory.createInt(2))
                                                )
                                        ),
                                        new Constant(stFactory.createFloat(1.5))
                                        ),
                                new Constant(stFactory.createInt(2))
                        )
                    );     // "Test Numero:" + ((4-2.toFloat) * 1.5)/2 -> "Test Numero: 1.5"

        AST3 = new ST_AND(
                        new STAddition(
                                new Constant(stFactory.createBinary("00000000000000000000000000000010")),
                                new toSTBinary(
                                        new Constant(stFactory.createInt(3))
                                )
                        ),
                        new ST_OR(
                                new Constant(stFactory.createBoolean(true)),
                                new Constant(stFactory.createBoolean(false))
                        )
                    );  // (00000000000000000000000000000010 + 3.toBinary) and (true or false) -> 00000000000000000000000000000101 (5)

        AST4 = new toSTString(
                    new STAddition(
                            new Constant(stFactory.createInt(2)),
                            new toSTInt(
                                    new ST_OR(
                                            new toSTBoolean(
                                                    new Constant(stFactory.createBoolean(false))
                                            ),
                                            new STNegation(
                                                    new Constant(stFactory.createBinary("00000000000000000000000000000101"))
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
        Constant expected1 = new Constant(stFactory.createInt(2));
        Constant expected2 = new Constant(stFactory.createString("Test Numero: 1.5"));
        Constant expected3 = new Constant(stFactory.createBinary("00000000000000000000000000000101"));
        Constant expected4 = new Constant(stFactory.createString("-4"));

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