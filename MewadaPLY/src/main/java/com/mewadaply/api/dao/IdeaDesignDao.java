package com.mewadaply.api.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.IdeaDesignModel;
import com.mewadaply.api.model.IdeaTypeModel;

@Repository
public interface IdeaDesignDao extends JpaRepository<IdeaDesignModel, Integer>{
	List<IdeaDesignModel> findBytblMpFurnitureType(IdeaTypeModel type);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM tbl_mp_furniture_design WHERE tbl_mp_furniture_design.design_id = ?1", nativeQuery = true)
	void deleteIdeaByID(Integer id);
}
