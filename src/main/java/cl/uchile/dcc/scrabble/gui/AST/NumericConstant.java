package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ISTNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumber;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public class NumericConstant implements AST_IConstant{
    STNumber myST;

    public NumericConstant(STNumber myST) {
        this.myST = myST;
    }

    @Override
    public STNumber toST() {
        return this.myST;
    }

    @Override
    public NumericConstant GetResult() {
        return this;
    }

    @Override
    public StringConstant add(AST_IConstant n) {
        return null;
    }

    @Override
    public NumericConstant add(NumericConstant n) {
        NumericConstant result = new NumericConstant(this.myST.add(n.toST()));
        return result;
    }

    @Override
    public NumericConstant add(BinaryConstant n) {
        return null;
    }

    @Override
    public NumericConstant subtract(NumericConstant n) {
        NumericConstant result = new NumericConstant(this.myST.subtract(n.toST()));
        return result;
    }

    @Override
    public NumericConstant subtract(BinaryConstant n) {
        return null;
    }

    @Override
    public NumericConstant multiply(NumericConstant n) {
        NumericConstant result = new NumericConstant(this.myST.multiply(n.toST()));
        return result;
    }

    @Override
    public NumericConstant multiply(BinaryConstant n) {
        return null;
    }

    @Override
    public NumericConstant divide(NumericConstant n) {
        NumericConstant result = new NumericConstant(this.myST.divide(n.toST()));
        return result;
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
