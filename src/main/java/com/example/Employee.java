package com.example;

public class Employee {
	private int empId;
	private String name;
	private OfficeAddress officeAddress;
	private HomeAddress homeAddress;
	private int addressFk;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OfficeAddress getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(OfficeAddress officeAddress) {
		this.officeAddress = officeAddress;
	}
	public HomeAddress getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(HomeAddress homeAddress) {
		this.homeAddress = homeAddress;
	}
	public int getAddressFk() {
		return addressFk;
	}
	public void setAddressFk(int addressFk) {
		this.addressFk = addressFk;
	}

	

}
