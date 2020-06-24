package edu.poly.spt.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import groovy.transform.builder.InitializerStrategy.SET;



@Entity
@Table(name = "departs")
public class Depart implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
   @Column(length = 100)
   @NotNull
   @NotEmpty(message = "Không để trống tên")
   @Length(min =   10 , max = 50,  message = "Tên phong ban phải từ 10 đến 50 ký tự")
	private String name;
   
   @OneToMany(mappedBy = "depart" , cascade = CascadeType.ALL)
   private Set<Staff> staffs;
   
   
public Depart() {
	super();
}
public Depart(Integer id, String name) {
	super();
	this.id = id;
	this.name = name;	
}


public Set<Staff> getStaffs() {
	return staffs;
}
public void setStaffs(Set<Staff> staffs) {
	this.staffs = staffs;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
   

 }
