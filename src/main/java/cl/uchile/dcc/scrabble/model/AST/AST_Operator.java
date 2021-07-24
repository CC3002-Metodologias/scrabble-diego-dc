package cl.uchile.dcc.scrabble.model.AST;

/**
 * AST_Operator is the base for an AST.
 * Is the Interface all Nodes will share
 *
 * @author Diego Caviedes A.
 */

public interface AST_Operator {

    /**
     * Each Node will have a parent Node
     * @return
     *      the parent Node of the current Node in the Tree
     *      for the root Node will be null
     */
    AST_Operator getParentNode();

    /**
     * Setter of the Parent Node of the current Node
     * @param operator
     *      An AST_Operator expected to be the parent Node
     *      of the current Node
     */
    void SetParentNode(AST_Operator operator);

    /**
     * Will add a Node as child of the current Node
     *
     * @param operator
     *      An AST_Operator expected to be the child
     *      of the current Node
     */
    void addChild(AST_Operator operator);


    /**
     * Will tell if the current Node has a null as a child
     * @return
     *      true -> if any of its child is Null
     *      false -> if all of its child are not Null
     */
    boolean emptyChild();

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


    /** Each node could be represented as a String in Code Form.
     *
     * @return
     *      String, the first Node will return the whole
     *      structure of the AST as a String representing the code.
     */
    String printNodeAsCode();
}
