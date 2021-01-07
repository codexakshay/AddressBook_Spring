package com.bridgelabz.addressBook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.addressBook.dto.AddressBookDTO;

import lombok.Data;

@Entity
@Table(name = "address_book")
public @Data class AddressBookData {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "book_id")
	private int addressBookId;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "city")
	private String City;
	
	@Column(name = "state")
	private String State;
	
	@Column(name = "zip_code")
	private long ZipCode;
	
	public AddressBookData() { }

	public AddressBookData(AddressBookDTO addressBookDTO) {
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
