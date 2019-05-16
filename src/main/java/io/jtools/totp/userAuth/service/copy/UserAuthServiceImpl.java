package io.jtools.totp.userAuth.service.copy;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.stereotype.Service;

import io.jtools.totp.userAuth.domain.UserAuth;
import io.jtools.totp.userAuth.repo.UserAuthRepository;
import lombok.Setter;

@Service
public class UserAuthServiceImpl implements UserAuthService, Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Setter
	@Autowired
	UserAuthRepository userAuthRepository;
	
	@Override
	public UserAuth insert(UserAuth userAuth) {
		return userAuthRepository.save(userAuth);
	}

	@Override
	public UserAuth update(UserAuth userAuth) {
		return userAuthRepository.save(userAuth);
	}

	@Override
	public void delete(UserAuth userAuth) {
		userAuthRepository.delete(userAuth);
	}
	
}
