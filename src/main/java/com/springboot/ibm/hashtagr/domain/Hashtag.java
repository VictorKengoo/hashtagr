package com.springboot.ibm.hashtagr.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Document
@Data
public class Hashtag {
	
	@Id
	private String code;
	
	private Integer tweetReferences;
}