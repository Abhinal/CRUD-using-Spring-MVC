package com.abhinav.service;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import com.abhinav.bean.LoginBean;
import com.abhinav.bean.ResponseBean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginService {

	public ResponseBean login(LoginBean lb) {
		try {
			URL url = new URL("https://dummyjson.com/auth/login");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			String jsonInput = "{\"username\":\"" + lb.getEmail() + "\",\"password\":\"" + lb.getPass() + "\"}";

			try (OutputStream os = conn.getOutputStream()) {
				byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
				os.write(input, 0, input.length);
			}

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

				return new ResponseBean(jsonNode);
			} else {
				return null;
			}
		} catch (IOException e) {
			return null;
		}
	}

}
