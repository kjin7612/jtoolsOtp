package io.jtools.totp.dpAccountUserdepts.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jtools.totp.dpAccountUserdepts.repo.DpAccoutUserdeptsRepository;
import lombok.Setter;

@Service
@Transactional
public class DpAccountUserdeptsServiceImpl implements DpAccountUsersdeptsService, Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Setter
	@Autowired
	private DpAccoutUserdeptsRepository dpAccoutUserdeptsRepository;
	
	public DpAccountUserdeptsServiceImpl() {}
	
	@Override
	public void updatePassword(String password, int userid) {
		dpAccoutUserdeptsRepository.updatePassword(password, userid);
	}
	
}
