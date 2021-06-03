package cl.uchile.dcc.scrabble.gui.ScrabbleTypes;

import cl.uchile.dcc.scrabble.gui.ScrabbleTypes.STNumberSubtypes.STFloat;

/**
 * A new ScrabbleType STNumber -> references a Java Number.
 */

public abstract class STNumber implements ISTNumber {

    abstract public STFloat toSTFloat();

    /**protected abstract STNumber add(STNumber numberToAdd);
    abstract STNumber subtract(STNumber numberToSubtract);
    abstract STNumber multiply(STNumber numberToMultiply);
    abstract STNumber divide(STNumber numberToDivide);**/
}