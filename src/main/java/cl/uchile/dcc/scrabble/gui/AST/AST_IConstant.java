package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public interface AST_IConstant extends AST_Operator{

    ScrabbleType toST();


    Constant conjunction(Constant y);

    Constant disjunction(Constant y);

    Constant add(Constant y);

    Constant subtract(Constant y);

    Constant multiply(Constant y);

    Constant divide(Constant y);
}
