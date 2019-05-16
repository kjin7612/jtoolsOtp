package io.jtools.totp.hrEmployee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import io.jtools.totp.hrEmployee.domain.HrEmployee;

public interface HrEmployeeRepository extends JpaRepository<HrEmployee, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE HrEmployee x "
			+ "SET "
			+ "	x.loginPassword = ?"
			+ "WHERE x.userid = ?")
	public void updatePassword(String password, int userid);
	
	@Query("SELECT x.activeYn FROM HrEmployee x WHERE x.activeYn = 'Y' AND x.retireDate is null AND x.userid = ?")
	String findUserActive(int userid);

}
