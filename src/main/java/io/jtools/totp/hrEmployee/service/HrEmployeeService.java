package io.jtools.totp.hrEmployee.service;

import java.io.Serializable;

public interface HrEmployeeService extends Serializable{

	public void updatePassword(String password, int userid);
	
	String findUserActive(int userid);
}
