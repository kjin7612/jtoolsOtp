package io.jtools.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public void ecode(String inputPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String rawPassword = "1234";
		String encodedPassword = passwordEncoder.encode(inputPassword);
		passwordEncoder.matches(inputPassword, encodedPassword);
//		assertTrue(passwordEncoder.matches(inputPassword, encodedPassword));
//		System.out.println(">> " + encodedPassword);
		
	}
	
}
