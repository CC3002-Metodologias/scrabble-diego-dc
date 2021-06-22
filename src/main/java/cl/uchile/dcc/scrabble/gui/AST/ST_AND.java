package cl.uchile.dcc.scrabble.gui.AST;

public class ST_AND implements AST_Operator {
    private AST_Operator x;
    private AST_Operator y;

    public ST_AND(LogicalConstant x, LogicalConstant y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public LogicalConstant GetResult()
    {
        var X = (LogicalConstant)x.GetResult();
        var Y = (LogicalConstant)y.GetResult();
        return X.conjunction(Y);
    }

}
