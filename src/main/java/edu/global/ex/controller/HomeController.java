package edu.global.ex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //import해야된다
public class HomeController {
	
	@GetMapping("/") //import해야된다
	public String home() {
		return "안녕하세요";
	}
	
	@GetMapping("/hello") //import해야된다
	public String hello() {
		return "hello..";
	}
	
	@GetMapping("/world") //import해야된다
	public String japan() {
		return "<h1>일본이다.</h1>";
	}
	

}
