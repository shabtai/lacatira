package com.nsn.cloudstreet.rest.errorhandling;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * User: dovlaviati
 * Date: 5/20/12, at 12:11 PM
 *
 * This class maps Throwables that might be thrown by the server to Response objects.
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    /**
     * Generic response message in case an error message does not exist
     */
    public final static String GENERIC_ERROR_MESSAGE = "An error has occured";

    private final Log log = LogFactory.getLog(getClass());

    /**
     * Constructs an internal-server-error (code 500) response upon receiving any
     * throwable from the server
     *
     * @param t     The throwable that has been thrown
     * @return      Response object to be sent out of the server
     */
    public Response toResponse(Throwable t) {
        String entity;
        if (null == t.getMessage() || t.getMessage().equals("")){
            entity = GENERIC_ERROR_MESSAGE;
        } else {
            entity = t.getMessage();
        }

        log.debug(t.getMessage(), t); // print stack trace in any case for debugging

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(entity).type("text/plain").build();
    }
}



