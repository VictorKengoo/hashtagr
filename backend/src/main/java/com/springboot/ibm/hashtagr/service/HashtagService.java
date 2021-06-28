package com.springboot.ibm.hashtagr.service;

import java.util.Optional;

import com.springboot.ibm.hashtagr.domain.Hashtag;

public interface HashtagService {
	public Hashtag saveHashtag(Hashtag hashtag);
	public Optional<Hashtag> findHashtagById(String id);
	public void incrementHashtagReferences(String id);
	public void decrementHashtagReferences(String id);
}
