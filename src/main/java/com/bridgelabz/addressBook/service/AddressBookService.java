package com.bridgelabz.addressBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressBook.dto.AddressBookDTO;
import com.bridgelabz.addressBook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService{

	public List<AddressBookData> getAddressBookData() {
		List<AddressBookData> contactDataList = new ArrayList<>();
		contactDataList.add(new AddressBookData(1, new AddressBookDTO("Sreekar Pothuri", "Ring Road")));
		return contactDataList;
	}

	public AddressBookData getAddressBookDataById(int bookId) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, new AddressBookDTO("Sreekar Pothuri", "Ring Road"));
		return contactData;
	}

	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, addressBookDTO);
		return contactData;
	}

	public AddressBookData updateAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, addressBookDTO);
		return contactData;
	}

	public void deleteAddressBookData(int bookId) {
		// TODO Auto-generated method stub
	}
}
