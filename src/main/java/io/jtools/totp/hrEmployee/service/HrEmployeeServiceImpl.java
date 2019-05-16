package io.jtools.totp.hrEmployee.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jtools.totp.hrEmployee.repo.HrEmployeeRepository;
import lombok.Setter;

@Service
@Transactional
public class HrEmployeeServiceImpl implements HrEmployeeService, Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Setter
	@Autowired
	private HrEmployeeRepository hrEmployeeRepository;
	
	public HrEmployeeServiceImpl() {}
	
	@Override
	public void updatePassword(String password, int userid) {
		hrEmployeeRepository.updatePassword(password, userid);
	}
	
	@Override
	public String findUserActive(int userid) {
		return hrEmployeeRepository.findUserActive(userid);
	}
	
}
