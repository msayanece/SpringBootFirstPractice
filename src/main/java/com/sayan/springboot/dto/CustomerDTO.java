package com.sayan.springboot.dto;

public class CustomerDTO {

	private String name;
	private String email;
	private String phone;
	private String address;
	private String dob;
	private String gender;
	private String branch;
	private String branchType;

	public CustomerDTO() {
	}
	
	public CustomerDTO(String name, String email, String phone, String address, String dob, String gender, String branch,
			String branchType, String tnc) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.branch = branch;
		this.branchType = branchType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBranchType() {
		return branchType;
	}

	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + ", dob="
				+ dob + ", gender=" + gender + ", branch=" + branch + ", branchType=" + branchType + "]";
	}

}
