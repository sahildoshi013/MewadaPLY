package com.mewadaply.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.IdeaDesignModel;
import com.mewadaply.api.model.IdeaTypeModel;

@Repository
public interface IdeaDesignDao extends CrudRepository<IdeaDesignModel, Integer>{
	List<IdeaDesignModel> findAll();
	List<IdeaDesignModel> findBytblMpFurnitureType(IdeaTypeModel type);
}
