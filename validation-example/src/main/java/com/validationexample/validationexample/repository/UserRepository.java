package com.validationexample.validationexample.repository;

import com.validationexample.validationexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(int userId);
}
