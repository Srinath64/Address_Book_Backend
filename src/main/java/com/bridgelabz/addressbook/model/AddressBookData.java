package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "person_details")
public @Data class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int person_id;

    private String fullName;
    private String address;
    private String city;
    private String state;
    private String zipNo;
    private String phoneNumber;

    public AddressBookData() {}

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.updateAddressBookData(addressBookDTO);

    }
    public void updateAddressBookData(AddressBookDTO addressBookDTO) {

        this.fullName = addressBookDTO.fullName;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipNo = addressBookDTO.zipNo;
        this.phoneNumber = addressBookDTO.phoneNumber;

    }
}
