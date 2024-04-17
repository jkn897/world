package com.howtodoinjava.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Configuration
@PropertySource(value = "classpath:error-messages.properties", ignoreResourceNotFound = true)
public class CustomPropertiesReadConfig implements InitializingBean {

	@Value("${AUTHENTICATION_FAILED}")
	private String authenticationFailedMsg;

	@Value("${SESSION_EXPIRED}")
	private String sessionExpiredMsg;

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("authentication msg : " + authenticationFailedMsg);
		log.info("session expired msg : " + sessionExpiredMsg);
	}
}