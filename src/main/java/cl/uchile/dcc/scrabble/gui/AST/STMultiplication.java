package cl.uchile.dcc.scrabble.gui.AST;

public class STMultiplication implements AST_Operator {
    private NumericConstant x;
    private NumericConstant y;

    public STMultiplication(NumericConstant x, NumericConstant y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public NumericConstant GetResult()
    {
        var X = (NumericConstant)x.GetResult();
        var Y = (NumericConstant)y.GetResult();
        return X.multiply(Y);
    }

}
