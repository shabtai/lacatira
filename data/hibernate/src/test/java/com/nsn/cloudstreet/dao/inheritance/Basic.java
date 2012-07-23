package com.nsn.cloudstreet.dao.inheritance;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 4/22/12
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="basic",
    discriminatorType= DiscriminatorType.STRING
)
@DiscriminatorValue("Basic")
public class Basic<T> implements A<T>{
    long id;
    T uncle;
     @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
       @ManyToOne(cascade = CascadeType.ALL)
    public T getUncle() {
        return uncle;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUncle(T uncle) {
        this.uncle = uncle;
    }
}
