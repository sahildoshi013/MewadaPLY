package com.mewadaply.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mewadaply.api.dao.TransactionDao;
import com.mewadaply.api.dao.UserDao;
import com.mewadaply.api.model.TransactionModel;
import com.mewadaply.api.utils.Utils;

@Service
public class TransactionService {
	
	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	UserDao userDao;
	
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
}
