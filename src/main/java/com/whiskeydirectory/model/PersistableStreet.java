package com.whiskeydirectory.model;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class PersistableStreet {
	public PersistableStreet() {
		super();
	}

	@PrimaryKey
	@Persistent ( valueStrategy = IdGeneratorStrategy.IDENTITY )
	private Long id;
	@Persistent
	private String name;
	@Persistent
	private Boolean longitudinal;
	@Persistent
	private Boolean latitudinal;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Boolean getLongitudinal() {
		return longitudinal;
	}
	public void setLongitudinal(Boolean longitudinal) {
		this.longitudinal = longitudinal;
	}

	public Boolean getLatitudinal() {
		return latitudinal;
	}
	public void setLatitudinal(Boolean latitudinal) {
		this.latitudinal = latitudinal;
	}
}
