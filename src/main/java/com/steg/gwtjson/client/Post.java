package com.steg.gwtjson.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Post {
	@JsonCreator
	public static Post create(
			@JsonProperty("userId") String userId, 
			@JsonProperty("id") String id,
			@JsonProperty("title") String title, 
			@JsonProperty("body") String body) {
		return new AutoValue_Post(userId, id, title, body);
	}

	public abstract String getUserId();

	public abstract String getId();

	public abstract String getTitle();

	public abstract String getBody();
}