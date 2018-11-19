package com.mewadaply.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.RedeemOffersModel;

@Repository
public interface RedeemOfferDao extends CrudRepository<RedeemOffersModel,Integer>{

}
