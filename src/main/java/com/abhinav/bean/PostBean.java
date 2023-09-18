package com.abhinav.bean;

import com.fasterxml.jackson.databind.JsonNode;

public class PostBean {
	private Integer postId;
	private String title;
	private String body;
	private Integer userId;
	private Integer reactions;
	public Integer getPostId() {
		return postId;
	}
	public String getTitle() {
		return title;
	}
	public String getBody() {
		return body;
	}
	public Integer getUserId() {
		return userId;
	}
	public Integer getReactions() {
		return reactions;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public PostBean(JsonNode post) {
		super();
		this.postId = post.get("id").asInt();
		this.title = post.get("title").asText();
		this.body = post.get("body").asText();
		this.userId = post.get("userId").asInt();
		this.reactions = post.get("reactions").asInt();
	}
	
	public PostBean(Integer id, String title, String body, Integer userId) {
		super();
		this.postId = id;
		this.title = title;
		this.body = body;
		this.userId = userId;
		this.reactions = 0;
	}
	
	

}
