package com.nsn.cloudstreet.market.model;


import com.lacatira.common.BusinessModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public interface Contract<P extends Product, PR extends Price<U>,U extends Unit, Q extends Quantity> extends BusinessModel {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    Long getId();

    void setId(Long id);

   
    P getProduct();

    void setProduct(P product);

    Long getSellerId();

    void setSellerId(Long sellerId);

    Long getBuyerId();

    void setBuyerId(Long buyerId);

    PR getPrice();

    void setPrice(PR price);

    Q getQuantity();

    void setQuantity(Q q);
}
