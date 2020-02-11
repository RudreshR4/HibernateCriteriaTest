package com.scp.java.HibernateCriteriaTrial;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MobileTrial")
public class Mobile {
@Id	
private int id;
private String name;
private String company;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public Mobile(int id, String name, String company) {
	super();
	this.id = id;
	this.name = name;
	this.company = company;
}
public Mobile() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Mobile [id=" + id + ", name=" + name + ", company=" + company + "]";
}
}
