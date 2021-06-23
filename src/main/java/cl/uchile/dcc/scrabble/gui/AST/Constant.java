package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ISTLogicalOperationCompatible;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

/**
 * Constants represent a ScrabbleType,
 * they will be the leaf in the AST
 *
 * @author Diego Caviedes C.
 */


public class Constant implements AST_IConstant {
    ScrabbleType myST;

    /** Constructor for a Constant */
    public Constant(ScrabbleType x)
    {
        this.myST = x;
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (!(o instanceof Constant))
            return false;
        Constant cte = (Constant) o;
        // field comparison
        return this.myST.equals(cte.myST);
    }

    @Override
    public Constant GetResult() {
        return this;
    }

    @Override
    public String printNode() {
        return this.myST.STtoString();
    }

    @Override
    public ScrabbleType toST() {
        return myST;
    }

    @Override
    public Constant conjunction(Constant y) {
        Constant result = new Constant(this.myST.conjunction(y.toST()));
        return result;
    }

    @Override
    public Constant disjunction(Constant y) {
        Constant result = new Constant(this.myST.disjunction(y.toST()));
        return result;
    }

    @Override
    public Constant add(Constant y) {
        Constant result = new Constant(this.myST.add(y.toST()));
        return result;
    }

    @Override
    public Constant subtract(Constant y) {
        Constant result = new Constant(this.myST.subtract(y.toST()));
        return result;
    }

    @Override
    public Constant multiply(Constant y) {
        Constant result = new Constant(this.myST.multiply(y.toST()));
        return result;
    }

    @Override
    public Constant divide(Constant y) {
        Constant result = new Constant(this.myST.divide(y.toST()));
        return result;
    }

    @Override
    public Constant negation() {
        Constant result = new Constant(this.myST.negation());
        return result;
    }

    @Override
    public Constant toSTString() {
        Constant result = new Constant(this.myST.toSTString());
        return result;
    }

    @Override
    public Constant toSTBoolean() {
        Constant result = new Constant(this.myST.toSTBoolean());
        return result;
    }

    @Override
    public Constant toSTFloat() {
        Constant result = new Constant(this.myST.toSTFloat());
        return result;
    }

    @Override
    public Constant toSTInt() {
        Constant result = new Constant(this.myST.toSTInt());
        return result;
    }

    @Override
    public Constant toSTBinary() {
        Constant result = new Constant(this.myST.toSTBinary());
        return result;
    }


}
