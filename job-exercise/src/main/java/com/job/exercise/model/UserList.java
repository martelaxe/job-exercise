package com.job.exercise.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name ="ForeignKeyAssoEntity")
@Table(name = "USERS", uniqueConstraints= {
@UniqueConstraint(columnNames="ID"),
@UniqueConstraint(columnNames="NAME")
})
public class UserList implements Serializable {
	
	private static final long serialVersionUID = -2801978218060392627L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID", unique=true, nullable=false)
	private int userId;

	@Column(name ="NAME", unique=true, nullable=false)
	private String name;

	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private Set<AccountList> accounts;

	public UserList() {
		
	}
	
	public UserList(String name) {
		this.name= name;
	}

	public Set<AccountList> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountList> accounts) {
		this.accounts = accounts;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
