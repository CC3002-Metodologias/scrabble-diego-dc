package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

/**
 * A new ScrabbleType STNumber -> references a Java Number.
 */

public abstract class STNumber implements ScrabbleType, IScrabbleTypeNumber {

    // abstract public STFloat toSTFloat();

    abstract public STNumber add(STNumber numberToAdd);
    abstract public STNumber subtract(STNumber numberToSubtract);
    abstract public STNumber multiply(STNumber numberToMultiply);
    abstract public STNumber divide(STNumber numberToDivide);

}