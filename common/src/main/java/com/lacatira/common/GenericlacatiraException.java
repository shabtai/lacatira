package com.lacatira.common;

/**
 * User: dovlaviati
 * Date: 5/20/12, at 12:13 PM
 *
 * A generic lacatira exception from which all our exceptions should originate
 */
public abstract class GenericlacatiraException extends Exception {
    public GenericlacatiraException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericlacatiraException(Throwable cause) {
        super(cause);
    }

    public GenericlacatiraException(String message) {
        super(message);
    }
}
