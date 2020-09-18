package com.kaveinga.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaveinga.dto.UserDTO;
import com.kaveinga.projection.UserView;

public interface UserRepository extends JpaRepository<User, Long> {

    UserView findByUid(String uuid);

    UserDTO findByEmail(String email);

    @Query("SELECT u.name, u.email FROM User u")
    List<Object[]> getNameAndEmail();

    <T> T findByAge(int age, Class<T> type);
}
