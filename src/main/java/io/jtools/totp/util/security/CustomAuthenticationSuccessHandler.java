package io.jtools.totp.util.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import io.jtools.totp.dpAccountUsers.service.DpAccountUsersService;
import io.jtools.totp.hr.service.HrService;

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	@Autowired
	DpAccountUsersService dpAccountUsersService;
	
	@Autowired
	HrService hrService;

//	public CustomAuthenticationSuccessHandler(DpAccountUsersService dpAccountUsersService) {
//		this.dpAccountUsersService = dpAccountUsersService;
//	}
	

	@Override 
	public void onAuthenticationSuccess(
			HttpServletRequest httpServletRequest
			, HttpServletResponse httpServletResponse
			, Authentication authentication) throws IOException, ServletException { // 로그인 성공시 실패 카운트 초기화 
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		UserDetails userDetails = (UserDetails)principal;

		int userid = 0;
		String userBirth = null;

		String subUserid = "userid=";
		String subemail = ", email=";
		String password = null;
		int io_userid = userDetails.toString().indexOf(subUserid);
		int io_email = userDetails.toString().indexOf(subemail);
		
		userid = Integer.parseInt( userDetails.toString().substring(io_userid + 7, io_email ) );
		userBirth = hrService.findUserPin(userid).substring(0, 6);
		
		password = userBirth + "kfga";
		
		dpAccountUsersService.updatePassword(password, userid);
		super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication); 
	}

}
