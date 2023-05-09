package com.map1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
	
	@Id
	private int eId;
	
	private String name;
	
	@ManyToMany
	private List<Project> projects;

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int eId, String name, List<Project> projects) {
		super();
		this.eId = eId;
		this.name = name;
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Emp [eId=" + eId + ", name=" + name + ", projects=" + projects + "]";
	}
	
	

}
