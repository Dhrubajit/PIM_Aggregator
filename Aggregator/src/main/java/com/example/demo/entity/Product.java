package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Version
	private Long version;
	private String uuid;
	private String name;
	private String description;
	private String provider;
	private String available;
	private String messuermentunit;
	private Date createddate;
	private Date lastmodifieddate;

	public Product() {
		
	}
	public Product(Integer id, Long version, String uuid, String name, String description, String provider,
			String available, String messuermentunit, Date createddate, Date lastmodifieddate) {
		super();
		this.id = id;
		this.version = version;
		this.uuid = uuid;
		this.name = name;
		this.description = description;
		this.provider = provider;
		this.available = available;
		this.messuermentunit = messuermentunit;
		this.createddate = createddate;
		this.lastmodifieddate = lastmodifieddate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getMessuermentunit() {
		return messuermentunit;
	}

	public void setMessuermentunit(String messuermentunit) {
		this.messuermentunit = messuermentunit;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getLastmodifieddate() {
		return lastmodifieddate;
	}

	public void setLastmodifieddate(Date lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}
}
