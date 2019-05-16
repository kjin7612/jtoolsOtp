package io.jtools.totp.userAuth.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.SpringSecurityCoreVersion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(catalog = "K2IS", schema = "dbo", name = "USER_AUTHORITIES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuth implements Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Id
	@Column(name="GAUTH_ID")	// OTP 비밀
	private Long id;
	
	@Column(columnDefinition = "NVARCHAR(50)")	// OTP 비밀
	private String authorities;
	
}
