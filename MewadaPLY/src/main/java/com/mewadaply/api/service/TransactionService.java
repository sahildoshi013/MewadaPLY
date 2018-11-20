package com.mewadaply.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mewadaply.api.dao.RedeemOfferDao;
import com.mewadaply.api.dao.RedeemRequestDao;
import com.mewadaply.api.dao.TransactionDao;
import com.mewadaply.api.dao.UserDao;
import com.mewadaply.api.model.RedeemOffersModel;
import com.mewadaply.api.model.RedeemRequestModel;
import com.mewadaply.api.model.TransactionModel;
import com.mewadaply.api.model.UserModel;
import com.mewadaply.api.utils.Utils;

@Service
public class TransactionService {
	
	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	RedeemOfferDao redeemOfferDao;
	
	@Autowired
	RedeemRequestDao redeemRequestDao;
	
	public Iterable<TransactionModel> getAllTransactions() {
		return transactionDao.findAll();
	}

	public boolean addReward(int userId, int point, String desc) {
		
		TransactionModel tran = new TransactionModel();
		
		tran.setTblMpUser(userDao.findById(userId).get());
		tran.setTranDescription(desc);
		tran.setTranPoint(point);
		tran.setTranType(Utils.REWARD_POINT_STATUS);
		
		try {
			transactionDao.save(tran);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public List<TransactionModel> getUserTransactionByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return transactionDao.findBytblMpUser(userDao.findById(userId).get());
	}

	public boolean addRedeemRequest(Integer offerId, Integer userId) {
		// TODO Auto-generated method stub
		TransactionModel tran = new TransactionModel();
		UserModel user = userDao.findById(userId).get();
		RedeemOffersModel offer = redeemOfferDao.findById(offerId).get();
		
		
		tran.setTblMpUser(user);
		tran.setTranDescription("Redeem : "+ offer.getOfferName() + "\n" + offer.getOfferDescription());
		tran.setTranPoint(offer.getOfferPoint());
		tran.setTranType(Utils.REDEEM_REQUEST_TYPE);
		tran.setTranTime(new Date());
		
		RedeemRequestModel request = new RedeemRequestModel();
		request.setRequestStatus(Utils.PENDING_REQUEST_STATUS);
		request.setRequestTime(new Date());
		request.setTblMpRedeemOffers(offer);
		request.setTblMpUser(user);
		try {
			transactionDao.save(tran);
			redeemRequestDao.save(request);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
}
