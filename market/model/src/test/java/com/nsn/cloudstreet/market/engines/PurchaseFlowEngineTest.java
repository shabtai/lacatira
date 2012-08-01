package com.nsn.cloudstreet.market.engines;

import com.nsn.cloudstreet.market.dao.CContractDao;
import com.nsn.cloudstreet.market.dao.ContractDao;
import com.nsn.cloudstreet.market.dao.ContractDataDao;
import com.nsn.cloudstreet.market.daomock.CContractDaoMock;
import com.nsn.cloudstreet.market.daomock.ContractDaoMock;
import com.nsn.cloudstreet.market.daomock.ContractDataMock;
import com.nsn.cloudstreet.market.model.*;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 5/30/12
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class PurchaseFlowEngineTest {

    private CContractDao ccontractDao;
    private ContractDataDao contractDataDao;
    private ContractDao contractDao;
    private Contract contract;

    @Before
       public void setUp() {
           contractDataDao = EasyMock.createNiceMock(ContractDataDao.class);
       contract = EasyMock.createNiceMock(Contract.class);
        contractDao = EasyMock.createNiceMock(ContractDao.class);
    }

    @Test
    public void startPurchaseFlowTest(){
        Product p = new Product() {
            @Override
            public Long getId() {
                return 3l;
            }
            @Override
            public void setId(Long id) {
            }
        };
         EasyMock.expect(contract.getProduct())
                 .andReturn(p);
        List<ContractData> contracts = new ArrayList<ContractData>();
        contracts.add(new ContractData() {
            @Override
            public Number getAvailability() {
                return 33;
            }
        });
        EasyMock.expect(contractDataDao.getContractDataByProductId(EasyMock.anyLong()))
                 .andReturn(contracts);
        EasyMock.replay(contract, contractDataDao);
        final PurchaseFlowEngine purchaseFlowEngine = new PurchaseFlowEngine();
        purchaseFlowEngine.setcContractDao(ccontractDao);
        purchaseFlowEngine.setContractDao(contractDao);
        purchaseFlowEngine.setContractDataDao(contractDataDao);


        purchaseFlowEngine.startPurchaseFlow(contract);

    }

    @Test(expected = IllegalArgumentException.class)
    public void withNoproductid(){
        final BasicContract basicContract = new BasicContract(){};
        final PurchaseFlowEngine purchaseFlowEngine = getPFE();
        basicContract.setProduct(new BasicProduct(null));
        final Contract contract1 = purchaseFlowEngine.startPurchaseFlow(basicContract);
    }

    private PurchaseFlowEngine getPFE() {
        final PurchaseFlowEngine purchaseFlowEngine = new PurchaseFlowEngine();
        purchaseFlowEngine.setcContractDao(new CContractDaoMock());
        purchaseFlowEngine.setContractDataDao(new ContractDataMock());
        purchaseFlowEngine.setContractDao(new ContractDaoMock());
        return purchaseFlowEngine;
    }

    //no contract data available
    @Test(expected = Exception.class)
    public void withproductid(){
        final PurchaseFlowEngine purchaseFlowEngine = getPFE();
        final BasicContract basicContract = new BasicContract(){};
        basicContract.setProduct(new BasicProduct(1l));
        final Contract contract1 = purchaseFlowEngine.startPurchaseFlow(basicContract);
    }

    public void withproductidfound(){
        final PurchaseFlowEngine purchaseFlowEngine = getPFE();
        final ContractData contractData = EasyMock.createNiceMock(ContractData.class);

        final BasicContract basicContract = new BasicContract(){};
        basicContract.setProduct(new BasicProduct(1l));
        final Contract contract1 = purchaseFlowEngine.startPurchaseFlow(basicContract);
    }





}
