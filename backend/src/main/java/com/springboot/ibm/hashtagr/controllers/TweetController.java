package com.springboot.ibm.hashtagr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ibm.hashtagr.service.TweetService;

@RestController
@RequestMapping("/tweet")
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	
	@GetMapping("/tweets/{hashtag}")
	public String getTweetsByHashtag(@PathVariable String hashtag) {
		return null;
	}
}
