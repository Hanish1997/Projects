package com.groupd.finalproject.bean;

public class Customer {
	

private String CustomerId;
private String Name;
private String Address;
private String State;
private String postalCode;
private String Country;
private String loginId;


public String getCustomerId() {
	return CustomerId;
}
public String getName() {
	return Name;
}
public String getAddress() {
	return Address;
}
public String getState() {
	return State;
}
public String getPostalCode() {
	return postalCode;
}
public String getCountry() {
	return Country;
}
public void setCustomerId(String customerId) {
	CustomerId = customerId;
}
public void setName(String name) {
	Name = name;
}
public void setAddress(String address) {
	Address = address;
}
public void setState(String state) {
	State = state;
}
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}
public void setCountry(String country) {
	Country = country;
}

public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}

}
