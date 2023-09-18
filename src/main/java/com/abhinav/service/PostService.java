package com.abhinav.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.abhinav.bean.PostManagerBean;
import com.abhinav.bean.ResponseBean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostService {
	
	public PostManagerBean getPostApi() {
		try {
			URL url = new URL("https://dummyjson.com/posts");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			String token = new ResponseBean().getToken();
	        if (token != null && !token.isEmpty()) {
	            conn.setRequestProperty("Authorization", "Bearer " + token);
	        }
			conn.setDoOutput(true);
			conn.setDoInput(true);

			int responseCode = conn.getResponseCode();
		
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				in.close();
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode jsonNode = objectMapper.readTree(response.toString());	
				
				return new PostManagerBean(jsonNode);
			} else {
				return null;
			}
		} catch (IOException e) {
			return null;
		}
	}

	public void deletePostApi(Integer id) {
		try {
			URL url = new URL("https://dummyjson.com/posts/"+id);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Content-Type", "application/json");
			
			String token = new ResponseBean().getToken();
	        if (token != null && !token.isEmpty()) {
	            conn.setRequestProperty("Authorization", "Bearer " + token);
	        }
	        
		} catch (IOException e) {

		}
	}

}
