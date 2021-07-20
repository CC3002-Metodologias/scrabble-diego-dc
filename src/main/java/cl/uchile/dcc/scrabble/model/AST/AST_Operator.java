package cl.uchile.dcc.scrabble.model.AST;

/**
 * AST_Operator is the base for an AST.
 * Is the Interface all Nodes will share
 *
 * @author Diego Caviedes A.
 */

public interface AST_Operator {

    /** Each node of the AST must return a result
     *
     * @return
     *      Constant, leaf of our tree -> contains an ScrabbleType
     */
    Constant GetResult();

    /** Each node could be represented as a String.
     *
     * @return
     *      String, the first Node will return the whole
     *      structure of the AST as a String.
     */
    String printNode();

}
