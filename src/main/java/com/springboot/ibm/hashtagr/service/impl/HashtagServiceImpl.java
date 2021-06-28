package com.springboot.ibm.hashtagr.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ibm.hashtagr.domain.Hashtag;
import com.springboot.ibm.hashtagr.domain.TweetMS;
import com.springboot.ibm.hashtagr.repository.HashtagRepository;
import com.springboot.ibm.hashtagr.repository.TweetRepository;
import com.springboot.ibm.hashtagr.service.HashtagService;

@Service
public class HashtagServiceImpl implements HashtagService{

	@Autowired
	private HashtagRepository hashtagRepository;
	
	@Autowired
	private TweetRepository tweetRepository;
	
	@Override
	public Hashtag saveHashtag(Hashtag hashtag) {
		this.hashtagRepository.save(hashtag);
		return hashtag;
	}

	@Override
	public Optional<Hashtag> findHashtagById(String id) {
		return this.hashtagRepository.findById(id);
	}

	@Override
	public void incrementHashtagReferences(String id) {
		Optional<Hashtag> hashtag = hashtagRepository.findById(id);
		hashtag.get().setTweetReferences(hashtag.get().getTweetReferences() + 1);
		this.hashtagRepository.save(hashtag.get());
	}

	@Override
	public void decrementHashtagReferences(String tweetId) {
		Optional<TweetMS> tweet = tweetRepository.findById(tweetId);
		Optional<Hashtag> hashtag = hashtagRepository.findById(tweet.get().getHashtag());		
		hashtag.get().setTweetReferences(hashtag.get().getTweetReferences() - 1);
		this.hashtagRepository.save(hashtag.get());		
	}	
}