package com.nsn.cloudstreet.market.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 4/17/12
 * Time: 10:06 AM

 */
public class BasicContractTest {

    @Test
    public void basicContractTest() {
        BasicContract contract = new BasicContract() {

        };
        Assert.assertNotNull(contract);

        Long id = 1l;
        Long buyerId = 2l;
        Long sellerId = 3l;
        Product product = new Product() {
            @Override
            public Long getId() {
                return null;
            }

            @Override
            public void setId(Long id) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        Price price = new Price(1.4, Currency.getInstance(Locale.GERMANY), new Unit() {});

        contract.setId(id);
        contract.setBuyerId(buyerId);
        contract.setSellerId(sellerId);
        contract.setPrice(price);
        contract.setProduct(product);

        Assert.assertEquals(contract.getId(), id);
        Assert.assertEquals(contract.getBuyerId(), buyerId);
        Assert.assertEquals(contract.getSellerId(), sellerId);
        Assert.assertEquals(contract.getPrice(), price);
        Assert.assertEquals(contract.getProduct(), product);

    }
}
