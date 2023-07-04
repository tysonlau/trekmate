package com.hike.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private int age;
    private String email;
    private String location;
    private String difficulty;
    private String password;

    public User2() {
    }
    public User2(String name, int age, String email, String location, String difficulty, String password) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.difficulty = difficulty;
        this.email = email;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
