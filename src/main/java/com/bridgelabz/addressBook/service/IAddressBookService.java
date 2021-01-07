package com.bridgelabz.addressBook.service;

import java.util.List;

import com.bridgelabz.addressBook.dto.AddressBookDTO;
import com.bridgelabz.addressBook.model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();
	
	AddressBookData getAddressBookDataById(int bookId);
	
	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);
	
	AddressBookData updateAddressBookData(int bookId, AddressBookDTO addressBookDTO);
	
	void deleteAddressBookData(int bookId);
}
