package io.jtools.totp.gauth.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;
import com.warrenstrange.googleauth.IGoogleAuthenticator;

import io.jtools.totp.gauth.domain.GAuth;
import io.jtools.totp.gauth.repo.GAuthRepository;
import io.jtools.totp.infra.mail.domain.MailMessage;
import io.jtools.totp.infra.mail.service.MailService;
import lombok.Setter;

@Service
public class GAuthServiceImpl implements GAuthService, Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	private static final String ISSUER = "KFG_OTP_인증";

	public GAuthServiceImpl() {
	}
	
	@Setter
	@Autowired
	GAuthRepository gAuthRepository;
	
	@Setter
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Setter
	@Autowired
	IGoogleAuthenticator googleAuthenticator;
	
	@Setter
	@Autowired
	MailService mailService;
	
	@Override
	public Long userSelctEmailForAuth(String email) {
		return gAuthRepository.userSelctEmailForAuth(email);
	}
	
	@Override
	public GAuth insert(GAuth gAuth) {
		GoogleAuthenticatorKey key = googleAuthenticator.createCredentials();
		sendTOTPRegistrationMail(gAuth, key);
		gAuth.setOtpSecretKey(key.getKey());
		
		encodePassword(gAuth);

		return gAuthRepository.save(gAuth);
	}

	private void sendTOTPRegistrationMail(GAuth user, GoogleAuthenticatorKey key) {
		String qrCodeUrl = GoogleAuthenticatorQRGenerator.getOtpAuthURL(ISSUER, user.getUsername(), key);
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("qrCodeUrl", qrCodeUrl);
		
		MailMessage mailMessage = MailMessage.builder()
				.templateName(MailMessage.OTP_REGISTRATION)
				.to(new String[]{user.getUsername()})
				.subject("KFG TOTP Registration mail")
				.attributes(attributes)
				.build();
		mailService.send(mailMessage);
	}

	private void encodePassword(GAuth gAuth) {
		if(StringUtils.hasText(gAuth.getPlainPassword())) {
			gAuth.setPassword(passwordEncoder.encode(gAuth.getPlainPassword()));
		}
	}

	@Override
	public GAuth update(GAuth gAuth) {
		encodePassword(gAuth);
		return gAuthRepository.save(gAuth);
	}
	
	@Override
	public void delete(GAuth gAuth) {
		gAuthRepository.delete(gAuth);
	}
	
	@Override
	public void deleteUserbyEmail(String email) {
		gAuthRepository.deleteUserbyEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		GAuth user = gAuthRepository.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException(email + " is not found");
		}
		return user;
	}

}
