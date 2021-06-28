package com.springboot.ibm.hashtagr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.social.twitter.api.Twitter;

import com.springboot.ibm.hashtagr.domain.TweetMS;

public interface TweetService {
	public Optional<TweetMS> findTweetById(String id);
	public TweetMS postTweet(TweetMS tweet);
	public String deleteTweetById(String id);
	public TweetMS deleteTweet(TweetMS tweet);
	public List<TweetMS> findTweets(String hashtag);
	public List<TweetMS> findTweetsAndReTweets(String hashtag);
}
