package com.mewadaply.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mewadaply.api.dao.TransactionDao;
import com.mewadaply.api.model.TransactionModel;

@Service
public class TransactionService {
	
	@Autowired
	TransactionDao transactionDao;
	
	public Iterable<TransactionModel> getAllTransactions() {
		return transactionDao.findAll();
	}
}
