package com.job.exercise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name ="ForeignKeyAssoAccountEntity")
@Table(name="ACCCOUNT", uniqueConstraints= {
@UniqueConstraint(columnNames="ID")})
public class AccountList implements Serializable{
	
	private static final long serialVersionUID = 1460892919941685901L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="ID", unique=true, nullable=false)
	private int accountId;
	
	@Column(name ="ACC_NAME", unique=false, nullable=true,length=100)
	private String accountName;
	
	@Column(name="ACC_CURRENCY" , unique=false, nullable=true, length=50)
	private String accountCurrency;

	@ManyToOne
	private UserList userList;
	
	
	public AccountList() {
		
		
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountCurrency() {
		return accountCurrency;
	}
	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}
	
	

	public UserList getUserList() {
		return userList;
	}
	
	public void setUserList(UserList userList) {
		this.userList = userList;
	}
	
	

}
