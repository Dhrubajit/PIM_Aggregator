package com.main.java.modelObject;

public class Product {
	
	private String uuid;
	private String name;
	private String description;
	private String provider;
	private String available;
	private String messuermentunit;
	
	public Product(String uuid, String name, String description, String provider, String available,
			String messuermentUnit) {
		this.uuid = uuid;
		this.name = name;
		this.description = description;
		this.provider = provider;
		this.available = available;
		this.messuermentunit = messuermentUnit;
	}

	public String getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getProvider() {
		return provider;
	}

	public String getAvailable() {
		return available;
	}

	public String getMessuermentunit() {
		return messuermentunit;
	}

}
