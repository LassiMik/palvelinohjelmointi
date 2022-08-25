package com.example.helloworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//Controller annotaatio tarvitaan, jotta luokka ymmärtää olla 
//Controlleri eli konepellin alla siellä on mm servlet

//Responsebody annotaatio tarkoittaa, että freimis
//Näyttää returnissa mainitun tekstin tai olion näytöllä
@Controller
@ResponseBody
public class HelloController {
	//REQUEST MAPPING ANNOTAATIOLLA SIDOTAAN KOODI TIETTYYN
	//ENDPOINTTIIN WILDCARD * TARKOITTAA ETTÄ KAIKKI TÄHÄN 
	@RequestMapping("/hello")
	public String hello(@RequestParam(name="location") String location, @RequestParam(name="name") String name) {
		return "Welcome to the "+location+" "+name+"!";
	}
	@RequestMapping("/index") 
	public String main() {
		return "This is the main page";
	}
	@RequestMapping("/contact")
	public String contact() {
		return "This is the contact page";
	}
}
