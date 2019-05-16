package io.jtools.totp.hr.service;

import java.io.Serializable;
import java.util.List;

import io.jtools.totp.hr.domain.HrPerson;

public interface HrService extends Serializable{

	List<HrPerson> findAll();
	HrPerson insert(HrPerson hrPserson);
	HrPerson update(HrPerson hrPserson);
	void delete(HrPerson hrPserson);
	
	String findCellPhone(String cellPhone);
	String findUserid(String cellPhone);
	String findUserPin(int userid);
	HrPerson getNewPassword(int userid);
	
}
