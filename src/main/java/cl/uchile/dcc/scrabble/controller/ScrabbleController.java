package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.model.AST.AST_Operator;
import cl.uchile.dcc.scrabble.model.AST.Constant;
import cl.uchile.dcc.scrabble.model.AST.Operations.*;
import cl.uchile.dcc.scrabble.model.AST.Transformations.*;
import cl.uchile.dcc.scrabble.model.Flyweight.STFactory.STFactory;

/**
 * Controller of our Program
 * Dictates the functionalities of the App
 *
 *
 * @Author: Diego Caviedes A.
 */

public class ScrabbleController {
    private ASTBuilder builder;
    STFactory stFactory = new STFactory();

    /**
     * Creates an AST_Builder from a given
     * String representing an Operation or Transformation
     */
    public void createCalc(String str)
    {
        if(str == "+")
        {
            builder = new ASTBuilder();
            builder.createTree(new STAddition(null,null));
        }
        if(str == "-")
        {
            builder = new ASTBuilder();
            builder.createTree(new STSubtraction(null,null));
        }
        if(str == "*")
        {
            builder = new ASTBuilder();
            builder.createTree(new STMultiplication(null,null));
        }
        if(str == "~")
        {
            builder = new ASTBuilder();
            builder.createTree(new STNegation(null));
        }
        if(str == "AND")
        {
            builder = new ASTBuilder();
            builder.createTree(new ST_AND(null,null));
        }
        if(str == "OR")
        {
            builder = new ASTBuilder();
            builder.createTree(new ST_OR(null,null));
        }
        if(str == "/")
        {
            builder = new ASTBuilder();
            builder.createTree(new STDivision(null,null));
        }
        if(str == "toBinary")
        {
            builder = new ASTBuilder();
            builder.createTree(new toSTBinary(null));
        }
        if(str == "toBoolean")
        {
            builder = new ASTBuilder();
            builder.createTree(new toSTBoolean(null));
        }
        if(str == "toFloat")
        {
            builder = new ASTBuilder();
            builder.createTree(new toSTFloat(null));
        }
        if(str == "toInt")
        {
            builder = new ASTBuilder();
            builder.createTree(new toSTInt(null));
        }
        if(str == "toString")
        {
            builder = new ASTBuilder();
            builder.createTree(new toSTString(null));
        }
    }

    /**
     * Gives an Operator to the AST_Builder
     * by a String representing the specific Operator
     *
     * @param str
     *      id of an Operator as String
     */
    public void addOperator(String str)
    {
        if(str == "+")
        {
            builder.add(new STAddition(null,null));
        }
        if(str == "-")
        {
            builder.add(new STSubtraction(null,null));
        }
        if(str == "*")
        {
            builder.add(new STMultiplication(null,null));
        }
        if(str == "/")
        {
            builder.add(new STDivision(null,null));
        }
        if(str == "~")
        {
            builder.add(new STNegation(null));
        }
        if(str == "AND")
        {
            builder.add(new ST_AND(null,null));
        }
        if(str == "OR")
        {
            builder.add(new ST_OR(null,null));
        }
        if(str == "toBinary")
        {
            builder.add(new toSTBinary(null));
        }
        if(str == "toBoolean")
        {
            builder.add(new toSTBoolean(null));
        }
        if(str == "toFloat")
        {
            builder.add(new toSTFloat(null));
        }
        if(str == "toInt")
        {
            builder.add(new toSTInt(null));
        }
        if(str == "toString")
        {
            builder.add(new toSTString(null));
        }
    }

    /** add a STString to the tree */
    public void addString(String str)
    {
        builder.addConstant(new Constant(stFactory.createString(str)));
    }

    /** add a STBoolean to the tree */
    public void addBoolean(boolean bool)
    {
        builder.addConstant(new Constant(stFactory.createBoolean(bool)));
    }

    /** add a STFloat to the tree */
    public void addFloat(Double dbl)
    {
        builder.addConstant(new Constant(stFactory.createFloat(dbl)));
    }

    /** add a STInt to the tree */
    public void addInt(int intgr)
    {
        builder.addConstant(new Constant(stFactory.createInt(intgr)));
    }

    /** add a STBinary to the tree */
    public void addBinary(String bnry)
    {
        builder.addConstant(new Constant(stFactory.createBinary(bnry)));
    }

    /** gives the result of the tree from AST_Builder as a String */
    public String getResult()
    {
        var result = builder.getResult();
        return result.printNode();
    }

    /** Prints the tree from the AST_Builder as Pseudo Code (false) or Normal Equation (true) */
    public String printEquation(boolean bool)
    {
        if (bool){ return builder.printTree(); }
        return builder.printTreeAsCode();
    }

    /** checks if the tree from AST_Builder has Null Nodes */
    public boolean checkCompletedTree()
    {
        return builder.checkCompletedTree();
    }

}
