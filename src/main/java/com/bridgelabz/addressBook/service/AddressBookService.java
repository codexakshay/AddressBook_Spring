package com.bridgelabz.addressBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressBook.dto.AddressBookDTO;
import com.bridgelabz.addressBook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService{

	private List<AddressBookData> contactDataList = new ArrayList<>();
	public List<AddressBookData> getAddressBookData() {
		return contactDataList;
	}

	public AddressBookData getAddressBookDataById(int bookId) {
		return contactDataList.get(bookId-1);
	}

	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(contactDataList.size()+1, addressBookDTO);
		contactDataList.add(contactData);
		return contactData;
	}

	public AddressBookData updateAddressBookData(int bookId, AddressBookDTO addressBookDTO) {
		AddressBookData contactData = this.getAddressBookDataById(bookId);
		contactData.setFullName(addressBookDTO.fullName);
		contactData.setAddress(addressBookDTO.address);
		contactDataList.set(bookId-1, contactData);
		return contactData;
	}

	public void deleteAddressBookData(int bookId) {
		contactDataList.remove(bookId-1);
	}
}
