package com.hike.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hike.demo.entity.User;
//declares a custom method in JpaRepository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
