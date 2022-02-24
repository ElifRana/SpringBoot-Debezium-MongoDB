package com.example.springbootdebeziummongodb.service;

import com.example.springbootdebeziummongodb.model.User;
import com.example.springbootdebeziummongodb.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService{

    final UserRepository userRepository;

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, User user) {

        User newUser = userRepository.findById(id).orElseThrow();
        newUser.setName(user.getName());
        return userRepository.save(newUser);
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }

    @Override
    public List<User> allUser() {
        return userRepository.findAll();
    }
}
