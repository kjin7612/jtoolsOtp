package io.jtools.totp.dpAccountUsers.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import io.jtools.totp.dpAccountUsers.domain.DpAccountUsers;

public interface DpAccountUsersRepository extends JpaRepository<DpAccountUsers, Integer>, Serializable{
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE DpAccountUsers x "
			+ "SET "
			+ "x.password = ?1 "
			+ ", x.mailpassword = ?1 "
			+ ", x.passwordupdatedate = GETDATE() "
			+ "WHERE x.userid = ?2")
	public void updatePassword(String password, int userid);
	
}
