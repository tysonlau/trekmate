package com.hike.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hike.demo.entity.Role;
import com.hike.demo.entity.User;
//declares a custom method in JpaRepository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<User> findById(String id);
    Role findByName(String name);
}