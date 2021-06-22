package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.INumberBinaryCompatible;

public class BinaryConstant implements AST_IConstant{
    INumberBinaryCompatible myST;

    public BinaryConstant(INumberBinaryCompatible myST) {
        this.myST = myST;
    }

    @Override
    public INumberBinaryCompatible toST() {
        return this.myST;
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
        NumericConstant result = new NumericConstant(this.myST.add(n.toST()));
        return result;
    }

    @Override
    public NumericConstant subtract(NumericConstant n) {
        return null;
    }

    @Override
    public NumericConstant subtract(BinaryConstant n) {
        NumericConstant result = new NumericConstant(this.myST.add(n.toST()));
        return result;
    }

    @Override
    public NumericConstant multiply(NumericConstant n) {
        return null;
    }

    @Override
    public NumericConstant multiply(BinaryConstant n) {
        NumericConstant result = new NumericConstant(this.myST.add(n.toST()));
        return result;
    }

    @Override
    public NumericConstant divide(NumericConstant n) {
        return null;
    }

    @Override
    public NumericConstant divide(BinaryConstant n) {
        NumericConstant result = new NumericConstant(this.myST.add(n.toST()));
        return result;
    }

    @Override
    public LogicalConstant conjunction(LogicalConstant n) {
        return null;
    }

    @Override
    public LogicalConstant disjunction(LogicalConstant n) {
        return null;
    }

    @Override
    public BinaryConstant GetResult() {
        return this;
    }
}
