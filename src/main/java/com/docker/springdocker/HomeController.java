package com.docker.springdocker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

	
	Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/hi")
	public String sayHello(){
		log.info("sayHello()... ");
		return "say hi";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public String getjson(){
		String url = "http://jsonplaceholder.typicode.com/todos/4"; //outside world
		log.info("getjson()... ");
		String json = restTemplate.getForObject(url, String.class);
		System.out.println("json=" + json);
		return json;
	}
	
	
}
