package com.mewadaply.api.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.TransactionModel;

@Repository
public interface TransactionDao extends JpaRepository<TransactionModel, Integer> {

}
