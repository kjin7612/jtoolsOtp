package io.jtools.totp.hrEmployee.domain;

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
@Table(catalog = "KFG", schema = "dbo", name = "HR_EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HrEmployee implements Serializable {
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Id
	private int userid; // 1

	@Column(columnDefinition = "INT")
	private int orgid; // 2
	
	@Column(columnDefinition = "INT")
	private int d1; // 3
	
	@Column(columnDefinition = "INT")
	private int d2; // 4
	
	@Column(columnDefinition = "INT")
	private int d3; // 5
	
	@Column(columnDefinition = "NVARCHAR(30)")
	private String dn1; // 6
	
	@Column(columnDefinition = "NVARCHAR(30)")
	private String dn2; // 7
	
	@Column(columnDefinition = "NVARCHAR(30)")
	private String dn3; // 8
	
	@Column(columnDefinition = "NVARCHAR(30)")
	private String username; // 9
	
	@Column(columnDefinition = "VARCHAR(16)")
	private String loginid; // 10
	
	@Column(columnDefinition = "VARCHAR(64)")
	private String loginPassword; // 11
	
	@Column(columnDefinition = "VARCHAR(64)")
	private String securityPassword; // 12
	
	@Column(columnDefinition = "VARCHAR(5)")
	private String businessClassCode; // 13
	
	@Column(columnDefinition = "VARCHAR(5)")
	private String titleCode; // 14
	
	@Column(columnDefinition = "VARCHAR(5)")
	private String dutyCode; // 15
	
	@Column(columnDefinition = "VARCHAR(5)")
	private String lifePositionCode; // 16
	
	@Column(columnDefinition = "VARCHAR(5)")
	private String nonlifePositionCode; // 17
	
	@Column(columnDefinition = "VARCHAR(5)")
	private String bankCode; // 18
	
	@Column(columnDefinition = "VARCHAR(32)")
	private String bankAccount; // 19
	
	@Column(columnDefinition = "VARCHAR(64)")
	private String accountHolder; // 20
	
	@Column(columnDefinition = "VARCHAR(32)")
	private String accountRelation; // 21
	
	@Column(columnDefinition = "VARCHAR(64)")
	private String photoImageUrl; // 22
	
	@Column(columnDefinition = "VARCHAR(64)")
	private String signImageUrl; // 23
	
	@Column(columnDefinition = "DATETIME")
	private String joinDate; // 24
	
	@Column(columnDefinition = "DATETIME")
	private String beginDate; // 25
	
	@Column(columnDefinition = "DATETIME")
	private String endDate; // 26
	
	@Column(columnDefinition = "DATETIME")
	private String retireDate; // 27
	
	@Column(columnDefinition = "DATETIME")
	private String appointDate; // 28
	
	@Column(columnDefinition = "CHAR(1)")
	private String activeYn; // 29
	
	@Column(columnDefinition = "INT")
	private int updUserid; // 30
	
	@Column(columnDefinition = "DATETIME")
	private String updDate; // 31

	
}
