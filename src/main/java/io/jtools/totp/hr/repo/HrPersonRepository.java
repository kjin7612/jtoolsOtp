package io.jtools.totp.hr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.jtools.totp.hr.domain.HrPerson;

public interface HrPersonRepository extends JpaRepository<HrPerson, String> {
	@Query("SELECT x.pin FROM HrPerson x where x.userid = ?")
	String findUserPin(int userid);

	@Query("SELECT x.cellPhone FROM HrPerson x where x.cellPhone = ?")
	String findCellPhone(String cellPhone);
	
	@Query("SELECT x.userid FROM HrPerson x where x.cellPhone = ?")
	String findUserid(String cellPhone);
	
	
	@Query("SELECT x.userid, x.pin FROM HrPerson x where x.userid = ?")
	HrPerson getNewPassword(int userid);
	
}
