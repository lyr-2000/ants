package com.ants.test;

import com.ants.entity.User;
import com.ants.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author czd
 */
public class UserTestTest {

    @Autowired
    private UserService userService;

    @Autowired
    private User user;

    @Test
    public void hello() {
        user.setParentId(1);
        user.setParentName("222");
        int result = userService.add(user);
        System.out.println("result:" + result);
    }


}