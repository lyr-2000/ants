package com.ants.dao;

import com.ants.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author czd
 */
@Repository
public interface UserDao {
    public int add(User user);
}
