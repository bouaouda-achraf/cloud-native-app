package com.example.demo;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.ConfigurationProjectProperties;

@SpringBootApplication
// @EnableConfigurationProperties
public class JavaNativeApplication {
	private final Log log = LogFactory.getLog(getClass());

	public static void main(String[] args) {
		SpringApplication.run(JavaNativeApplication.class, args);
	}
	
	@RefreshScope
	@RestController
	class MessageRestController {

	  @Value("${message:Hello default}")
	  private String message;

	  @RequestMapping("/message")
	  String getMessage() {
	    return this.message;
	  }
	}

	@Autowired
	public JavaNativeApplication(ConfigurationProjectProperties cp) {
		log.info("configurationProjectProperties.projectName = " + cp.getProjectName());
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				// System.out.println(beanName);
			}

		};
	}

}
