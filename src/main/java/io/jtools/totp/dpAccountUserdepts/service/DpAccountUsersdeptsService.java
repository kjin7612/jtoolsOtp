package io.jtools.totp.dpAccountUserdepts.service;

import java.io.Serializable;

public interface DpAccountUsersdeptsService extends Serializable{

	public void updatePassword(String password, int userid);
	
}
