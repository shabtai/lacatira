package com.nsn.cloudstreet.market.model;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 4/17/12
 * Time: 9:58 AM
 * consign - To deliver (merchandise, for example) for custody or sale..
 * url: http://en.wikipedia.org/wiki/Consignment
 * Consignment the act of consigning, which is placing any material in the hand of another, but retaining ownership until the goods are sold or person is transferred.
 */
public interface ConsignmentContract<P extends Product, PR extends Price<U>,U extends Unit, Q extends Quantity> extends Contract<P,PR,U,Q >{
    void setExpirationDate(Calendar date);

    Calendar getExpirationDate();

    ContractData createContractData();
}
