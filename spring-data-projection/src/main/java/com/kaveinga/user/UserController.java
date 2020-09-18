package com.kaveinga.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaveinga.dto.UserDTO;
import com.kaveinga.projection.UserView;
import com.kaveinga.utils.ObjectUtils;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UserController {

    private Logger      log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get Member DTO By Uuid")
    @GetMapping("/{uuid}/dto")
    public ResponseEntity<UserDTO> getUserDTOById(@PathVariable("uuid") String uuid) {
        log.info("get user by uuid: {}", uuid);
        UserDTO user = userService.getUserDTO(uuid);
        log.info("user: {}", ObjectUtils.toJson(user));
        log.info("user age: {}", user.getAge());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Member DTO By Age")
    @GetMapping("/{age}/age")
    public ResponseEntity<UserDTO> getUserDTOByAge(@PathVariable("age") int age) {
        log.info("get user by age: {}", age);
        UserDTO user = userService.getUserDTOByAge(age);
        log.info("user: {}", ObjectUtils.toJson(user));
        log.info("user age: {}", user.getAge());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Member View By Uuid")
    @GetMapping("/{uuid}/view")
    public ResponseEntity<UserView> getUserViewById(@PathVariable("uuid") String uuid) {
        log.info("get user by uuid: {}", uuid);
        UserView user = userService.getUserView(uuid);
        log.info("user: {}", ObjectUtils.toJson(user));
        log.info("user age: {}", user.getAge());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Member Names and Emails")
    @GetMapping("/names-emails")
    public ResponseEntity<List<User>> getUserNamesAndEmails() {
        List<User> users = userService.getUserNamesAndEmails();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
