package com.hike.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hike.demo.entity.Role;
//declares a custom method in JpaRepository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}