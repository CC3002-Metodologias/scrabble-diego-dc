package cl.uchile.dcc.scrabble.model.ScrabbleTypes;

import cl.uchile.dcc.scrabble.model.ScrabbleTypes.STNumberSubtypes.STFloat;

/**
 * A new ScrabbleType STNumber -> references a Java Number.
 */

public abstract class STNumber implements ISTNumber {

    abstract public STFloat toSTFloat();


}