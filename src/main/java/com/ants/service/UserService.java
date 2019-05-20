package com.ants.service;

import com.ants.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author czd
 */
@Service
public interface UserService {
    public int add(User user);
}
