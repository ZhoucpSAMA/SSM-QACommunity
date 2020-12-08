package com.laozhou.service;

import com.laozhou.dao.UserMapper;
import com.laozhou.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int delUserByName(String username) {
        return userMapper.delUserByName(username);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int getUserTotal() {
        return userMapper.getUserTotal();
    }

    @Override
    public int getIDByUsername(String username) {
        return userMapper.getIDByUsername(username);
    }

    @Override
    public int getRoleById(String id) {
        return userMapper.getRoleById(id);
    }

    @Override
    public int getStatusById(String id) {
        return userMapper.getStatusById(id);
    }

    @Override
    public int getUserIDByUsername(String username) {
        return userMapper.getIDByUsername(username);
    }
}
