package com.cg.marriageceremony.model;

import javax.persistence.Entity;

@Entity
public class Caterers extends Vendor {
	private String cName;
	private String cDiscription;
	private String imagepath;
	private String cuisine;
	
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcDiscription() {
		return cDiscription;
	}
	public void setcDiscription(String cDiscription) {
		this.cDiscription = cDiscription;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

}
