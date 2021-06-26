package com.springboot.ibm.hashtagr.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hashtag")
public class HashtagController {
	
	@PostMapping("/new")
	public void insertHashtag() {
		
	}
}
