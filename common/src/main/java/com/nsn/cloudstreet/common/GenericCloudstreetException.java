package com.nsn.cloudstreet.common;

/**
 * User: dovlaviati
 * Date: 5/20/12, at 12:13 PM
 *
 * A generic CloudStreet exception from which all our exceptions should originate
 */
public abstract class GenericCloudstreetException extends Exception {
    public GenericCloudstreetException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericCloudstreetException(Throwable cause) {
        super(cause);
    }

    public GenericCloudstreetException(String message) {
        super(message);
    }
}
