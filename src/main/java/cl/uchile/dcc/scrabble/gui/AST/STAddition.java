package cl.uchile.dcc.scrabble.gui.AST;

public class STAddition implements AST_Operator {
    private AST_Operator x;
    private AST_Operator y;

    public STAddition(AST_Operator x , AST_Operator y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public StringConstant GetResult()
    {
        var X = x.GetResult();
        var Y = y.GetResult();
        return X.add(Y);
    }




}
