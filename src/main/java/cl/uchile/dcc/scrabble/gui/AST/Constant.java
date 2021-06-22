package cl.uchile.dcc.scrabble.gui.AST;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ISTLogicalOperationCompatible;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STString;
import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.ScrabbleType;

public class Constant implements AST_IConstant {
    ScrabbleType myST;

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


}
