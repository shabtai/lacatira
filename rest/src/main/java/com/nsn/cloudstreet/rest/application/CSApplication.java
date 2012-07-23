package com.nsn.cloudstreet.rest.application;

/**
 * User: dovlaviati
 * Date: 5/20/12, at 12:16 PM
 */

import com.nsn.cloudstreet.rest.errorhandling.GenericExceptionMapper;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Defines the components of a JAX-RS application and supplies additional metadata..
 */
public class CSApplication  extends Application {
    /**
     * The getClasses() method returns a list of classes you want to deploy into the JAX-RS environment.
     */
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(GenericExceptionMapper.class) ;
        return classes;
    }
}
