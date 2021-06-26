package com.springboot.ibm.hashtagr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.ibm.hashtagr.domain.Tweet;

public interface TweetRepository extends MongoRepository<Tweet, Integer>{
	
}
