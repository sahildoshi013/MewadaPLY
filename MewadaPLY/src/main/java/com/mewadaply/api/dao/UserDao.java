package com.mewadaply.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.UserModel;

@Repository
public interface UserDao extends JpaRepository<UserModel, Integer> {
	List<UserModel> findAllByuserType(int type);
}
