package cl.uchile.dcc.scrabble.model.AST.Operations;


import cl.uchile.dcc.scrabble.model.AST.AST_Operator;
import cl.uchile.dcc.scrabble.model.AST.Constant;

/**
 * Binary Operator Node for AST
 *
 * @author Diego Caviedes A.
 */

public class STDivision implements AST_Operator {
    private AST_Operator x;
    private AST_Operator y;

    /** Constructor for operator STDivision */
    public STDivision(AST_Operator x, AST_Operator y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Constant GetResult()
    {
        var X = x.GetResult();
        var Y = y.GetResult();
        return X.divide(Y);
    }

    @Override
    public String printNode() {
        String left = this.x.printNode();
        String right = this.y.printNode();
        return left + " / " +  right;
    }


}
