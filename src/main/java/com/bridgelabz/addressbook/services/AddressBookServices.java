package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServices implements IAddressBookServices {

    List<AddressBookData> addressbookDataList = new ArrayList();

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressbookDataList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return addressbookDataList.get(personId-1);
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressbookDataList.size()+1, addressBookDTO);
        addressbookDataList.add(addressBookData);
        return addressBookData;
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId-1);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookData;
    }

    @Override
    public void deleteAddressBookData(int personId) {
        addressbookDataList.remove(personId-1);
    }
}
