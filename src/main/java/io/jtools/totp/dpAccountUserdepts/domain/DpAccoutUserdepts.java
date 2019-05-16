package io.jtools.totp.dpAccountUserdepts.domain;

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
@Table(catalog = "deskPlusEIP", schema = "dbo", name = "DP_ACCOUNT_USERDEPTS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DpAccoutUserdepts implements Serializable {
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Id
	private int companyid; // 1
	
	@Column(columnDefinition = "INT")
	private int userid; // 2
	
	@Column(columnDefinition = "INT")
	private int deptid; // 3
	
	@Column(columnDefinition = "INT")
	private int codetitleid; // 4
	
	@Column(columnDefinition = "INT")
	private int codedutyid; // 5
	
	@Column(columnDefinition = "CHAR(1)")
	private String basedept; // 6
	
	@Column(columnDefinition = "INT")
	private int userdeptorder; // 7
	
	@Column(columnDefinition = "VARCHAR(20)")
	private String mailid; // 8
	
	@Column(columnDefinition = "VARCHAR(30)")
	private String maildomain; // 9
	
	@Column(columnDefinition = "NVARCHAR(30)")
	private String mailpassword; // 10
	
	@Column(columnDefinition = "INT")
	private int writeuserid; // 11
	
	@Column(columnDefinition = "DATETIME")
	private String writedate; // 12
	
	@Column(columnDefinition = "INT")
	private int modifyuserid; // 13
	
	@Column(columnDefinition = "DATETIME")
	private String modifydate; // 14

	
}
