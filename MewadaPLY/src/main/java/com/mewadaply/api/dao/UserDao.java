package com.mewadaply.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mewadaply.api.model.UserModel;

@Repository
public interface UserDao extends JpaRepository<UserModel, Integer> {
	List<UserModel> findAllByuserType(int type);
	
	Long countByuserType(Integer type);
	
	@Query(value = "SELECT SUM(point_earned) FROM tbl_mp_user WHERE user_type = 3 ", nativeQuery = true)
	 Long sumOfpointEarned();
	
	@Query(value = "SELECT SUM(point_redeem) FROM tbl_mp_user WHERE user_type = 3 ", nativeQuery = true)
	Long sumOfpointRedeem();
	
	@Query("SELECT u FROM UserModel u WHERE u.firstName LIKE %?1% OR u.lastName LIKE %?1% OR  u.emailId LIKE %?1% OR u.phoneNo LIKE %?1%")
	List<UserModel> findByfirstNameContainingAllIgnoreCase(String query);
}
