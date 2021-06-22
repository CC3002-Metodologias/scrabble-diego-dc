package cl.uchile.dcc.scrabble.gui.AST;

public class STSubtraction implements AST_Operator {

    private NumericConstant x;
    private NumericConstant y;

    public STSubtraction(NumericConstant x, NumericConstant y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public NumericConstant GetResult()
    {
        var X = (NumericConstant)x.GetResult();
        var Y = (NumericConstant)y.GetResult();
        return X.subtract(Y);
    }


}
