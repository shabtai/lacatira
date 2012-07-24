package com.nsn.cloudstreet.market.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;

public class BasicConsignmentContractTest {

    @Test
    public void basicConsignmentContractTest() {
        BasicConsignmentContract basicConsignmentContract = new BasicConsignmentContract() {
            @Override
            public ContractData createContractData() {
                return null;
            }


        };
        GregorianCalendar c = new GregorianCalendar();

        Assert.assertNotNull(basicConsignmentContract);

        basicConsignmentContract.setExpirationDate(c);
        Assert.assertEquals(basicConsignmentContract.getExpirationDate(), c);
    }
}
