package org.mow.it.now.exceptions;

import java.io.IOException;

/**
 * @author BENMOHAMED Charfeddine
 * @name FileIncompleteException
 * @date 04/11/2022
 */
public class FileIncompleteException extends IOException {

    private static final String ERROR_INFORMATION_FILE = "Invalid file content, must have at least the initializer of the lawn ";

    public FileIncompleteException() {
        super(ERROR_INFORMATION_FILE);
    }
}
