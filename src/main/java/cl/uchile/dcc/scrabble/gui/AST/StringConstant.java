package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public class StringConstant implements AST_IConstant{
    STString myST;

    public StringConstant(STString x)
    {
        this.myST = x;
    }

    @Override
    public StringConstant GetResult() {
        return this;
    }

    @Override
    public STString toST() {
        return myST;
    }

    @Override
    public StringConstant add(AST_IConstant n) {
        StringConstant result = new StringConstant(myST.add(n.toST()));
        return result;
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
        return null;
    }

    @Override
    public LogicalConstant disjunction(LogicalConstant n) {
        return null;
    }
}
