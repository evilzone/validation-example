package com.validationexample.validationexample.service;

import com.validationexample.validationexample.dto.UserRequest;
import com.validationexample.validationexample.entity.User;
import com.validationexample.validationexample.exception.UserNotFoundException;
import com.validationexample.validationexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User user = new User(userRequest.getUserId(), userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
                userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if(user != null) {
            return user;
        } else {
            throw new UserNotFoundException("user not found by " + id);
        }
    }
}
