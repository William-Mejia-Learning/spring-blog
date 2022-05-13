package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    @GetMapping()
    @ResponseBody
    public String indexPage(){
        return "posts index page";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String individualPost(@PathVariable long id){
        return "view and individual post";
    }

    @GetMapping("/create")
    @ResponseBody
    public String create(){
        return "view the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String postCreate(){
        return "create a new form";
    }

}
