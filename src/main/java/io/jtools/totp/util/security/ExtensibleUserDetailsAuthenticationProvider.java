package io.jtools.totp.util.security;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import com.warrenstrange.googleauth.IGoogleAuthenticator;

import io.jtools.totp.dpAccountUserdepts.service.DpAccountUsersdeptsService;
import io.jtools.totp.dpAccountUsers.service.DpAccountUsersService;
import io.jtools.totp.gauth.domain.GAuth;
import io.jtools.totp.gauth.service.GAuthService;
import io.jtools.totp.hr.service.HrService;
import io.jtools.totp.hrEmployee.service.HrEmployeeService;
import io.jtools.totp.userAuth.domain.UserAuth;
import io.jtools.totp.userAuth.service.copy.UserAuthService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExtensibleUserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider implements Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	private static final Logger logger = LoggerFactory.getLogger(ExtensibleUserDetailsAuthenticationProvider.class);

	@Setter
    private PasswordEncoder passwordEncoder;
 
	@Setter
    private UserDetailsService userDetailsService;
    
	@Setter
    private UserDetailsChecker loginPostUserDetailsChecker;
    
	@Setter
    private IGoogleAuthenticator authenticator;
	
	@Setter
	private DpAccountUsersService dpAccountUsersService;
    
	@Setter
	private DpAccountUsersdeptsService dpAccountUsersdeptsService;
	
	@Setter
	private HrEmployeeService hrEmployeeService;
    
	@Autowired
	GAuthService gAuthService;
	
	@Autowired
	UserAuthService userAuthService;
	
	@Autowired
	HrService hrService;
	
	public ExtensibleUserDetailsAuthenticationProvider() {}
	
	@Override
	protected void additionalAuthenticationChecks(
			UserDetails userDetails
			, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		log.info("additionalAuthenticationChecks: username={}", userDetails.getUsername());
		log.info("additionalAuthenticationChecks: userDetails={}", userDetails);
		
      
		if (authentication.getCredentials() == null) {
            log.error("Authentication failed: no credentials provided.");
            throw new BadCredentialsException("No Credentials");
        }
		
		
        String credentialsPassword = authentication.getCredentials().toString();
        if (!passwordEncoder.matches(credentialsPassword, userDetails.getPassword())) {
            log.error("Authentication failed: password does not match stored value.");
            throw new BadCredentialsException("BadCredentials");
        }
        
        logger.error("additionalAuthenticationChecks");
        
	}

	/**
	 * 사용자의 전화번호가 DB에 등록되어 있으면
	 * 요청된 email로 메일 전송
	 */
	@Override
	protected UserDetails retrieveUser(
			String username
			, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		
		log.debug("retrieveUser: {}", username);
		
        TOTPUserDetails retrieveUser = null;
        GAuth gauth;
        
        String email = null;
        String password = null;
        String cellPhone = null;
        String userid = null;
        String findUserActive = null;
        Long authNum = 0l;
       
        try {
        	password = authentication.getCredentials().toString();
        	email = authentication.getPrincipal().toString();
        	cellPhone = hrService.findCellPhone(password);
        	userid = hrService.findUserid(cellPhone);
            Integer verificationCode = ((TOTPWebAuthenticationDetails) authentication.getDetails()).getTotpKey();
            
            findUserActive = hrEmployeeService.findUserActive(Integer.parseInt(userid));
            
            if( !findUserActive.equals("Y")){
            	throw new InternalAuthenticationServiceException("퇴사하거나 정상적인 사용자가 아닙니다.");
            }

        	if( email != null && password != null && verificationCode == null  ){
        		// 신규인증번호 및 메일 요청
        		
           		/**
        		 * 기존 정보 삭제(인증 Table)
        		 */
        		gAuthService.deleteUserbyEmail(email);
        		
        		/**
        		 * email 전송 및 Table Insert
        		 */
        		gauth = gAuthService.insert(GAuth.builder().email(email).plainPassword(password).userid(Integer.parseInt(userid)).build());
        		
           		/**
        		 * 이메일 전송
        		 * 권한 Matching Table에 Insert
        		 */
           		authNum = gAuthService.userSelctEmailForAuth(email);
           		
           		/**
           		 * 권한 Table에 ID 입력
           		 */
           		userAuthService.insert(UserAuth.builder().id(authNum).authorities(null).build());

        		log.debug("USER INSERT: {}", gauth);
        		
        		throw new InternalAuthenticationServiceException("이메일이 전송되었습니다.");
                
        	}else if( email != null && cellPhone != null && verificationCode != null ){
	            retrieveUser = (TOTPUserDetails) userDetailsService.loadUserByUsername(email);
	            if (retrieveUser == null) {
	//                throw new InternalAuthenticationServiceException("UserDetails returned null.");
	                throw new InternalAuthenticationServiceException("사용자가 등록되지 않았습니다.");
	            }
	            
	            if(!StringUtils.hasText(retrieveUser.getSecretKey())) {
	//            	throw new BadCredentialsException("User don't registry TOTP.");
	            	throw new BadCredentialsException("TOTP가 등록되지 않았습니다.");
	            }
	            
	            if (!authenticator.authorize(retrieveUser.getSecretKey(), verificationCode)) {
	//            		throw new BadCredentialsException("Invalid VerificationCode");
					throw new BadCredentialsException("잘못된 인증번호 입니다.");
				}

        	}
        	
        } catch (UsernameNotFoundException notFoundException) {
            if (hideUserNotFoundExceptions) {
                throw new BadCredentialsException("Bad Credentials.");
            }
            throw notFoundException;
        } catch (Exception authenticationProblem) {
            throw new InternalAuthenticationServiceException(authenticationProblem.getMessage(), authenticationProblem);
        }
        logger.error("UserDetails");

        return retrieveUser;
	}



}
