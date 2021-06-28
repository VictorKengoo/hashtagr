package com.springboot.ibm.hashtagr.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
	
	private T data;
	private List<String> errors;
	
	public Response(T data) {
		this.data = data;
	}
	
	public Response(List<String> errors) {
		this.errors = errors;
	}
}