package cl.uchile.dcc.scrabble.gui.AST.Transformations;

import cl.uchile.dcc.scrabble.gui.AST.AST_Operator;
import cl.uchile.dcc.scrabble.gui.AST.Constant;

/**
 * Transform Operator Node for AST.
 *
 * @author Diego Caviedes A.
 */

public class toSTInt implements AST_Operator{
    private AST_Operator child;

    /** Constructor for the operator toSTInt */
    public toSTInt(AST_Operator child) {
        this.child = child;
    }

    @Override
    public Constant GetResult()
    {
        var X = child.GetResult();
        return X.toSTInt();
    }

    @Override
    public String printNode() {
        String left = this.child.printNode();
        return left + ".toInt";
    }
}
