package com.kaveinga.projection;

public interface UserView {

    Long getId();

    String getName();

    String getEmail();

    int getAge();

    String getUid();

    AddressView getAddress();

}
