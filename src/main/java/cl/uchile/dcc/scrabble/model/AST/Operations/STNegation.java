package cl.uchile.dcc.scrabble.model.AST.Operations;

import cl.uchile.dcc.scrabble.model.AST.AST_Operator;
import cl.uchile.dcc.scrabble.model.AST.Constant;

/**
 * Unary Operator Node for AST
 *
 * @author Diego Caviedes A.
 */

public class STNegation implements AST_Operator {
    private AST_Operator parentNode;
    private AST_Operator child;

    /** Constructor for operator STNegation */
    public STNegation(AST_Operator child) {
        this.child = child;
    }

    @Override
    public AST_Operator getParentNode() {
        return this.parentNode;
    }

    @Override
    public void SetParentNode(AST_Operator operator) {
        this.parentNode = operator;
    }

    @Override
    public void addChild(AST_Operator operator) {
        if(this.child == null)
        {
            this.child = operator;
        }
        return;
    }

    @Override
    public boolean emptyChild() {
        if(this.child != null ){return false;}
        return true;
    }

    @Override
    public Constant GetResult()
    {
        var X = child.GetResult();
        return X.negation();
    }

    @Override
    public String printNode() {
        String left = "";
        if(this.child != null)
        {
            left = this.child.printNode();
        }
        return "(" + left + ").negation";
    }

    @Override
    public String printNodeAsCode() {
        String left = " ";
        if(this.child != null)
        {
            left = this.child.printNodeAsCode();
        }
        return "Negate(" + left + ")";
    }
}
