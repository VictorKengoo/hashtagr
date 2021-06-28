package com.springboot.ibm.hashtagr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

public class Config {
	@Value("${twitter.consumerKey:}")
	private static String consumerKey = ""; // The application's consumer key
	
	@Value("${twitter.consumerSecret:}")
	private static String consumerSecret = ""; // The application's consumer secret
	
	@Value("${twitter.accessToken:}")
	private static String accessToken = ""; // The access token granted after OAuth authorization
	
	@Value("${twitter.accessTokenSecret:}")
	private static String accessTokenSecret = ""; // The access token secret granted after OAuth authorization
	
	public static void main(String[] args){
		
		Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		
		SearchResults result = twitter.searchOperations().search("#springboot");
		
		System.out.print(result.getTweets().toString());
		
	}
}