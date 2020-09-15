package com.kaveinga.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaveinga.projection.UserView;
import com.kaveinga.utils.ObjectUtils;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UserController {

    private Logger      log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get Member By Uuid")
    @GetMapping("/{uuid}")
    public ResponseEntity<UserView> getUserById(@PathVariable("uuid") String uuid) {
        log.info("get user by uuid: {}", uuid);
        UserView user = userService.getUserView(uuid);
        log.info("user: {}", ObjectUtils.toJson(user));
        log.info("user age: {}", user.getAge());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
