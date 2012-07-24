package com.nsn.cloudstreet.market.model;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unchecked")
public class ContractDataTest {
    @Test
    public void testContractData() {
        ContractData data = new ContractData(){

            @Override
            public Number getAvailability() {
                return null;
            }
        };
        BasicConsignmentContract cc = EasyMock.createNiceMock(BasicConsignmentContract.class);
        BasicContract c = EasyMock.createNiceMock(BasicContract.class);
        Set<Contract> contracts = new HashSet<Contract>();
        contracts.add(c);

        data.setConsignmentContract(cc);
        data.setContracts(contracts);

        Assert.assertEquals(data.getConsignmentContract(), cc);
        Assert.assertEquals(data.getContracts(), contracts);

        data.setId(111l);
        Assert.assertEquals(data.getId(), (Long)111l);
    }

    @Test
    public void testAddContract() {
        ContractData data = new ContractData(){

            @Override
            public Number getAvailability() {
                return null;
            }
        };
        BasicContract c = EasyMock.createNiceMock(BasicContract.class);
        Assert.assertNotNull(data.getContracts());
        Assert.assertEquals(data.getContracts().size(), 0);

        data.addContract(c);

        Assert.assertEquals(data.getContracts().size(), 1);
        Assert.assertTrue(data.getContracts().contains(c));
    }
}
