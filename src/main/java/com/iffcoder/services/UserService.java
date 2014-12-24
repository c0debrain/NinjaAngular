package com.iffcoder.services;

import com.iffcoder.models.User;

import java.util.List;

/**
 * Created by guoliangwang on 12/23/14.
 */
public interface UserService
{
    public List<User> getAllUsers();

    public void addUser(User user);

    public void deleteUser(Long userId);

    public void deleteUser(User user);

    public User findUserById(Long userId);

    public User findUserByEmail(String email);

//    public void deleteAll();
}
