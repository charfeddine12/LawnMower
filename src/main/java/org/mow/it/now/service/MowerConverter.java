package org.mow.it.now.service;

import org.mow.it.now.model.mower.Mower;

/**
 * It's a generic interface to read T and parse it into O
 *
 * @author BENMOHAMED Charfeddine
 * @name Reader
 * @date 04/11/2022
 */
public interface MowerConverter {


    /**
     * Read file content and convert it to create a mower object
     *
     * @param initializers it's the cardinality of the mower with the direction
     * @param instructions it's the instructions for the mower
     * @return a new mower with their cardinality and their instructions
     */
    Mower convert(final String[] initializers, final String instructions);
}
