package org.mow.it.now.exceptions;

/**
 * @author BENMOHAMED Charfeddine
 * @name AbstractParserException
 * @date 04/11/2022
 */
public abstract class AbstractParserException extends Exception {

    public AbstractParserException(String errorMessage) {
        super(errorMessage);
    }
}
