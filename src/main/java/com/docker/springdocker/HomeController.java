package com.docker.springdocker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/hi")
	public String sayHello(){
		log.info("sayHello()... ");
		return "say hi";
	}
	
}
