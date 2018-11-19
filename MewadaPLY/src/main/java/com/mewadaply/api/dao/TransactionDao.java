package com.mewadaply.api.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.TransactionModel;

@Repository
public interface TransactionDao extends JpaRepository<TransactionModel, Integer> {

}
