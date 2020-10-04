package com.olena.relationships.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Column(updatable=false)
	private Date createAt;
	private Date updateAt;
	@OneToOne(mappedBy="person", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private License lisense;
	public Person() {
	}
	public Person(String firstName, String lastName, Date createAt, Date updateAt, License lisense) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.lisense = lisense;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public License getLisense() {
		return lisense;
	}
	public void setLisense(License lisense) {
		this.lisense = lisense;
	}
	
	@PrePersist
	public void getCreatedAt() {
		createAt=new Date();
	}
	
	@PreUpdate
	public void getUpdateAt() {
		updateAt=new Date();
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
}
