package com.springboot.ibm.hashtagr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ibm.hashtagr.domain.Tweet;
import com.springboot.ibm.hashtagr.repository.TweetRepository;
import com.springboot.ibm.hashtagr.service.TweetService;

@Service
public class TweetServiceImpl implements TweetService{

	@Autowired
	private TweetRepository tweetRepository;
	
	@Override
	public List<Tweet> findTweetByHashtag(String hashtag) {
		return this.tweetRepository.findTweetByHashtag(hashtag);
	}	
}