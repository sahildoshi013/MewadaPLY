package com.mewadaply.api.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.TransactionModel;
import com.mewadaply.api.model.UserModel;

@Repository
public interface TransactionDao extends JpaRepository<TransactionModel, Integer> {

	List<TransactionModel> findBytblMpUser(UserModel user);

}
