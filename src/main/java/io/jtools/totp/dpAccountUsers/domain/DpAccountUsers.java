package io.jtools.totp.dpAccountUsers.domain;

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
@Table(catalog = "DESKPLUSEIP", schema = "dbo", name = "DP_ACCOUNT_USERS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DpAccountUsers implements Serializable {
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Id
	private int userid; // 1

	@Column(columnDefinition = "NVARCHAR(20)")
	private String usercode; // 2

	@Column(columnDefinition = "NVARCHAR(50)")
	private String loginid; // 3

	@Column(columnDefinition = "INT")
	private int companyid; // 4

	@Column(columnDefinition = "NVARCHAR(20)")
	private String name; // 5

	@Column(columnDefinition = "NVARCHAR(50)")
	private String englishname; // 6

	@Column(columnDefinition = "NVARCHAR(50)")
	private String chinesename; // 7

	@Column(columnDefinition = "NVARCHAR(100)")
	private String manyname; // 8

	@Column(columnDefinition = "NVARCHAR(30)")
	private String password; // 9

	@Column(columnDefinition = "DATETIME")
	private String passwordupdatedate; // 10

	@Column(columnDefinition = "NVARCHAR(50)")
	private String employeenumber; // 11

	@Column(columnDefinition = "NVARCHAR(50)")
	private String registrationnumber; // 12

	@Column(columnDefinition = "CHAR(1)")
	private String sex; // 13

	@Column(columnDefinition = "CHAR(1)")
	private String lunar; // 14

	@Column(columnDefinition = "NVARCHAR(20)")
	private String birthday; // 15

	@Column(columnDefinition = "NVARCHAR(180)")
	private String description; // 16

	@Column(columnDefinition = "NVARCHAR(180)")
	private String homezipcode; // 17

	@Column(columnDefinition = "NVARCHAR(100)")
	private String homeaddress1; // 18

	@Column(columnDefinition = "NVARCHAR(100)")
	private String homeaddress2; // 19

	@Column(columnDefinition = "NVARCHAR(50)")
	private String birthzipcode; // 20

	@Column(columnDefinition = "NVARCHAR(100)")
	private String birthaddress1; // 21

	@Column(columnDefinition = "NVARCHAR(100)")
	private String birthaddress2; // 22

	@Column(columnDefinition = "NVARCHAR(20)")
	private String mobilephone; // 23

	@Column(columnDefinition = "NVARCHAR(20)")
	private String homephone; // 24

	@Column(columnDefinition = "NVARCHAR(20)")
	private String officephone; // 25

	@Column(columnDefinition = "NVARCHAR(10)")
	private String extensionofficephone; // 26

	@Column(columnDefinition = "NVARCHAR(20)")
	private String fax; // 27

	@Column(columnDefinition = "VARCHAR(20)")
	private int ipphone; // 28

	@Column(columnDefinition = "CHAR(10)")
	private String joindate; // 29

	@Column(columnDefinition = "CHAR(10)")
	private String retiredate; // 30

	@Column(columnDefinition = "NVARCHAR(100)")
	private String sealimage; // 31

	@Column(columnDefinition = "NVARCHAR(100)")
	private String photoimage; // 32

	@Column(columnDefinition = "INT")
	private int mailquota; // 33

	@Column(columnDefinition = "INT")
	private int privatequota; // 34

	@Column(columnDefinition = "NVARCHAR(100)")
	private String securityapproval; // 35

	@Column(columnDefinition = "NVARCHAR(100)")
	private String securitylogin; // 36

	@Column(columnDefinition = "NVARCHAR(20)")
	private String mailid; // 37

	@Column(columnDefinition = "NVARCHAR(30)")
	private String maildomain; // 38

	@Column(columnDefinition = "NVARCHAR(30)")
	private String mailpassword; // 39

	@Column(columnDefinition = "CHAR(1)")
	private String activeuser; // 40

	@Column(columnDefinition = "DATETIME")
	private String weddinganniversary; // 41

	@Column(columnDefinition = "INT")
	private int writeuserid; // 42

	@Column(columnDefinition = "DATETIME")
	private String writedate; // 43

	@Column(columnDefinition = "INT")
	private int modifyuserid; // 44

	@Column(columnDefinition = "DATETIME")
	private String modifydate; // 45

	@Column(columnDefinition = "CHAR(12)")
	private String ip; // 46

	@Column(columnDefinition = "INT")
	private int ipcount; // 47

}
