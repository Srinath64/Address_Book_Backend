package com.bridgelabz.addressbook.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public @Data class AddressBookDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Person's first_name Invalid")
    public String first_name;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Person's last_name Invalid")
    public String last_name;

    @Pattern(regexp = "Male|Female", message = "Gender needs to be Male or Female")
    public String gender;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number should be of 10 digit")
    public String phone_no;

    @NotBlank
    public String city;

    @NotBlank
    public String state;

    @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "Zip code is not valid")
    public String zip_code;


    @Override
    public String toString() {
        return "AddressBookDTO [first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender
                + ", phone_no=" + phone_no + ", city=" + city + ", state=" + state + ", zip_code=" + zip_code + "]";
    }
}