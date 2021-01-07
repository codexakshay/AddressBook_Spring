package com.bridgelabz.addressBook.dto;

import javax.validation.constraints.Pattern;

public class AddressBookDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
	public String fullName;
	
	@Pattern(regexp = "^[a-zA-Z\\s]{10,}$", message = "Address Invalid")
	public String address;

	public AddressBookDTO(String fullName, String address) {
		this.fullName = fullName;
		this.address = address;
	}

	@Override
	public String toString() {
		return "fullName=" + fullName + ", address=" + address;
	}
}
