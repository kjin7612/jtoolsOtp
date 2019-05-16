package io.jtools.totp.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.Serializable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import io.jtools.totp.App;
import io.jtools.totp.gauth.domain.GAuth;
import io.jtools.totp.gauth.service.GAuthService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=App.class)
@WebAppConfiguration
public class GAuthServiceTest implements Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Autowired
	GAuthService userService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	public void addUser() {
		String email = "xxxx@xxx.com"; // 테스트 할떄 변경하세요.
		String rawPassword ="01012341234";
		GAuth user = userService.insert(GAuth.builder().email(email).plainPassword(rawPassword).build());
		
		assertThat(passwordEncoder.matches(rawPassword, user.getPassword()), is(true));
	}

}
