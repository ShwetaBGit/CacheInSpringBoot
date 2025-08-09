package com.sb.dto;

import java.time.Instant;

public class CommonDto {

	private String name;
	private String designation;
	private String department;
	private double experience;
	private Instant doj;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getExperience() {
		return experience;
	}
	public void setExperience(double experience) {
		this.experience = experience;
	}
	public Instant getDoj() {
		return doj;
	}
	public void setDoj(Instant doj) {
		this.doj = doj;
	}
	
	
	
}
