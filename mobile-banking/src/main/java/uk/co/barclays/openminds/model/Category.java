package uk.co.barclays.openminds.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
	
	private String name;
	private String description;
	

}
