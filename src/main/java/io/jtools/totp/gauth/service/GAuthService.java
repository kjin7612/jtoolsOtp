package io.jtools.totp.gauth.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import io.jtools.totp.gauth.domain.GAuth;

public interface GAuthService extends UserDetailsService {
	
	Long userSelctEmailForAuth(String email);

	void deleteUserbyEmail(String email);
	
	/**
	 * Save new GAuth
	 * @param user
	 * @return
	 */
	GAuth insert(GAuth gAuth);
	
	/**
	 * Update User
	 * @param user
	 * @return
	 */
	GAuth update(GAuth gAuth);
	
	/**
	 * Delete User
	 * @param user
	 */
	void delete(GAuth gAuth);
	
	
}
