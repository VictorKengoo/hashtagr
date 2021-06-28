package com.springboot.ibm.hashtagr.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ibm.hashtagr.domain.Hashtag;
import com.springboot.ibm.hashtagr.domain.Response;
import com.springboot.ibm.hashtagr.service.HashtagService;

@RestController
@RequestMapping("/hashtag")
public class HashtagController {
	
	@Autowired
	private HashtagService hashtagService;
	
	@PostMapping("/new")
	public ResponseEntity<Response<Hashtag>> insertHashtag(@RequestBody Hashtag hashtag) {
		return ResponseEntity.ok(new Response<Hashtag>(this.hashtagService.saveHashtag(hashtag)));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Optional<Hashtag>>> getHashtag(@PathVariable String id) {
		return ResponseEntity.ok(new Response<Optional<Hashtag>>(this.hashtagService.findHashtagById(id)));
	}
}
