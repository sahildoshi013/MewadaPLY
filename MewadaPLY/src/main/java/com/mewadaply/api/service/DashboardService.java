package com.mewadaply.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mewadaply.api.dao.RedeemRequestDao;
import com.mewadaply.api.dao.TransactionDao;
import com.mewadaply.api.dao.UserDao;
import com.mewadaply.api.model.TransactionModel;
import com.mewadaply.api.utils.Utils;

@Service
public class DashboardService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	RedeemRequestDao redeemRequestDao;
	
	@Autowired
	TransactionDao transactionDao;
	
	public Long getUserCount() {	
		return userDao.countByuserType(Utils.CUSTOMER_USER_TYPE);
	}


	public Long getPointCount() {
		return userDao.sumOfpointEarned();
	}
	
	public Long getRedeemPointCount() {
		return userDao.sumOfpointRedeem();
	}


	public Long getRedeemCount() {
		return redeemRequestDao.count();
	}


	public List<TransactionModel> getRewardHistory() {
		return transactionDao.findAll(PageRequest.of(0, 5, Direction.DESC, "tranId")).getContent();
	}
	
	

}
