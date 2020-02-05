package com.nopcomerce.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserParseData {
	public static UserParseData getFile(String filename) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(new File(filename), UserParseData.class);
	}
	@JsonProperty("phone")
	private String phone;
	public String getPhone() {
		return phone;
	}
	@JsonProperty("Register")
	Register register;
	static class Register{
		@JsonProperty("firstname")
		private String firstName;
		
		@JsonProperty("lastname")
		private String lastName;
		

		@JsonProperty("company_name")
		private String companyName;
		
		@JsonProperty("register_success")
		private String registerSuccessMessage;
		
	}
	public String getFirstName() {
		return register.firstName;
	}
	public String getLastName() {
		return register.lastName;
	}
	public String getCompanyName() {
		return register.companyName;
	}
	public String getRegisterSuccessMessage() {
		return register.registerSuccessMessage;
	}
	@JsonProperty("Login")
	Login login;
	static class Login{
		@JsonProperty("pre_email")
		private String preEmail;
		
		@JsonProperty("post_email")
		private String postEmail;
		
		@JsonProperty("password")
		private String password;

		

	}
	public String getPreEmail() {
		return login.preEmail;
	}

	public String getPostEmail() {
		return login.postEmail;
	}

	public String getPassword() {
		return login.password;
	}
	
	
	
}
