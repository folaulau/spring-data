package com.kaveinga.loader;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaveinga.address.Address;
import com.kaveinga.user.User;
import com.kaveinga.user.UserRepository;

@Component
public class UserLoader {

    @Autowired
    private UserRepository userRepository;

    public void load() {

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUid("fb61971f-3386-4170-bbb2-b65a9a93db54" + (i + 1));
            user.setAge(5);
            user.setEmail("folaudev+" + (i + 1) + "@gmail.com");
            user.setName("Folau Kaveinga");

            Address address = new Address();
            address.setCity("Lehi");
            address.setState("UT");
            address.setZip("84043");
            address.setStreet("2211 W 1980 S");

            user.setAddress(address);

            userRepository.saveAndFlush(user);
        }
    }
}
