package com.nsn.cloudstreet.dao.inheritance;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 4/22/12
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public interface A<T > {
    long getId();
    T getUncle();
}
