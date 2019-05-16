package io.jtools.totp.hr.domain;

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
@Table(catalog = "KFG", schema = "dbo", name = "HR_PERSON")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HrPerson implements Serializable {
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Id
	private int userid; // 1

	@Column(length = 12)
	private String userName; // 2t

	@Column(length = 32)
	private String userEngName; // 3

	@Column(length = 13)
	private String pin; // 4

	@Column(length = 11)
	private String phone; // 5

	@Column(length = 11)
	private String cellPhone; // 6

	@Column(length = 200)
	private String address; // 7

	@Column(length = 6)
	private String zipCode; // 8

	@Column(length = 64)
	private String email; // 9

	@Column(columnDefinition = "CHAR(1)")
	private String marryYn; // 10

	@Column(columnDefinition = "DATE")
	private String marryDate; // 11

	@Column(length = 5)
	private String religionCode; // 12

	@Column(length = 32)
	private String hobby; // 13

	@Column(columnDefinition = "INT")
	private int updUserid; // 14

	@Column(columnDefinition = "DATETIME")
	private String updDate; // 15

	
}
