package com.steg.gwtjson.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Address {
	@JsonCreator
	public static Address create(
		     @JsonProperty("street") String street,
		     @JsonProperty("suite") String suite,
		     @JsonProperty("city") String city,
		     @JsonProperty("zipcode") String zipcode) {
		return new AutoValue_Address(street, suite, city, zipcode);
	}
	
	public abstract String getStreet();

	public abstract String getSuite();

	public abstract String getCity();

	public abstract String getZipcode();

}
