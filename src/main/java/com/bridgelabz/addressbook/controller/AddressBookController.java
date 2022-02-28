package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.model.User;
import com.bridgelabz.addressbook.services.IAddressBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/addressbook")
@CrossOrigin
public class AddressBookController {

    @Autowired
    IAddressBookServices addressBookServices;


    @GetMapping("/api")
    public String login(){
        return "Authenticated Successfully !!!" ;
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return Stream.of(new User(108,"Santosh","santosh@gmail.com","9087654321"),
                        new User(101,"Basant","basant@gmail.com","8867101121")).
                collect(Collectors.toList());
    }

    //http://localhost:8085/addressbook/details
    @GetMapping(value = {"", "/", "/details"})
    public ResponseEntity<ResponseDTO> getAddressBookData()
    {
        List addressBookDataList = addressBookServices.getAddressBookData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //http://localhost:8085/addressbook/details/1
    @GetMapping("/details/{personId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("personId") int personId)
    {
        AddressBookData addressBookData = addressBookServices.getAddressBookDataById(personId);
        ResponseDTO respDTO = new ResponseDTO("Get Call By Id Success", addressBookData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    //http://localhost:8085/addressbook/create
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = addressBookServices.createAddressBookData(addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("Address book data created", addressBookData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    //http://localhost:8085/addressbook/update/1
    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("personId") int personId,
                                                             @RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = addressBookServices.updateAddressBookData(personId, addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated addressBook data", addressBookDTO);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    //http://localhost:8085/addressbook/delete/1
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("personId") int personId)
    {
        addressBookServices.deleteAddressBookData(personId);
        ResponseDTO respDTO = new ResponseDTO("Deleted addressBook data with personId :", personId);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

}
