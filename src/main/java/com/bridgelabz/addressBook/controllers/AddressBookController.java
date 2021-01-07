package com.bridgelabz.addressBook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressBook.dto.AddressBookDTO;
import com.bridgelabz.addressBook.dto.ResponseDTO;
import com.bridgelabz.addressBook.model.AddressBookData;
import com.bridgelabz.addressBook.service.IAddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@Autowired
	private IAddressBookService addressBookService;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> contactList = null;
		contactList = addressBookService.getAddressBookData();
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{bookId}")
	public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("bookId") int bookId) {
		AddressBookData contactData = null;
		contactData =addressBookService.getAddressBookDataById(bookId);
		ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Address Book Contact Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{bookId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("bookId") int bookId, @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = addressBookService.updateAddressBookData(bookId, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Address Book Contact Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("bookId") int bookId) {
		addressBookService.deleteAddressBookData(bookId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Address Book Contact Successfully", "Deleted Id: "+bookId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
