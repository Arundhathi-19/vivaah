package com.cg.marriageceremony.model;

import javax.persistence.Entity;

@Entity
public class Venue extends Vendor{
	private String vName;
	private String vDiscription;
	private String imagepath;
	private String location;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvDiscription() {
		return vDiscription;
	}
	public void setvDiscription(String vDiscription) {
		this.vDiscription = vDiscription;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	


}
