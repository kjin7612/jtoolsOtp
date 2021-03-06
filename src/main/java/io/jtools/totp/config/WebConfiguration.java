package io.jtools.totp.config;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter implements Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	private Logger logger = LoggerFactory.getLogger(WebConfiguration.class); 


	public WebConfiguration() {	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**"
                , "/img/**"
                , "/css/**"
                , "/js/**"
                , "/bower_components/**"
        		)
        .addResourceLocations(
                "classpath:/META-INF/resources/webjars/"
                , "classpath:/static/img/"
                , "classpath:/static/css/"
                , "classpath:/static/js/"
                , "classpath:/static/bower_components/"
        		)
        .addResourceLocations(
                "classpath:/static/img/**"
                , "classpath:/static/css/**"
                , "classpath:/static/js/**"
                , "classpath:/static/bower_components/**"
        		);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        
        logger.error("addViewControllers Error");
	}
}
