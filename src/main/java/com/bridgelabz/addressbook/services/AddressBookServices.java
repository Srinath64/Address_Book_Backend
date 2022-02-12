package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookServices implements IAddressBookServices {

    @Autowired
    AddressBookRepository addressBookRepo;

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepo.findAll();
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return addressBookRepo.findById(personId).orElse(null);
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        return addressBookRepo.save(addressBookData);
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO AddressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookData.updateAddressBookData(AddressBookDTO);
        return addressBookRepo.save(addressBookData);
    }

    @Override
    public void deleteAddressBookData(int personId) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookRepo.delete(addressBookData);
    }
}
