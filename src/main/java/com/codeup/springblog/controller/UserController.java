package com.codeup.springblog.controller;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.User;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/profile")
    public String profile(){
        return "user/profile";
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "user/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@Valid @ModelAttribute User user, BindingResult validation, Model model){

        if(user.getUsername().length() < 3 || user.getPassword().length() < 8 || user.getEmail().isEmpty() || !user.getPassword().equals(user.getConfirm())){
            validation.addError(new FieldError("user", "username", "Username Error"));
            validation.addError(new FieldError("user", "email", "Email Error"));
            validation.addError(new FieldError("user", "password", "Password Error"));
            if(validation.hasErrors()){
                model.addAttribute("errors", validation);
                model.addAttribute("user", user);
                return "user/sign-up";
            }
        }

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/profile";
    }

}
