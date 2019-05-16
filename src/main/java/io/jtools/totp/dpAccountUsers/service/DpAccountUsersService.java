package io.jtools.totp.dpAccountUsers.service;

import java.io.Serializable;

public interface DpAccountUsersService extends Serializable{

	public void updatePassword(String password, int userid);
	
}
