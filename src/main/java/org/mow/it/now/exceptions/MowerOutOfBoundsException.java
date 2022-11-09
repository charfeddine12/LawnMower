package org.mow.it.now.exceptions;

/**
 * @author BENMOHAMED Charfeddine
 * @name MowerOutOfBounds
 * @date 04/11/2022
 */
public class MowerOutOfBoundsException extends RuntimeException {

    private static final String ERROR_OUT_OF_BOUNDS = "Mower out of bounds of the lawn, the mower cardinality must be less than ";

    public MowerOutOfBoundsException(String cardinality) {
        super(ERROR_OUT_OF_BOUNDS + cardinality);
    }
}
