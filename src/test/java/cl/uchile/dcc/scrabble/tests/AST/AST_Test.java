package cl.uchile.dcc.scrabble.tests.AST;

import cl.uchile.dcc.scrabble.controller.ScrabbleController;
import cl.uchile.dcc.scrabble.model.AST.*;
import cl.uchile.dcc.scrabble.model.AST.Operations.*;
import cl.uchile.dcc.scrabble.model.AST.Transformations.*;
import cl.uchile.dcc.scrabble.model.Flyweight.STFactory.STFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        String expected2 = "Test Numero:  + 4 - (2).toFloat * 1.5 / 2";
        String expected3 = "00000000000000000000000000000010 + (3).toBinary and true or false";
        String expected4 = "(2 + ((false).toBoolean or (00000000000000000000000000000101).negation).toInt).toString";

        checkASTasString(expected1, AST1);
        checkASTasString(expected2, AST2);
        checkASTasString(expected3, AST3);
        checkASTasString(expected4, AST4);

    }

    @Test
    public void ControllerTests()
    {
        ScrabbleController controller = new ScrabbleController();
        ScrabbleController controller2 = new ScrabbleController();
        ScrabbleController controller3 = new ScrabbleController();

        // we construct a copy of AST2
        controller.createCalc("+");
        controller.addString("Test Numero: ");
        controller.addOperator("/");
        controller.addOperator("*");
        controller.addOperator("-");
        controller.addInt(4);
        controller.addOperator("toFloat");
        controller.addInt(2);
        controller.addFloat(1.5);
        controller.addInt(2);

        // we construct a copy of AST3

        controller2.createCalc("AND");
        controller2.addOperator("+");
        controller2.addBinary("00000000000000000000000000000010");
        controller2.addOperator("toBinary");
        controller2.addInt(3);
        controller2.addOperator("OR");
        controller2.addBoolean(true);
        controller2.addBoolean(false);

        // we construct a copy of AST4

        controller3.createCalc("toString");
        controller3.addOperator("+");
        controller3.addInt(3);
        controller3.addOperator("toInt");
        controller3.addOperator("OR");
        controller3.addOperator("toBoolean");
        controller3.addBoolean(false);
        controller3.addOperator("~");
        controller3.addBinary("00000000000000000000000000000101");

        // we create the expected outputs and results

        String expectedOutput1 = "Add(Test Numero: , Divide(Multiply(Subtract(4, toFloat(2)), 1.5), 2))";
        String expectedOutput2 = "AND(Add(00000000000000000000000000000010, toBinary(3)), OR(true, false))";
        String expectedOutput3 = "toString(Add(3, toInt(OR(toBoolean(false), Negate(00000000000000000000000000000101)))))";

        String expectedResult1 = "Test Numero: 1.5";
        String expectedResult2 = "00000000000000000000000000000101";
        String expectedResult3 = "-4";

        assertEquals(true, controller.checkCompletedTree());
        checkASTasCodeString(expectedOutput1, controller.printEquation(false));
        checkASTasCodeString(expectedOutput2, controller2.printEquation(false));
        checkASTasCodeString(expectedOutput3, controller3.printEquation(false));
    }

    @Test
    public void CheckControllerCreateCalculations()
    {
        ScrabbleController controller = new ScrabbleController();
        ScrabbleController controller1 = new ScrabbleController();
        ScrabbleController controller2 = new ScrabbleController();
        ScrabbleController controller3 = new ScrabbleController();
        ScrabbleController controller4 = new ScrabbleController();
        ScrabbleController controller5 = new ScrabbleController();
        ScrabbleController controller6 = new ScrabbleController();
        ScrabbleController controller7 = new ScrabbleController();
        ScrabbleController controller8 = new ScrabbleController();

        controller.createCalc("-");
        controller1.createCalc("*");
        controller2.createCalc("~");
        controller3.createCalc("OR");
        controller4.createCalc("/");
        controller5.createCalc("toBinary");
        controller6.createCalc("toBoolean");
        controller7.createCalc("toFloat");
        controller8.createCalc("toInt");


        String expectedOutput = "Subtract( ,  )";
        String expectedOutput1 = "Multiply( ,  )";
        String expectedOutput2 = "Negate( )";
        String expectedOutput3 = "OR( ,  )";
        String expectedOutput4 = "Divide( ,  )";
        String expectedOutput5 = "toBinary( )";
        String expectedOutput6 = "toBoolean( )";
        String expectedOutput7 = "toFloat( )";
        String expectedOutput8 = "toInt( )";

        assertEquals(expectedOutput, controller.printEquation(false));
        assertEquals(expectedOutput1, controller1.printEquation(false));
        assertEquals(expectedOutput2, controller2.printEquation(false));
        assertEquals(expectedOutput3, controller3.printEquation(false));
        assertEquals(expectedOutput4, controller4.printEquation(false));
        assertEquals(expectedOutput5, controller5.printEquation(false));
        assertEquals(expectedOutput6, controller6.printEquation(false));
        assertEquals(expectedOutput7, controller7.printEquation(false));
        assertEquals(expectedOutput8, controller8.printEquation(false));

    }
}