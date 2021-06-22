package cl.uchile.dcc.scrabble.gui.AST.Operations;

import cl.uchile.dcc.scrabble.gui.AST.AST_Operator;
import cl.uchile.dcc.scrabble.gui.AST.Constant;

public class STNegation implements AST_Operator {
    private AST_Operator child;

    public STNegation(AST_Operator child) {
        this.child = child;
    }

    @Override
    public Constant GetResult()
    {
        var X = child.GetResult();
        return X.negation();
    }

    @Override
    public String printNode() {
        String left = this.child.printNode();
        return left + ".negation";
    }
}
