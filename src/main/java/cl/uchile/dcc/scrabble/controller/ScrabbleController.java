package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.model.AST.AST_Operator;
import cl.uchile.dcc.scrabble.model.AST.Operations.STAddition;

public class ScrabbleController {
    private static AST_Operator root;
    private static AST_Operator l_child;
    private static AST_Operator r_child;

    public static void createCalc(AST_Operator operator)
    {
        root = operator;
    }

    public static String printEquation()
    {
        return root.printNode();
    }

}
