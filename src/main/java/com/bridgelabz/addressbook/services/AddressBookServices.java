package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookServices implements IAddressBookServices {

    @Override
    public List<AddressBookData> getAddressBookData() {
        return null;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return null;
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO AddressBookDTO) {
        return null;
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO AddressBookDTO) {
        return null;
    }

    @Override
    public void deleteAddressBookData(int personId) {

    }
}
