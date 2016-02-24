package com.martinrist.hibernate.caveatEmptor.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Item implements Serializable {

    private String name;
    private String description;
    private Date createdOn;
    private boolean verified;
    private AuctionType auctionType;
    private BigDecimal initialPrice;
    private Date auctionStart;
    private Date auctionEnd;
    private Set<Bid> bids = new HashSet<>();

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public AuctionType getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(AuctionType auctionType) {
        this.auctionType = auctionType;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Date getAuctionStart() {
        return auctionStart;
    }

    public void setAuctionStart(Date auctionStart) {
        this.auctionStart = auctionStart;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public Set<Bid> getBids() {
        // Since we're not returning the same instance that was passed in the setter
        // we'll need to configure Hibernate for field access
        return Collections.unmodifiableSet(bids);
    }

    private void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public void addBid(Bid bid) {
        Objects.requireNonNull(bid, "Can't add a null Bid");

        if (bid.getItem() != null) {
            throw new IllegalStateException("Bid is already assigned to an Item");
        }

        getBids().add(bid);
        bid.setItem(this);
    }
}
