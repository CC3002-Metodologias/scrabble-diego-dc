package cl.uchile.dcc.scrabble.tests.AST;

import cl.uchile.dcc.scrabble.gui.AST.AST_Operator;
import cl.uchile.dcc.scrabble.gui.AST.Constant;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

import static org.junit.jupiter.api.Assertions.assertEquals;


/** A test to check if our AST is giving the expected result */
public abstract class AbstractASTtest {
    protected void checkAST(Constant expectedResult, AST_Operator actual){
        assertEquals(expectedResult, actual.GetResult(), "Expected result: " + expectedResult.toST().STtoString() +", Actual result: " + actual.GetResult().toST().STtoString());
    }

    protected void checkASTasString(String expected, AST_Operator ASTtoTransform)
    {
        String actual = ASTtoTransform.printNode();
        assertEquals(expected, actual, "Expected result: " + expected + ", Actual result: " + actual);
    }

    public abstract void AST_test();

    public abstract void AST_toString_test();
}
