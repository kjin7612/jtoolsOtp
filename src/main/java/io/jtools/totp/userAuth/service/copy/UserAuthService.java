package io.jtools.totp.userAuth.service.copy;

import io.jtools.totp.userAuth.domain.UserAuth;

public interface UserAuthService{
	UserAuth insert(UserAuth userAuth);
	UserAuth update(UserAuth userAuth);
	void delete(UserAuth userAuth);
	
}
