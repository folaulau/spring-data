package com.kaveinga.dto;

import com.kaveinga.address.Address;

public class UserDTO {

    private Long       id;

    private String     uid;

    private String     name;

    private String     email;

    private int        age;

    private Address address;

    public UserDTO(Long id, String uid, String name, String email, int age, Address address) {
        super();
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
