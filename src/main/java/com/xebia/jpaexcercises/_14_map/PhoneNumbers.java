package com.xebia.jpaexcercises._14_map;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumbers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "phonenumber_list")
    private List<String> phoneNumbers;

    public PhoneNumbers() {
    }

    public PhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Long getId() {
        return id;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}
