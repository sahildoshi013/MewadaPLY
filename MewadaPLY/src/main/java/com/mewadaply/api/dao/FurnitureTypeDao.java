package com.mewadaply.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.TblMpFurnitureType;

@Repository
public interface FurnitureTypeDao extends CrudRepository<TblMpFurnitureType, Integer>{
	List<TblMpFurnitureType> findAll();

	TblMpFurnitureType findById(int type);
}
