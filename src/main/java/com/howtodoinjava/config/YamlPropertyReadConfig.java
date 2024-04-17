package com.howtodoinjava.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "multidatasource")
public class YamlPropertyReadConfig {
	private Map<String, Object> databases;
}
