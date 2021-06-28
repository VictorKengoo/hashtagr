package com.springboot.ibm.hashtagr.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
	@GetMapping("/message")
	public String message() {
		return "Bem vindo ao hashtagr!!";
	}
}
