package com.example.springbootdebeziummongodb.service;

import com.example.springbootdebeziummongodb.model.User;

import java.util.List;

public interface UserService {

    User getUser(String id);

    User createUser(User user);

    User updateUser(String id, User user);

    void deleteUser(String id);

    List<User> allUser();
}
