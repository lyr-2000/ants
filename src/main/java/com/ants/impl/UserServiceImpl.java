package com.ants.impl;

import com.ants.dao.UserDao;
import com.ants.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ants.service.UserService;

/**
 * @author czd
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int add(User user) {
        return userDao.add(user);
    }
}
