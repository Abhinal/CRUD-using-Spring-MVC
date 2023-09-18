package com.abhinav.bean;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.databind.JsonNode;

public class PostManagerBean {
	private List<PostBean> allPosts = new ArrayList<>();
	Integer nextId = 1;
	
	public List<PostBean> getAllPosts() {
		return allPosts;
	}
	
	public void deletePost(Integer id) {
		for (PostBean post : allPosts) {
			if (Objects.equals(post.getPostId(), id)) {
		        allPosts.remove(post);
		        break;
			}
		}
	}
	
	public PostBean getPost(Integer id) {
		for (PostBean post : allPosts) {
			if (Objects.equals(post.getPostId(), id)) {
		        return post;
			}
		}
		return null;
	}
	
	public void addPost(PostBean post) {
		this.nextId++;
		this.allPosts.add(0, post);
	}
	
	public int getUniqueId() {
		return nextId;
	}

	public PostManagerBean(JsonNode data) {
		super();
		JsonNode posts = data.get("posts");
		for(JsonNode post: posts) {
			this.addPost(new PostBean(post));
		}
	}
}


