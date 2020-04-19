package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.ConfigurationProjectProperties;

@RestController
public class HelloController {
	
	@Autowired
	private ConfigurationProjectProperties configurationProjectProperties;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot! + "+configurationProjectProperties.getMessageBean();
	}
	
	public ConfigurationProjectProperties getConfigurationProjectProperties() {
		return configurationProjectProperties;
	}

	public void setConfigurationProjectProperties(ConfigurationProjectProperties configurationProjectProperties) {
		this.configurationProjectProperties = configurationProjectProperties;
	}

}