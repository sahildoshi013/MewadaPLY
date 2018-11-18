package com.mewadaply.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.FeedbackModel;

@Repository
public interface FeedbackDao extends CrudRepository<FeedbackModel, Integer>{
}
