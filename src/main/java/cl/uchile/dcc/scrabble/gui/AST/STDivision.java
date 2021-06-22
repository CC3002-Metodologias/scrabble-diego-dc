package cl.uchile.dcc.scrabble.gui.AST;


public class STDivision implements AST_Operator {
    private AST_Operator x;
    private AST_Operator y;

    public STDivision(NumericConstant x, NumericConstant y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public NumericConstant GetResult()
    {
        var X = (NumericConstant)x.GetResult();
        var Y = (NumericConstant)y.GetResult();
        return X.divide(Y);
    }


}
