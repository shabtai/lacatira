package com.nsn.cloudstreet.market.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 4/24/12
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class PriceTest {

    @Test
    public void testPrice(){
        final Unit unit = new Unit() {};
        final Price price = new Price(1.4, Currency.getInstance(Locale.GERMANY), unit);
        final Price price2 = new Price(1.4, Currency.getInstance(Locale.GERMANY), unit);
        Assert.assertEquals(price,price2);
        Set<Price> set = new HashSet<Price>();
        set.add(price);
        set.add(price2);
        Assert.assertEquals(set.size(),1);
    }

    @Test
    public void testPriceMethods(){
        final Unit unit = new Unit() {};
        final Price price = new Price();
        final Price price2 = new Price(1.4, Currency.getInstance(Locale.GERMANY), unit);
        final Price price3 = new Price();

        Assert.assertThat(price, not(equalTo(price2)));

        price.setVal(1.4);
        price.setCurrency(Currency.getInstance(Locale.GERMANY));
        price.setUnit(unit);

        // now they should be equal
        Assert.assertEquals(price,price2);

        // price1 & price3 are not equal
        Assert.assertThat(price, not(equalTo(price3)));

        price3.setVal(price.getVal());
        price3.setCurrency(price.getCurrency());
        price3.setUnit(price.getUnit());

        // now they should be equal
        Assert.assertEquals(price, price3);
    }

}
