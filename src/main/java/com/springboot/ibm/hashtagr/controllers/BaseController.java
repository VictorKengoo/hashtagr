package com.springboot.ibm.hashtagr.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tweets")
public class BaseController {
	
	@GetMapping("/{hashtag}")
	public String getTweets(@PathVariable String hashtag) {
		return null;
	}
}
