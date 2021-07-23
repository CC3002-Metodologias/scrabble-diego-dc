package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.model.AST.AST_Operator;
import cl.uchile.dcc.scrabble.model.AST.Constant;
import cl.uchile.dcc.scrabble.model.AST.Operations.*;
import cl.uchile.dcc.scrabble.model.AST.Transformations.*;
import cl.uchile.dcc.scrabble.model.Flyweight.STFactory.STFactory;

public class ScrabbleController {
    private ASTBuilder builder = new ASTBuilder();
    STFactory stFactory = new STFactory();

    public void createCalc(String str)
    {
        if(str == "+")
        {
            builder.createTree(new STAddition(null,null));
        }
        if(str == "-")
        {
            builder.createTree(new STSubtraction(null,null));
        }
        if(str == "*")
        {
            builder.createTree(new STMultiplication(null,null));
        }
        if(str == "~")
        {
            builder.createTree(new STNegation(null));
        }
        if(str == "AND")
        {
            builder.createTree(new ST_AND(null,null));
        }
        if(str == "OR")
        {
            builder.createTree(new ST_OR(null,null));
        }
        if(str == "/")
        {
            builder.createTree(new STDivision(null,null));
        }
        if(str == "toBinary")
        {
            builder.createTree(new toSTBinary(null));
        }
        if(str == "toBoolean")
        {
            builder.createTree(new toSTBoolean(null));
        }
        if(str == "toFloat")
        {
            builder.createTree(new toSTFloat(null));
        }
        if(str == "toInt")
        {
            builder.createTree(new toSTInt(null));
        }
        if(str == "toString")
        {
            builder.createTree(new toSTString(null));
        }
    }

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

    public void addString(String str)
    {
        builder.addConstant(new Constant(stFactory.createString(str)));
    }

    public void addBoolean(boolean bool)
    {
        builder.addConstant(new Constant(stFactory.createBoolean(bool)));
    }

    public void addFloat(Double dbl)
    {
        builder.addConstant(new Constant(stFactory.createFloat(dbl)));
    }

    public void addInt(int intgr)
    {
        builder.addConstant(new Constant(stFactory.createInt(intgr)));
    }

    public void addBinary(String bnry)
    {
        builder.addConstant(new Constant(stFactory.createBinary(bnry)));
    }

    public String getResult()
    {
        var result = builder.getResult();
        return result.printNode();
    }

    public String printEquation()
    {
        return builder.printTree();
    }

}
