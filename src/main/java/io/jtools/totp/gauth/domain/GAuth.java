package io.jtools.totp.gauth.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import io.jtools.totp.userAuth.domain.UserAuth;
import io.jtools.totp.util.security.RoleAuthority;
import io.jtools.totp.util.security.TOTPUserDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(catalog = "K2IS", schema = "dbo", name = "GAuth")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GAuth implements TOTPUserDetails, Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long id;
	
	@Column
	private int userid;
	
	@Column(columnDefinition="NVARCHAR(100)")
	private String email;
	
	@Column(columnDefinition="NVARCHAR(11)")	// 전화번호로 사용
	private String password;
	
	@Column(columnDefinition="NVARCHAR(255)")	// OTP 비밀
	private String otpSecretKey;	
	
	@Transient
	private String plainPassword;
	
	@ElementCollection(fetch=FetchType.EAGER, targetClass=RoleAuthority.class)
	@Enumerated(EnumType.STRING)
    @CollectionTable(name="user_authorities")
	Set<RoleAuthority> authorities;	// 스프링시큐리티에서 권한은 EAGER 여야한다.
	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="id")
////	@JoinColumn(name="GAUTH_ID")
//	private Collection<UserAuth> userAuth;
////	private UserAuth userAuth;
	
	@OneToOne
	@JoinColumn(name = "ID")
	private UserAuth userAuth;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	
	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getSecretKey() {
		return this.otpSecretKey;
	}

}
