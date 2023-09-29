package com.springtest.fullbackend.repo;

import com.springtest.fullbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
