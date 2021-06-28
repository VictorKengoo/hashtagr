package com.springboot.ibm.hashtagr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.ibm.hashtagr.domain.Hashtag;

public interface HashtagRepository extends MongoRepository<Hashtag, String>{
	
}
