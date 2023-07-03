package com.hike.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hike.demo.models.User;
import com.hike.demo.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UsersController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/user/userPage/{id}/edit")
    public String editStudent(Model model, @RequestParam(name = "uiddd") String id, HttpServletResponse response){
        //List<Student> student = studentRepo.findByUid(uid);  
        System.out.println("s");
        System.out.println("Get User " + id);
        User u = userRepo.findById(id).get(0);

        model.addAttribute("user", u);
        //return "showUser";
        return "user/edit";
    }

    @PostMapping("/user/userPage/{id}/edited")
    public String editedStudent(Model model, @RequestParam Map<String, String> newuser, HttpServletResponse response){
        System.out.println("Edit user");
        String newName = newuser.get("name");
        String newEmail = newuser.get("email");
        String newDifficulty = newuser.get("difficulty");
        String newLocation = newuser.get("location");
        String tempAge = newuser.get("age");
        String tempId = newuser.get("idddd");
        String pass = newuser.get("password");
        //int id = Integer.parseInt(tempId);
        
        if (tempAge.length() == 0 || newDifficulty.length() == 0 || newName.length() == 0 || newLocation.length() == 0 || newEmail.length() == 0) {
            model.addAttribute("error", "Please ensure all input fields are filled");
            model.addAttribute("uid", tempId);
            return "user/errorPage";
        }
        if (tempAge.matches(".*[^0-9.].*")){
            model.addAttribute("error", "Invalid age input (non-numerical characters)");
            model.addAttribute("uid", tempId);
            return "user/errorPage";
        } 
        int newAge = Integer.parseInt(newuser.get("age"));

        if (newAge < 18){
            String error = "Invalid age (under 18)";
            model.addAttribute("error", error);
            model.addAttribute("uid", tempId);
            return "user/errorPage";
        } 

        if (newEmail.toLowerCase().indexOf(".com") == -1 && newEmail.toLowerCase().indexOf(".ca") == -1 && newEmail.toLowerCase().indexOf("@") == -1) {
            String error = "Invalid email input (no @ symbol, .com or .ca)";
            model.addAttribute("error", error);
            model.addAttribute("uid", tempId);
            return "user/errorPage";
        } else if (newEmail.toLowerCase().indexOf(".com") == -1 && newEmail.toLowerCase().indexOf(".ca") == -1) {
            String error = "Invalid email input (no .com or .ca)";
            model.addAttribute("error", error);
            model.addAttribute("uid", tempId);
            return "user/errorPage";
        } else if (newEmail.toLowerCase().indexOf("@") == -1) {
            String error = "Invalid email input (no @ symbol)";
            model.addAttribute("error", error);
            model.addAttribute("uid", tempId);
            return "user/errorPage";
        }

        User u = userRepo.findById(tempId).get(0);

        userRepo.delete(u); //delete from database

        userRepo.save(new User(newName, newAge, newEmail, newLocation, newDifficulty, pass));

        return "user/edited";
    }
}