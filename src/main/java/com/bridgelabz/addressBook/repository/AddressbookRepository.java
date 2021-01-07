package com.bridgelabz.addressBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.addressBook.model.AddressBookData;

public interface AddressbookRepository extends JpaRepository<AddressBookData, Integer> {

}
