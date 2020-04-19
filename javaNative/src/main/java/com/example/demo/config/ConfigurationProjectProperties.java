package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties("configuration")
public class ConfigurationProjectProperties {
	private String messageBean;

	public String getMessageBean() {
		return messageBean;
	}

	public void setMessageBean(String messageBean) {
		this.messageBean = messageBean;
	}
	
}