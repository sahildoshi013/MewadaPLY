package com.mewadaply.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.TransactionModel;

@Repository
public interface TransactionDao extends CrudRepository<TransactionModel, Integer> {

}
