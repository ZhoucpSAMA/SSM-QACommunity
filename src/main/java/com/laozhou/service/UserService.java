package com.laozhou.service;

import com.laozhou.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    User getUserByName(String username);

    List<User> getAllUsers();

    int addUser(User user);

    int delUserByName(String username);

    int updateUser(User user);

    int getUserTotal();
    int getIDByUsername(String username);
    int getRoleById(String id);
    int getStatusById(String id);
}
