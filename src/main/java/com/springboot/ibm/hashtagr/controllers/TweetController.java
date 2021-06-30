package com.springboot.ibm.hashtagr.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ibm.hashtagr.domain.Response;
import com.springboot.ibm.hashtagr.domain.TweetMS;
import com.springboot.ibm.hashtagr.service.HashtagService;
import com.springboot.ibm.hashtagr.service.TweetService;

@RestController
@RequestMapping("/tweet")
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	
	@Autowired
	private HashtagService hashtagService;
	
	@GetMapping("/api/tweets/{hashtag}")
	public ResponseEntity<Response<List<TweetMS>>> getTweetsFromTwitterApi(@PathVariable String hashtag) {
		return ResponseEntity.ok(new Response<List<TweetMS>>(this.tweetService.findTweets(hashtag)));
	}
	
	@GetMapping("/api/tweetsAndReTweets/{hashtag}")
	public ResponseEntity<Response<List<TweetMS>>> getTweetsAndReTweetsFromTwitterApi(@PathVariable String hashtag) {
		return ResponseEntity.ok(new Response<List<TweetMS>>(this.tweetService.findTweetsAndReTweets(hashtag)));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Optional<TweetMS>>> getTweetById(@PathVariable String id) {
		return ResponseEntity.ok(new Response<Optional<TweetMS>>(this.tweetService.findTweetById(id)));
	}
	
	@PostMapping("/new")
	public ResponseEntity<Response<TweetMS>> postTweet(@RequestBody TweetMS tweet){		
		hashtagService.incrementHashtagReferences(tweet.hashtag);
		return ResponseEntity.ok(new Response<TweetMS>(this.tweetService.postTweet(tweet)));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response<String>> deleteTweetById(@PathVariable String id){		
		hashtagService.decrementHashtagReferences(id);
		return ResponseEntity.ok(new Response<String>(this.tweetService.deleteTweetById(id)));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Response<TweetMS>> deleteTweet(@RequestBody TweetMS tweet){		
		hashtagService.decrementHashtagReferences(tweet.hashtag);
		return ResponseEntity.ok(new Response<TweetMS>(this.tweetService.deleteTweet(tweet)));
	}
}
