package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
class ProjectNameRestController {
	@Value("${configuration.projetName}")
	private String projectName;

	@RequestMapping("/project-name")
	String projectName() {
		return this.projectName;
	}
}