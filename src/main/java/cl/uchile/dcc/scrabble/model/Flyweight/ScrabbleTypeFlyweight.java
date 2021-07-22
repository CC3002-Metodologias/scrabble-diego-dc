package cl.uchile.dcc.scrabble.model.Flyweight;

import cl.uchile.dcc.scrabble.model.ScrabbleTypes.ScrabbleType;

import java.util.HashMap;

/**
 * Flyweight Pattern for ScrabbleTypes
 * Saves Memory when creating constants.
 *
 * @author Diego Caviedes A.
 */

public class ScrabbleTypeFlyweight {
    // we use a dictionary to save constants created and check if they
    // already exists when creating new ones.
    static HashMap<Object, ScrabbleType> scrabbleTypes = new HashMap<>();

    /**
     * A public method to check within the dictionary if contains
     * a certain object by a given key
     *
     * @return
     *      a ScrabbleType if the key exists, a null if not.
     */
    public static ScrabbleType checkDictionary(Object key){
        return scrabbleTypes.get(key);
    }


    /**
     * public method to add Objects to the Dictionary.
     * @param key
     *      Expected key to reference a ScrabbleType
     * @param st
     *      ScrabbleType that will be added to the Dictionary
     */
    public static void addElement(Object key, ScrabbleType st)
    {
        scrabbleTypes.put(key, st);
    }

}
