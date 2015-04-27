package com.bangla.store.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = -530086768384258062L;
        @Id
        @GeneratedValue
        private int id;
	private String doorNo;
	private String streetName;
	private String areaName;
	private String state;
	private String country;
	private String zipCode;

	// add getters and setters for all the fields here.
	// Override equals and hashCode based on all the fields.
	// the code for the same is available in the code bundle which
	// can be downloaded from www.packtpub.com/support
	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	 

}