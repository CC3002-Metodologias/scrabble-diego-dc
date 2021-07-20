package cl.uchile.dcc.scrabble.model.AST.Transformations;

import cl.uchile.dcc.scrabble.model.AST.AST_Operator;
import cl.uchile.dcc.scrabble.model.AST.Constant;

/**
 * Transform Operator Node for AST.
 *
 * @author Diego Caviedes A.
 */

public class toSTBoolean implements AST_Operator{
    private AST_Operator child;

    /** Constructor for the operator toSTBoolean */
    public toSTBoolean(AST_Operator child) {
        this.child = child;
    }

    @Override
    public Constant GetResult()
    {
        var X = child.GetResult();
        return X.toSTBoolean();
    }

    @Override
    public String printNode() {
        String left = this.child.printNode();
        return left + ".toBoolean";
    }
}
