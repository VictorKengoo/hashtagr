package com.springboot.ibm.hashtagr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import com.springboot.ibm.hashtagr.domain.TweetMS;
import com.springboot.ibm.hashtagr.repository.TweetRepository;
import com.springboot.ibm.hashtagr.service.TweetService;

@Service
public class TweetServiceImpl implements TweetService{
	
	@Autowired
	private TweetRepository tweetRepository;
	
	@Autowired
	TweetUtils tweetUtils;
	
	@Override
	public List<TweetMS> findTweets(String hashtag) {
		List<Tweet> result = tweetUtils.fetchTweets(hashtag);
		List<TweetMS> tweets = tweetUtils.buildTweets(result, hashtag);		
		return tweets;
	}
	
	@Override
	public List<TweetMS> findTweetsAndReTweets(String hashtag) {		
		List<Tweet> result = tweetUtils.fetchTweets(hashtag);
		List<TweetMS> tweets = tweetUtils.buildTweetsAndRetweets(result, hashtag);
		
		return tweets;
	}

	@Override
	public Optional<TweetMS> findTweetById(String id) {
		try {
			return this.tweetRepository.findById(id);
			
		} catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Hashtag has never been tweeted");
		}
	}

	@Override
	public TweetMS postTweet(TweetMS tweet) {
		this.tweetRepository.insert(tweet);
		return tweet;
	}

	@Override
	public String deleteTweetById(String id) {
		this.tweetRepository.deleteById(id);
		return "Tweet with Id: {" + id + "} successfully deleted!";
	}

	@Override
	public TweetMS deleteTweet(TweetMS tweet) {
		this.tweetRepository.delete(tweet);
		return tweet;
	}
}