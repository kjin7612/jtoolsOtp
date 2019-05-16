package io.jtools.util;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetailsService;

import io.jtools.totp.dpAccountUserdepts.service.DpAccountUsersdeptsService;
import io.jtools.totp.dpAccountUsers.domain.DpAccountUsers;
import io.jtools.totp.dpAccountUsers.repo.DpAccountUsersRepository;
import io.jtools.totp.dpAccountUsers.service.DpAccountUsersService;
import io.jtools.totp.hr.service.HrService;
import io.jtools.totp.hrEmployee.service.HrEmployeeService;
import lombok.Setter;

public class PasswordInit implements Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	private static final Logger logger = LoggerFactory.getLogger(PasswordInit.class);
	
	@Setter
	private HrService hrService;

	@Setter
    private UserDetailsService userDetailsService;
    
	@Setter
    private DpAccountUsersService dpAccountUsersService;
	
	@Setter
    private DpAccountUsersdeptsService dpAccountUsersdeptsService;
	
	@Setter
	private HrEmployeeService hrEmployeeService;
	
	@Setter
	@Autowired
	private DpAccountUsersRepository dpAccountUsersRepository;

	public PasswordInit() {}
	
	public void passwordReset(String userBirth, int userid) throws Exception{
		DpAccountUsers dpAccountUsers = new DpAccountUsers();
		String password;
		password = userBirth + "kfga";
		  
		try {
			
			dpAccountUsersService.updatePassword(password, userid);
			System.out.println("====================== 성공!!!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
