package com.nsn.cloudstreet.market.model;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 6/5/12
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class BasicProduct<T> implements Product{
    Long id;

    public BasicProduct(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }



    @Override
    public void setId(Long id) {
       this.id = id;
    }
}
