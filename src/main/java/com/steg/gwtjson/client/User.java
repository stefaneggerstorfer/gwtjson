package com.steg.gwtjson.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class User {
	@JsonCreator
	public static User create(
		      @JsonProperty("id") int id,
		      @JsonProperty("name") String name,
		      @JsonProperty("email") String email,
		      @JsonProperty("address") Address address) {
		return new AutoValue_User(id, name, email, address);
	}
	
	public abstract int getId();

	public abstract String getName();

	public abstract String getEmail();

	public abstract Address getAddress();
}
