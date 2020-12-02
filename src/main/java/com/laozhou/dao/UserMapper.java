package com.laozhou.dao;

import com.laozhou.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User getUserByName(@Param("username") String username);

    List<User> getAllUsers();

    int addUser(User user);

    int delUserByName(@Param("username") String username);

    int updateUser(User user);

    int getUserTotal();

    int getIDByUsername(@Param("username") String username);

    int getRoleById(@Param("id")String id);
}
