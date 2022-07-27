package com.almiraquino.brewer.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Beer {

	@NotBlank(message="SKU is required!")
	private String sku;
	
	@NotBlank(message="Name is required!")
	private String name;
	
	@Size(min=1, max=100, message="Description's size must be between 1 and 100 characters")
	private String description;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Beer withSku(String sku) {
		setSku(sku);
		return this;
	}
	
	public Beer withName(String name) {
		setName(name);
		return this;
	}
	
	public Beer withDescription(String description) {
		setDescription(description);
		return this;
	}

}
