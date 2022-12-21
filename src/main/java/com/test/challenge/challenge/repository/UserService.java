package com.test.challenge.challenge.repository;

import com.test.challenge.challenge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<User, Long> {
}
