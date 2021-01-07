package com.bridgelabz.addressBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressBook.dto.AddressBookDTO;
import com.bridgelabz.addressBook.exception.AddressBookException;
import com.bridgelabz.addressBook.model.AddressBookData;
import com.bridgelabz.addressBook.repository.AddressbookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{

	@Autowired
	private AddressbookRepository addressBookRepository;
	
	private List<AddressBookData> contactDataList = new ArrayList<>();
	public List<AddressBookData> getAddressBookData() {
		return contactDataList;
	}

	public AddressBookData getAddressBookDataById(int bookId) {
		return contactDataList.stream()
				.filter(bookData -> bookData.getAddressBookId() == bookId)
				.findFirst()
				.orElseThrow(() -> new AddressBookException("Contact Not Found"));
	}

	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(addressBookDTO);
		contactDataList.add(contactData);
		log.debug("Contact Data: "+contactData.toString());
		return addressBookRepository.save(contactData);
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
