package com.mewadaply.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.IdeaTypeModel;

@Repository
public interface IdeaTypeDao extends CrudRepository<IdeaTypeModel, Integer>{
	List<IdeaTypeModel> findAll();

	IdeaTypeModel findById(int type);
}
