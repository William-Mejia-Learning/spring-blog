package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/roll-dice")
public class DiceController {

    @GetMapping
    public String dicePage(){
        return "dice/dice";
    }

    @GetMapping("/{number}")
    public String numberPage(@PathVariable int number, Model model) {
        Random rand = new Random();
        int random = rand.nextInt(6) + 1;
        String message = " ";
        System.out.println(random);
        if(random == number){
            message = "You guessed right";
        }else{
            message = "You're wrong, nice try";
        }
        model.addAttribute("random", random);
        model.addAttribute("number", number);
        model.addAttribute("message", message);
        return "/dice/dice";
    }
}
