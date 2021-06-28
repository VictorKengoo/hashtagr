package com.springboot.ibm.hashtagr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.ibm.hashtagr.domain.TweetMS;

public interface TweetRepository extends MongoRepository<TweetMS, String>{
	List<TweetMS> findTweetByHashtag(String hashtag);
}
