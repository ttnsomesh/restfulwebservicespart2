package com.example.demo;

public class PersonV2 {
    private Name name;
    private Address address;

    public PersonV2(){}

    public PersonV2(Name name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
