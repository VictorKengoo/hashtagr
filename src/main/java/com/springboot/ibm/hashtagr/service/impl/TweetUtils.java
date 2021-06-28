package com.springboot.ibm.hashtagr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;

import com.springboot.ibm.hashtagr.domain.TweetMS;

@Component
public class TweetUtils {	
	
	@Value("${twitter.consumerKey}")
	private String consumerKey; // The application's consumer key
	
	@Value("${twitter.consumerSecret}")
	private String consumerSecret; // The application's consumer secret
	
	@Value("${twitter.accessToken}")
	private String accessToken; // The access token granted after OAuth authorization
	
	@Value("${twitter.accessTokenSecret}")
	private String accessTokenSecret; // The access token secret granted after OAuth authorization
	
	public List<Tweet> fetchTweets(String hashtag) {
		Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		String parsedHashtag = "#" + hashtag;
		SearchParameters params = new SearchParameters(parsedHashtag).count(500);
		List<Tweet> result = twitter.searchOperations().search(params).getTweets();
		
		return result;
	}
	
	public TweetMS buildTweet(Tweet item, String hashtag) {
		TweetMS tweetMS = new TweetMS();
		
		tweetMS.setTweetId(Long.parseLong(item.getIdStr()));
		tweetMS.setUserName("@" + item.getFromUser());
		tweetMS.setHashtag("#" + hashtag);
		tweetMS.setBody(item.getText());
		tweetMS.setPosition(item.getUser().getLocation());
		
		return tweetMS;
	}
	
	public List<TweetMS> buildTweets(List<Tweet> result, String hashtag) {
		List<TweetMS> tweets = new ArrayList<TweetMS>();
		
		for(Tweet item : result) {
			if(!item.isRetweet()) {
				tweets.add(buildTweet(item, hashtag));
			}			
		}
		return tweets;
	}	

	public List<TweetMS> buildTweetsAndRetweets(List<Tweet> result, String hashtag) {	
		List<TweetMS> tweets = new ArrayList<TweetMS>();
		
		for(Tweet item : result) {
			tweets.add(buildTweet(item, hashtag));						
		}
		
		return tweets;
	}

}
