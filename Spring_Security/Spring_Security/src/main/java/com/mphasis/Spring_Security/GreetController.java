package com.mphasis.Spring_Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	@GetMapping("/hello")
	public String getMessage() {
		return "<h1> Hello All</h1>";
	}
}
