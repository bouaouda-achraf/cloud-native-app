package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
class ProjectNameRestController {
	private final String projectName;

	@Autowired
	public ProjectNameRestController(@Value("${configuration.projectName}") String pn) {
		this.projectName = pn;
	}

	@RequestMapping("/project-name")
	String projectName() {
		return this.projectName;
	}
}