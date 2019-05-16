package io.jtools.totp;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.security.core.SpringSecurityCoreVersion;

//mainClassName = 'io.jtools.totp.App'
@SpringBootApplication(exclude = { ThymeleafAutoConfiguration.class })
public class App extends SpringBootServletInitializer implements Serializable {
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	private Logger logger = LoggerFactory.getLogger(App.class); 

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		logger.debug("");
		return builder.sources(App.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
