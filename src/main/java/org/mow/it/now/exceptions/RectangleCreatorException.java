package org.mow.it.now.exceptions;

/**
 * @author BENMOHAMED Charfeddine
 * @name MowerCreatorException
 * @date 04/11/2022
 */
public class RectangleCreatorException extends AbstractParserException {

    private static final String ERROR_PARSE = "Rectangle lawn info parse error: expected X Y, actual ";

    public RectangleCreatorException(String errorMessage) {
        super(ERROR_PARSE + errorMessage);
    }
}
