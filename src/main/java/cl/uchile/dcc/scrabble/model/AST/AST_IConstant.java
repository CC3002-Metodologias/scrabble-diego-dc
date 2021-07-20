package cl.uchile.dcc.scrabble.model.AST;

import cl.uchile.dcc.scrabble.model.ScrabbleTypes.ScrabbleType;

/**
 * All constants must do the same
 * functionalities as a ScrabbleType
 *
 * @author Diego Caviedes A.
 */

public interface AST_IConstant extends AST_Operator{

    /** Constants can pass the ScrabbleType they are representing */
    ScrabbleType toST();

    /** Constants must operate all possible operations ScrabbleTypes can */
    Constant conjunction(Constant y);
    Constant disjunction(Constant y);
    Constant add(Constant y);
    Constant subtract(Constant y);
    Constant multiply(Constant y);
    Constant divide(Constant y);
    Constant negation();

    /** Constants can transform their ScrabbleType to other ScrabbleTypes */
    Constant toSTString();
    Constant toSTBoolean();
    Constant toSTFloat();
    Constant toSTInt();
    Constant toSTBinary();
}
