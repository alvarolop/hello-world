package com.redhat.es.consulting.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${controller.greeting}")
	private String greeting;
	
	@RequestMapping("/hola")
	  public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
		String hostname = System.getenv().getOrDefault("HOSTNAME", "Unknown");
        return String.format("%s %s desde %s ", greeting, name, hostname) + System.lineSeparator();
	  }
}