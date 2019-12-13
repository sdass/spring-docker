package com.docker.springdocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	private UserRepository userRepository;
	
	
	  @PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String address) {

	    User n = new User();
	    n.setName(name);
	    n.setAddress(address);
	    userRepository.save(n);
	    return "Saved";
	  }	

	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<User> getAllUsers() {
	    return userRepository.findAll();
	  }	  
	
}
