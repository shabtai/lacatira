package com.nsn.cloudstreet.market.model;




import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;



@MappedSuperclass
public abstract class BasicContract<P extends Product, PR extends Price<U>,U extends Unit, Q extends Quantity> implements Contract<P,PR,U,Q>{
    private Long id;
    private P product;
    private long sellerId;
	private long buyerId;
    private PR price;
    private Q quantity;


    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }
    
    @Column(name = "sellerId")
    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId=sellerId;
    }
    @Column(name = "buyerId")
    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId=buyerId;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @NotFound(action=NotFoundAction.IGNORE)
    public P getProduct() {
    	return product;
    }
    
	public void setProduct(P product) {
    	this.product = product;
    }

    @Embedded
    public PR getPrice() {
        return price;
    }

    public void setPrice(PR price) {
        this.price=price;
    }


    @Override
     @Embedded
    public Q getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(Q bandwidth) {
        this.quantity = bandwidth;
    }
}
