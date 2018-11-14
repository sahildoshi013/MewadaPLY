package com.mewadaply.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.TblMpFurnitureDesign;
import com.mewadaply.api.model.TblMpFurnitureType;

@Repository
public interface FurnitureDesignDao extends CrudRepository<TblMpFurnitureDesign, Integer>{
	List<TblMpFurnitureDesign> findAll();
	List<TblMpFurnitureDesign> findBytblMpFurnitureType(TblMpFurnitureType type);
}
