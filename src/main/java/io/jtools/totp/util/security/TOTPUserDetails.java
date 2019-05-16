package io.jtools.totp.util.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface TOTPUserDetails extends UserDetails {

	/**
	 * Get TOTP SecretKey
	 * @return
	 */
	String getSecretKey();
	
}
