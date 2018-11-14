package com.mewadaply.api.model;
// Generated 12 Nov, 2018 3:45:44 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TblMpRedeemOffers generated by hbm2java
 */
@Entity
@Table(name="tbl_mp_redeem_offers")
public class TblMpRedeemOffers  implements java.io.Serializable {


     private Integer offerId;
     private String offerName;
     private String offerDescription;
     private int offerPoint;
     private String offerImage;
     private Date offerCreationTime;
     private boolean offerActive;
     private Set<TblMpRedeemRequest> tblMpRedeemRequests = new HashSet<TblMpRedeemRequest>(0);

    public TblMpRedeemOffers() {
    }

	
    public TblMpRedeemOffers(String offerName, int offerPoint, String offerImage, Date offerCreationTime, boolean offerActive) {
        this.offerName = offerName;
        this.offerPoint = offerPoint;
        this.offerImage = offerImage;
        this.offerCreationTime = offerCreationTime;
        this.offerActive = offerActive;
    }
    public TblMpRedeemOffers(String offerName, String offerDescription, int offerPoint, String offerImage, Date offerCreationTime, boolean offerActive, Set<TblMpRedeemRequest> tblMpRedeemRequests) {
       this.offerName = offerName;
       this.offerDescription = offerDescription;
       this.offerPoint = offerPoint;
       this.offerImage = offerImage;
       this.offerCreationTime = offerCreationTime;
       this.offerActive = offerActive;
       this.tblMpRedeemRequests = tblMpRedeemRequests;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="offer_id", unique=true, nullable=false)
    public Integer getOfferId() {
        return this.offerId;
    }
    
    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    
    @Column(name="offer_name", nullable=false, length=70)
    public String getOfferName() {
        return this.offerName;
    }
    
    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    
    @Column(name="offer_description", length=1024)
    public String getOfferDescription() {
        return this.offerDescription;
    }
    
    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    
    @Column(name="offer_point", nullable=false)
    public int getOfferPoint() {
        return this.offerPoint;
    }
    
    public void setOfferPoint(int offerPoint) {
        this.offerPoint = offerPoint;
    }

    
    @Column(name="offer_image", nullable=false, length=50)
    public String getOfferImage() {
        return this.offerImage;
    }
    
    public void setOfferImage(String offerImage) {
        this.offerImage = offerImage;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="offer_creation_time", nullable=false, length=19)
    public Date getOfferCreationTime() {
        return this.offerCreationTime;
    }
    
    public void setOfferCreationTime(Date offerCreationTime) {
        this.offerCreationTime = offerCreationTime;
    }

    
    @Column(name="offer_active", nullable=false)
    public boolean isOfferActive() {
        return this.offerActive;
    }
    
    public void setOfferActive(boolean offerActive) {
        this.offerActive = offerActive;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tblMpRedeemOffers")
    public Set<TblMpRedeemRequest> getTblMpRedeemRequests() {
        return this.tblMpRedeemRequests;
    }
    
    public void setTblMpRedeemRequests(Set<TblMpRedeemRequest> tblMpRedeemRequests) {
        this.tblMpRedeemRequests = tblMpRedeemRequests;
    }




}

