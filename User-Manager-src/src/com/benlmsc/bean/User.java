package com.benlmsc.bean;

public class User {

	private String Email;
	private String Pwd;
	private String Name;

	public String getEmail() {
		return this.Email;
	}

	public String getPwd() {
		return this.Pwd;
	}

	public String getName() {
		return this.Name;
	}

	public void setEmail( String Email ) {
		this.Email = Email;
	}
	
	public void setPwd (String Pwd ) {
		this.Pwd= Pwd;
	}
	
	public void setName( String Name ) {
		this.Name = Name;
	}
	
}
