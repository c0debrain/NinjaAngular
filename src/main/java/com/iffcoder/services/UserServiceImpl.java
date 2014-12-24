package com.iffcoder.services;

import java.util.List;


import com.google.inject.Inject;
import com.iffcoder.dao.UserDao;
import com.iffcoder.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoliangwang on 12/14/14.
 */

public class UserServiceImpl implements UserService
{

    @Inject
    private UserDao userDao;

    public UserServiceImpl() {}

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.findAllUsers();
        return users;
    }

    @Override
    public void addUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userDao.deleteUserById(userId);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    public User findUserById(Long userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }
}

