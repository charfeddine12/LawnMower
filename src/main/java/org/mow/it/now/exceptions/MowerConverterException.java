package org.mow.it.now.exceptions;

/**
 * @author BENMOHAMED Charfeddine
 * @name MowerCreatorException
 * @date 04/11/2022
 */
public class MowerConverterException extends AbstractParserException {

    private static final String ERROR_PARSE_INSTRUCTION = "Mower instructions info parse error: expected D, G, A, actual ";


    public MowerConverterException(String actual) {
        super(ERROR_PARSE_INSTRUCTION + actual);
    }
}
