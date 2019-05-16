package io.jtools.totp.dpAccountUsers.service;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jtools.totp.dpAccountUsers.repo.DpAccountUsersRepository;
import lombok.Setter;

@Service
@Transactional
public class DpAccountUsersServiceImpl implements DpAccountUsersService, Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	private Logger logger = LoggerFactory.getLogger(DpAccountUsersServiceImpl.class); 

	@Setter
	@Autowired
	private DpAccountUsersRepository dpAccountUsersRepository;
	
	public DpAccountUsersServiceImpl() {}
	
	@Override
	public void updatePassword(String password, int userid) {
		dpAccountUsersRepository.updatePassword(password, userid);
	}
	
}
