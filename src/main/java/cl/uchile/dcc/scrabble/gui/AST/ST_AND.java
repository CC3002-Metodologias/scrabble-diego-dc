package cl.uchile.dcc.scrabble.gui.AST;

public class ST_AND implements AST_Operator {
    private AST_Operator x;
    private AST_Operator y;

    public ST_AND(AST_Operator x, AST_Operator y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Constant GetResult()
    {
        var X = x.GetResult();
        var Y = y.GetResult();
        return X.conjunction(Y);
    }

}
