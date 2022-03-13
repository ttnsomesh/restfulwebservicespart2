package com.example.demo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the person")
public class ContactPerson {
    private Integer id;
    @ApiModelProperty(notes = "name should me less than 6 character")
    private String name;
    @ApiModelProperty(notes = "phone must be of 10 character")
    private String phone;

    public ContactPerson(){}
    public ContactPerson(Integer id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
