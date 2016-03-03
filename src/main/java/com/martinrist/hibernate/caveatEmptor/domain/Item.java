package com.martinrist.hibernate.caveatEmptor.domain;

import com.martinrist.hibernate.caveatEmptor.converter.MonetaryAmountConverter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    @NotNull
    @Size(min = 2, max = 255, message = "Name is required, maximum 255 characters")
    private String name;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    private boolean verified;

    @Enumerated(EnumType.STRING)
    private AuctionType auctionType;

    @Column(name = "START_PRICE", nullable = false)
    private BigDecimal initialPrice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date auctionStart;

    @Future
    @Temporal(TemporalType.TIMESTAMP)
    private Date auctionEnd;

    @Convert(converter = MonetaryAmountConverter.class,
             disableConversion = false)
    @Column(name = "PRICE", length = 63)
    private MonetaryAmount buyNowPrice;

    @Transient
    private Set<Bid> bids = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User seller;

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Item() {
    }

    public static Item newInstance(String name) {

        Item i = new Item();
        i.setName(name);
        i.setCreatedOn(new Date());
        i.setInitialPrice(BigDecimal.ZERO);
        return i;
    }

    public Long getId() {
        return id;
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

    public MonetaryAmount getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(MonetaryAmount buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
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
