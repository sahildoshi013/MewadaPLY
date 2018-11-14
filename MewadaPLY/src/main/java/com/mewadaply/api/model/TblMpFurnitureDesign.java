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
 * TblMpFurnitureDesign generated by hbm2java
 */
@Entity
@Table(name="tbl_mp_furniture_design")
public class TblMpFurnitureDesign implements java.io.Serializable{


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer designId;
     private TblMpFurnitureType tblMpFurnitureType;
     private String designImage;
     private boolean designVisiblity;
     private Date designTime;

    public TblMpFurnitureDesign() {
    }

    public TblMpFurnitureDesign(TblMpFurnitureType tblMpFurnitureType, String designImage, boolean designVisiblity, Date designTime) {
       this.tblMpFurnitureType = tblMpFurnitureType;
       this.designImage = designImage;
       this.designVisiblity = designVisiblity;
       this.designTime = designTime;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="design_id", unique=true, nullable=false)
    public Integer getDesignId() {
        return this.designId;
    }
    
    public void setDesignId(Integer designId) {
        this.designId = designId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="design_type", nullable=false)
    public TblMpFurnitureType getTblMpFurnitureType() {
        return this.tblMpFurnitureType;
    }
    
    public void setTblMpFurnitureType(TblMpFurnitureType tblMpFurnitureType) {
        this.tblMpFurnitureType = tblMpFurnitureType;
    }

    
    @Column(name="design_image", nullable=false, length=50)
    public String getDesignImage() {
        return this.designImage;
    }
    
    public void setDesignImage(String designImage) {
        this.designImage = designImage;
    }

    
    @Column(name="design_visiblity", nullable=false)
    public boolean isDesignVisiblity() {
        return this.designVisiblity;
    }
    
    public void setDesignVisiblity(boolean designVisiblity) {
        this.designVisiblity = designVisiblity;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="design_time", nullable=false, length=19)
    public Date getDesignTime() {
        return this.designTime;
    }
    
    public void setDesignTime(Date designTime) {
        this.designTime = designTime;
    }




}


