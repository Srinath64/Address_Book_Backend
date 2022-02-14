package com.bridgelabz.addressbook.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public @Data class AddressBookDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "{addressbook.error.firstname}")
    public String first_name;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "{addressbook.error.lastname}")
    public String last_name;

    @Pattern(regexp = "Male|Female", message = "{addressbook.error.gender}")
    public String gender;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "{addressbook.error.phoneno}")
    public String phone_no;

    @NotBlank(message = "{addressbook.error.city}")
    public String city;

    @NotBlank(message = "{addressbook.error.state}")
    public String state;

    @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "{addressbook.error.zipcode}")
    public String zip_code;
}

