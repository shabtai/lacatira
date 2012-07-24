package com.nsn.cloudstreet.market.model;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 5/23/12
 * Time: 4:07 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Quantity<U extends Unit, N extends Number> {


     N getValue();
     U getUnit();
}
