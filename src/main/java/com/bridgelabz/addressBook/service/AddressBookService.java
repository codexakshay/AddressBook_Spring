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
	
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepository.findAll();
	}

	public AddressBookData getAddressBookDataById(int bookId) {
		return addressBookRepository
				.findById(bookId)
				.orElseThrow(() -> new AddressBookException("Contact with bookId " + bookId + " does not exists!!"));
	}

	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(addressBookDTO);
		log.debug("Contact Data: "+contactData.toString());
		return addressBookRepository.save(contactData);
	}

	public AddressBookData updateAddressBookData(int bookId, AddressBookDTO addressBookDTO) {
		AddressBookData contactData = this.getAddressBookDataById(bookId);
		contactData.updateAddressBookData(addressBookDTO);
		return addressBookRepository.save(contactData);
	}

	public void deleteAddressBookData(int bookId) {
		AddressBookData contactData = this.getAddressBookDataById(bookId);
		addressBookRepository.delete(contactData);
	}
}
