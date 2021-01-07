package com.bridgelabz.addressBook.dto;

import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class AddressBookDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
	public String fullName;
	
	@Pattern(regexp = "^([A-Za-z0-9()/,-.]{3,}[ ]?)+$", message = "Address Invalid")
	public String address;
	
	@Pattern(regexp = "^91{2}[ ]{1}[789]{9}$", message = "Phone Number Invalid")
	public long phoneNumber;
	
	public String City;
	
	public String State;
	
	public long ZipCode;
}
