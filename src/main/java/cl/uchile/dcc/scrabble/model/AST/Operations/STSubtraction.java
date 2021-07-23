package cl.uchile.dcc.scrabble.model.AST.Operations;

import cl.uchile.dcc.scrabble.model.AST.AST_Operator;
import cl.uchile.dcc.scrabble.model.AST.Constant;

/**
 * Binary Operator Node for AST
 *
 * @author Diego Caviedes A.
 */

public class STSubtraction implements AST_Operator {
    private AST_Operator parentNode;
    private AST_Operator x;
    private AST_Operator y;

    /** Constructor for operator STSubtraction */
    public STSubtraction(AST_Operator x, AST_Operator y) {
        this.x = x;
        this.y = y;
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
        if(this.x == null)
        {
            this.x = operator;
            return;
        }
        if(this.y == null)
        {
            this.y = operator;
        }
        return;
    }

    @Override
    public boolean emptyChild() {
        if(this.x != null && this.y != null){return false;}
        return true;
    }

    @Override
    public Constant GetResult()
    {
        var X = x.GetResult();
        var Y = y.GetResult();
        return X.subtract(Y);
    }

    @Override
    public String printNode() {
        String left = "";
        String right = "";
        if(this.x != null){  left = this.x.printNode();}
        if(this.y != null){  right = this.y.printNode();}
        return left + " - " +  right;
    }


}
