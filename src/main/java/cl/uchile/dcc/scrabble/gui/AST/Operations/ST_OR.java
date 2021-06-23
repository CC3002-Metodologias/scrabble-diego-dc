package cl.uchile.dcc.scrabble.gui.AST.Operations;

import cl.uchile.dcc.scrabble.gui.AST.AST_Operator;
import cl.uchile.dcc.scrabble.gui.AST.Constant;

/**
 * Binary Operator Node for AST
 *
 * @author Diego Caviedes A.
 */

public class ST_OR implements AST_Operator {
    private AST_Operator x;
    private AST_Operator y;

    /** Constructor for operator ST_OR */
    public ST_OR(AST_Operator x, AST_Operator y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Constant GetResult()
    {
        var X = x.GetResult();
        var Y = y.GetResult();
        return X.disjunction(Y);
    }

    @Override
    public String printNode() {
        String left = this.x.printNode();
        String right = this.y.printNode();
        return left + " or " +  right;
    }

}
