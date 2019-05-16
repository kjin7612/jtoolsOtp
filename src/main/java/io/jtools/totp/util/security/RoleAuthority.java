package io.jtools.totp.util.security;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

public enum RoleAuthority implements GrantedAuthority, Serializable {
	ROLE_USER;
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Override
	public String getAuthority() {
		return this.toString();
	}

}
