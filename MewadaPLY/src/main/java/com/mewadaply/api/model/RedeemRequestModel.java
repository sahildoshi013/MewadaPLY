package com.mewadaply.api.model;
// Generated 12 Nov, 2018 3:45:44 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TblMpRedeemRequest generated by hbm2java
 */
@Entity
@Table(name="tbl_mp_redeem_request")
public class RedeemRequestModel {


     private Integer requestId;
     private RedeemOffersModel tblMpRedeemOffers;
     private UserModel tblMpUser;
     private boolean requestStatus;
     private Date requestTime;

    public RedeemRequestModel() {
    }

    public RedeemRequestModel(RedeemOffersModel tblMpRedeemOffers, UserModel tblMpUser, boolean requestStatus, Date requestTime) {
       this.tblMpRedeemOffers = tblMpRedeemOffers;
       this.tblMpUser = tblMpUser;
       this.requestStatus = requestStatus;
       this.requestTime = requestTime;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="request_id", unique=true, nullable=false)
    public Integer getRequestId() {
        return this.requestId;
    }
    
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="request_offer_id", nullable=false)
    public RedeemOffersModel getTblMpRedeemOffers() {
        return this.tblMpRedeemOffers;
    }
    
    public void setTblMpRedeemOffers(RedeemOffersModel tblMpRedeemOffers) {
        this.tblMpRedeemOffers = tblMpRedeemOffers;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="request_user_id", nullable=false)
    public UserModel getTblMpUser() {
        return this.tblMpUser;
    }
    
    public void setTblMpUser(UserModel tblMpUser) {
        this.tblMpUser = tblMpUser;
    }

    
    @Column(name="request_status", nullable=false)
    public boolean isRequestStatus() {
        return this.requestStatus;
    }
    
    public void setRequestStatus(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="request_time", nullable=false, length=19)
    public Date getRequestTime() {
        return this.requestTime;
    }
    
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }




}

