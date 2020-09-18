package com.kaveinga.dto;

public class AddressDTO {

    private Long   id;

    private String street;

    private String street2;

    private String city;

    private String state;

    private String zip;

    public AddressDTO(Long id, String street, String street2, String city, String state, String zip) {
        super();
        this.id = id;
        this.street = street;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}
