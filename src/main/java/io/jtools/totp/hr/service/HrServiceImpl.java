package io.jtools.totp.hr.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.warrenstrange.googleauth.IGoogleAuthenticator;

import io.jtools.totp.hr.domain.HrPerson;
import io.jtools.totp.hr.repo.HrPersonRepository;
import lombok.Setter;

@Service
@Transactional
public class HrServiceImpl implements HrService, Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Setter
	@Autowired
	HrPersonRepository hrPersonRepository;
	
	@Setter
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Setter
	@Autowired
	IGoogleAuthenticator googleAuthenticator;
	
	public HrServiceImpl() {}
	
	@Override
	public String findUserPin(int userid) {
		return hrPersonRepository.findUserPin(userid);
	}
	
	@Override
	public List<HrPerson> findAll() {
		return hrPersonRepository.findAll();
	}

	@Override
	public String findUserid(String cellPhone) {
		return hrPersonRepository.findUserid(cellPhone);
	}
	
	@Override
	public String findCellPhone(String cellPhone) {
		return hrPersonRepository.findCellPhone(cellPhone);
	}
	
	@Override
	public HrPerson insert(HrPerson hrPserson) {
		return hrPersonRepository.save(hrPserson);
	}

	@Override
	public HrPerson update(HrPerson hrPserson) {
		return hrPersonRepository.save(hrPserson);
	}

	@Override
	public void delete(HrPerson hrPserson) {
		hrPersonRepository.delete(hrPserson);
		
	}



	@Override
	public HrPerson getNewPassword(int userid) {
		return hrPersonRepository.getNewPassword(userid);
//		return null;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public GAuth insert(GAuth gAuth) {
//		GoogleAuthenticatorKey key = googleAuthenticator.createCredentials();
//		sendTOTPRegistrationMail(gAuth, key);
//		gAuth.setOtpSecretKey(key.getKey());
//		
//		encodePassword(gAuth);
//		return gAuthRepository.save(gAuth);
//	}
//
//	private void sendTOTPRegistrationMail(GAuth gAuth, GoogleAuthenticatorKey key) {
//		String qrCodeUrl = GoogleAuthenticatorQRGenerator.getOtpAuthURL(ISSUER, gAuth.getUsername(), key);
//		Map<String, Object> attributes = new HashMap<>();
//		attributes.put("qrCodeUrl", qrCodeUrl);
//		
//		MailMessage mailMessage = MailMessage.builder()
//				.templateName(MailMessage.OTP_REGISTRATION)
//				.to(new String[]{gAuth.getUsername()})
//				.subject("KFG TOTP Registration mail")
//				.attributes(attributes)
//				.build();
//		mailService.send(mailMessage);
//	}
//
//	private void encodePassword(GAuth gAuth) {
//		if(StringUtils.hasText(gAuth.getPlainPassword())) {
//			gAuth.setPassword(passwordEncoder.encode(gAuth.getPlainPassword()));
//		}
//	}
//
//	@Override
//	public GAuth update(GAuth gAuth) {
//		encodePassword(gAuth);
//		return gAuthRepository.save(gAuth);
//	}
//
//	@Override
//	public void delete(GAuth user) {
//		gAuthRepository.delete(user);
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		GAuth gAuth = gAuthRepository.findByEmail(email);
//		if(gAuth == null) {
//			throw new UsernameNotFoundException(email + " is not found");
//		}
//		return gAuth;
//	}

}
