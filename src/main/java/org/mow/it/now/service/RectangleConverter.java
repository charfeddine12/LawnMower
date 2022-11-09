package org.mow.it.now.service;

import org.mow.it.now.model.lawn.Rectangle;

/**
 * It's a generic interface to read T and parse it into O
 *
 * @author BENMOHAMED Charfeddine
 * @name Reader
 * @date 04/11/2022
 */
public interface RectangleConverter {

    /**
     * Read file content and convert it to create a mower object
     *
     * @param sources
     * @return a new mower with their cardinality and their instructions
     */
    Rectangle convert(final String sources);
}
