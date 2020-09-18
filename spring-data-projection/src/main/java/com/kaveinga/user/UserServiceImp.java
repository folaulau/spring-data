package com.kaveinga.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaveinga.dto.UserDTO;
import com.kaveinga.projection.UserView;

@Service
public class UserServiceImp implements UserService {

    private Logger         log = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager  entityManager;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public UserView getUserView(String uuid) {
        // TODO Auto-generated method stub
        return userRepository.findByUid(uuid);

    }

    @Override
    public UserDTO getUserDTO(String uuid) {
        // TODO Auto-generated method stub
        UserView userView = userRepository.findByUid(uuid);
        return userRepository.findByEmail(userView.getEmail());

    }

    @Override
    public List<User> getUserNamesAndEmails() {
        // TODO Auto-generated method stub
        List<Object[]> objs = userRepository.getNameAndEmail();

        List<User> users = objs.stream().map(obj -> {

            User user = new User();
            user.setName(obj[0].toString());
            user.setEmail(obj[1].toString());

            return user;

        }).collect(Collectors.toList());

        return users;

    }

    @Override
    public UserDTO getUserDTOByAge(int age) {
        // TODO Auto-generated method stub
        return userRepository.findByAge(age, UserDTO.class);

    }

}
