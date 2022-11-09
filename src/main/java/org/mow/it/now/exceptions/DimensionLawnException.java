package org.mow.it.now.exceptions;

/**
 * @author BENMOHAMED Charfeddine
 * @name DimensionLawnException
 * @date 04/11/2022
 */
public class DimensionLawnException extends IllegalArgumentException {

    private static final String ERROR_DIMENSION_LAWN = "Invalid dimension of lawn, width and height must have be greater than 0";

    public DimensionLawnException() {
        super(ERROR_DIMENSION_LAWN);
    }

}
