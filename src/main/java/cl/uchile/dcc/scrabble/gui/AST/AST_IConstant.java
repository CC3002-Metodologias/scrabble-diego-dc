package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public interface AST_IConstant extends AST_Operator{

    ScrabbleType toST();

    StringConstant add(AST_IConstant n);
    NumericConstant add(NumericConstant n);
    NumericConstant add(BinaryConstant n);

    NumericConstant subtract(NumericConstant n);
    NumericConstant subtract(BinaryConstant n);


    NumericConstant multiply(NumericConstant n);
    NumericConstant multiply(BinaryConstant n);

    NumericConstant divide(NumericConstant n);
    NumericConstant divide(BinaryConstant n);

    LogicalConstant conjunction(LogicalConstant n);
    LogicalConstant disjunction(LogicalConstant n);

}
