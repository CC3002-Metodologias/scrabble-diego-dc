package cl.uchile.dcc.scrabble.gui.AST.Transformations;

import cl.uchile.dcc.scrabble.gui.AST.AST_Operator;
import cl.uchile.dcc.scrabble.gui.AST.Constant;

public class toSTString implements AST_Operator{
    private AST_Operator child;

    public toSTString(AST_Operator child) {
        this.child = child;
    }

    @Override
    public Constant GetResult()
    {
        var X = child.GetResult();
        return X.toSTString();
    }

    @Override
    public String printNode() {
        String left = this.child.printNode();
        return left + ".toString";
    }
}
