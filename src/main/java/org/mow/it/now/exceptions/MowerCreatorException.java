package org.mow.it.now.exceptions;

/**
 * @author BENMOHAMED Charfeddine
 * @name MowerCreatorException
 * @date 04/11/2022
 */
public class MowerCreatorException extends AbstractParserException {

    private static final String ERROR_PARSE = "Mower info parse error: expected X Y Direction {N, S, W, E}, actual ";
    private static final String ERROR_PARSE_INSTRUCTION = "Mower instructions info parse error: expected D, G, A, actual ";

    public MowerCreatorException(String actual) {
        super(ERROR_PARSE + actual);
    }


}
