package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ISTLogicalOperationCompatible;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;

public class LogicalConstant implements AST_IConstant {
    ISTLogicalOperationCompatible myST;

    public LogicalConstant(ISTLogicalOperationCompatible x)
    {
        this.myST = x;
    }

    @Override
    public LogicalConstant GetResult() {
        return this;
    }

    @Override
    public ISTLogicalOperationCompatible toST() {
        return myST;
    }

    @Override
    public StringConstant add(AST_IConstant n) {
        return null;
    }

    @Override
    public NumericConstant add(NumericConstant n) {
        return null;
    }

    @Override
    public NumericConstant add(BinaryConstant n) {
        return null;
    }

    @Override
    public NumericConstant subtract(NumericConstant n) {
        return null;
    }

    @Override
    public NumericConstant subtract(BinaryConstant n) {
        return null;
    }

    @Override
    public NumericConstant multiply(NumericConstant n) {
        return null;
    }

    @Override
    public NumericConstant multiply(BinaryConstant n) {
        return null;
    }

    @Override
    public NumericConstant divide(NumericConstant n) {
        return null;
    }

    @Override
    public NumericConstant divide(BinaryConstant n) {
        return null;
    }

    @Override
    public LogicalConstant conjunction(LogicalConstant n) {
        LogicalConstant result = new LogicalConstant(this.myST.conjunction(n.toST()));
        return result;
    }

    @Override
    public LogicalConstant disjunction(LogicalConstant n) {
        LogicalConstant result = new LogicalConstant(this.myST.disjunction(n.toST()));
        return result;
    }
}
