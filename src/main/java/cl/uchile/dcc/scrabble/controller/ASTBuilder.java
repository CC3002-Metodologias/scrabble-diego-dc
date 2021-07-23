package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.model.AST.AST_Operator;
import cl.uchile.dcc.scrabble.model.AST.Constant;

public class ASTBuilder {
    private AST_Operator rootNode;
    private AST_Operator currentNode;

    public void createTree(AST_Operator node)
    {
        this.currentNode = node;
        this.rootNode = node;
        node.SetParentNode(null);
    }

    public Constant getResult()
    {
        return this.rootNode.GetResult();
    }

    public String printTree(){ return this.rootNode.printNode();}

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


}
