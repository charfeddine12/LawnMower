package org.mow.it.now.service;

import org.mow.it.now.model.mower.Mower;

/**
 * IMower an interface to provide predefined methods in the class
 *
 * @author BENMOHAMED Charfeddine
 * @name IMower
 * @date 04/11/2022
 */
public interface MowerCreator {

    /**
     * Create a mower from the sources
     *
     * @param sources
     * @return a mower with the finish postion in the lawn
     */
    Mower createMower(String[] sources);

    /**
     * Checks whether the object is out of bounds
     *
     * @param x the coordinate x of the object
     * @param y the coordinate y of the object
     * @return <tt>true</tt> if the shape contains the object which position
     * is defined by its coordinates x and y
     */
    boolean isInBounds(int x, int y);

    /**
     * Set the mower position at {x,y} on the Rectangle
     *
     * @param id the id of the object
     * @param x  the coordinate x of the mower
     * @param y  the coordinate y of the mower
     */
    void placeMower(int id, int x, int y);

    /**
     * Checks whether the lawn is already occupied by an object at the position {x,y}
     * The grid is considered as occupied when the value at position {x,y} is different 0.
     *
     * @param x the coordinate x of the object
     * @param y the coordinate y of the object
     * @return true if there is an object on the lawn at position {x,y}
     */
    boolean isOccupied(int x, int y);

    /**
     * start moved the mower following the instructions
     *
     * @param mower
     */
    void move(Mower mower);

}
