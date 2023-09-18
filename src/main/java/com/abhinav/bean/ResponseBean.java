package com.abhinav.bean;

import com.fasterxml.jackson.databind.JsonNode;

public class ResponseBean {
	private static Integer id;
	private static String username;
	private static String email;
	private static String firstName;
	private static String lastName;
	private static String gender;
	private static String image;
	private static String token;

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getImage() {
		return image;
	}

	public String getToken() {
		return token;
	}
	
	public ResponseBean() {
		
	}

	public ResponseBean(JsonNode data) {
		super();

		ResponseBean.id = Integer.parseInt(data.get("id").asText());
		ResponseBean.username = data.get("username").asText();
		ResponseBean.email = data.get("email").asText();
		ResponseBean.firstName = data.get("firstName").asText();
		ResponseBean.lastName = data.get("lastName").asText();
		ResponseBean.gender = data.get("gender").asText();
		ResponseBean.image = data.get("image").asText();
		ResponseBean.token = data.get("token").asText();
	}

}
