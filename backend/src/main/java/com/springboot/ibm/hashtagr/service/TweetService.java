package com.springboot.ibm.hashtagr.service;

import java.util.List;

import com.springboot.ibm.hashtagr.domain.Tweet;

public interface TweetService {
	public List<Tweet> findTweetByHashtag(String hashtag);
}
