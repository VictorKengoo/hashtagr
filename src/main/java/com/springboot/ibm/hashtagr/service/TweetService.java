package com.springboot.ibm.hashtagr.service;

import com.springboot.ibm.hashtagr.domain.Tweet;

public interface TweetService {
	public Tweet findTweetByHashtag(String hashtag);
	public void saveHashtag();
}
