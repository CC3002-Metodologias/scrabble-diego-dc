package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.model.AST.AST_Operator;
import cl.uchile.dcc.scrabble.model.AST.Constant;

/**
 * Class to create an equation as an AST tree
 *
 *
 * @Author: Diego Caviedes A.
 */

public class ASTBuilder {
    private AST_Operator rootNode;
    private AST_Operator currentNode;

    /**
     * Sets a given Node as the rootNode representing the
     * beginning of a tree
     * @param node
     *      AST_Operator expected to be the rootNode
     */
    public void createTree(AST_Operator node)
    {
        this.currentNode = node;
        this.rootNode = node;
        node.SetParentNode(null);
    }

    /**
     * Gives the result of the
     * equation represented by the tree
     *
     * @return
     *      Constant with an ScrabbleType containing the result
     */
    public Constant getResult()
    {
        return this.rootNode.GetResult();
    }

    /** Prints the tree as a conventional equation */
    public String printTree(){ return this.rootNode.printNode();}

    /** Prints the tree as Pseudo-Code */
    public String printTreeAsCode(){ return this.rootNode.printNodeAsCode();}

    /** Adds a new Operator as a child of the currentNode */
    public void add(AST_Operator new_node)
    {
        if(this.currentNode.emptyChild())
        {
            new_node.SetParentNode(this.currentNode);
            this.currentNode.addChild(new_node);
            this.currentNode = new_node;
        }
        else
        {
            if(this.currentNode.getParentNode() == null)
            {
                return;
            }
            this.currentNode = this.currentNode.getParentNode();
            add(new_node);
        }
    }

    /** Adds a new Constant as a child of the currentNode */
    public void addConstant(AST_Operator constant)
    {
        if(this.currentNode.emptyChild())
        {
            this.currentNode.addChild(constant);
        }
        else
        {
            if(this.currentNode.getParentNode() == null)
            {
                return;
            }
            this.currentNode = this.currentNode.getParentNode();
            addConstant(constant);
        }
    }

    /** Checks if this tree has a Null Node */
    public boolean checkCompletedTree()
    {
        if(this.rootNode.emptyChild() || this.currentNode.emptyChild())
        {
            return false;
        }
        return true;
    }

}
