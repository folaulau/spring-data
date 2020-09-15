package com.kaveinga.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaveinga.projection.UserView;

public interface UserRepository extends JpaRepository<User, Long> {

    UserView findByUid(String uuid);

}
