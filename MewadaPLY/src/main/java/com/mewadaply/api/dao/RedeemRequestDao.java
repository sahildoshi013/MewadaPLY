package com.mewadaply.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.RedeemRequestModel;

@Repository
public interface RedeemRequestDao extends CrudRepository<RedeemRequestModel, Integer>{
	List<RedeemRequestModel> findAllByrequestStatus(Integer status);

	List<RedeemRequestModel> findAllByrequestStatusNot(Integer pendingRequestStatus);

	Long countByrequestStatus(Integer status);
}
