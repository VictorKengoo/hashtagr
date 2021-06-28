package com.springboot.ibm.hashtagr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TweetMS {

	private Long tweetId;
	
	private String userName;
	
    private String body;
    
	public String hashtag;
	
	public String position;
}
