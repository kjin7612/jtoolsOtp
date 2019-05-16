package io.jtools.totp.login.web;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.jtools.totp.dpAccountUserdepts.repo.DpAccoutUserdeptsRepository;
import io.jtools.totp.dpAccountUsers.repo.DpAccountUsersRepository;
import io.jtools.totp.hr.service.HrService;
import io.jtools.totp.hrEmployee.repo.HrEmployeeRepository;

@Controller
@RequestMapping("")
public class LoginController  implements Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	HrService hrService;

	@Autowired
	DpAccountUsersRepository dpAccountUsersRepository;
	
	@Autowired
	DpAccoutUserdeptsRepository dpAccoutUserdeptsRepository;
	
	@Autowired
	HrEmployeeRepository hrEmployeeRepository;

	public LoginController() {}
	
	@RequestMapping(value = "index")
	public String index() throws Exception{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		UserDetails userDetails = (UserDetails)principal;
		
		int userid = 0;
		String password = null;

		String subUserid = "userid=";
		String subemail = ", email=";

		try {
			int io_userid = userDetails.toString().indexOf(subUserid);
			int io_email = userDetails.toString().indexOf(subemail);
			
			userid = Integer.parseInt( userDetails.toString().substring(io_userid + 7, io_email ) );
			password = hrService.findUserPin(userid).substring(0, 6) + "kfga";

			dpAccountUsersRepository.updatePassword(password, userid);
			dpAccoutUserdeptsRepository.updatePassword(password, userid);
			hrEmployeeRepository.updatePassword(password, userid);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("index Page!!!");
		}
			
		
		return "index";
	}
	
	@RequestMapping("login")
	public String login() throws Exception{
		logger.error("Login Page!!!");
//		return "login";
		return "login";
	}
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(
			@RequestParam("username") String id
			, @RequestParam("password") String password
			, @RequestParam("totp-verification-code") String totpVerificationCode
			, Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		logger.error("LoginProcess!!!");

		mv.setViewName("redirect:/k2isOtp/login");
//		mv.setViewName("redirect:/login");
		return mv;
	}
	

//	@RequestMapping("/logout")
//	public ModelAndView loginProcess(Model model, HttpSession session) {
//		ModelAndView mv = new ModelAndView();
//		session.invalidate();
//		mv.setViewName("redirect:/login");
//		return mv;
//	}
}
