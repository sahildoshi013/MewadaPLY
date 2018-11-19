package com.mewadaply.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mewadaply.api.dao.RedeemRequestDao;
import com.mewadaply.api.dao.TransactionDao;
import com.mewadaply.api.dao.UserDao;
import com.mewadaply.api.model.RedeemRequestModel;
import com.mewadaply.api.model.TransactionModel;
import com.mewadaply.api.utils.Utils;

@Service
public class RedeemRequestService {

	@Autowired
	RedeemRequestDao redeemRequestDao;
	
	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	UserDao userDao;
	
	public List<RedeemRequestModel> getPedingRequests() {
		return redeemRequestDao.findAllByrequestStatus(Utils.PENDING_REQUEST_STATUS);
	}
	
	public List<RedeemRequestModel> getRequests() {
		return redeemRequestDao.findAllByrequestStatusNot(Utils.PENDING_REQUEST_STATUS);
	}

	public RedeemRequestModel changeStatus(Integer id, Integer status) {
		RedeemRequestModel result = null;
		try {
			result = redeemRequestDao.findById(id).get();
			result.setRequestStatus(status);
			redeemRequestDao.save(result);
		}catch(Exception e) {
			return null;
		}
		if(status==Utils.DENY_REQUEST_STATUS) {
			TransactionModel transaction = new TransactionModel();
			transaction.setTblMpUser(result.getTblMpUser());
			transaction.setTranDescription(Utils.REDEEM_REQUEST_DENY);
			transaction.setTranPoint(result.getTblMpRedeemOffers().getOfferPoint());
			transaction.setTranType(Utils.REWARD_POINT_STATUS);
			try {
				transactionDao.save(transaction);
			}catch(Exception e) {
				return null;
			}
		}
		
		return result;
	}
}
