package com.bridgelabz.addressBook.model;

import com.bridgelabz.addressBook.dto.AddressBookDTO;

import lombok.Data;

public @Data class AddressBookData {

	private int addressBookId;
	private String fullName;
	private String address;
	private long phoneNumber;
	private String City;
	private String State;
	private long ZipCode;
	
	public AddressBookData() { }

	public AddressBookData(int addressBookId, AddressBookDTO addressBookDTO) {
		this.addressBookId = addressBookId;
		this.updateAddressBookData(addressBookDTO);
	}

	private void updateAddressBookData(AddressBookDTO addressBookDTO) {
		this.fullName = addressBookDTO.fullName;
		this.address = addressBookDTO.address;
		this.phoneNumber = addressBookDTO.phoneNumber;
		this.City = addressBookDTO.City;
		this.State = addressBookDTO.State;
		this.ZipCode = addressBookDTO.ZipCode;
	}
}
