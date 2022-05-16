package com.codeup.springblog.controller;

import com.codeup.springblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    public List<Post> generatePosts(){
        List<Post> allPosts = new ArrayList<>();
        Post post1 = new Post(1, "First post", "This is my first post!");
        Post post2 = new Post(2, "Another post!", "Amazing content!");
        Post post3 = new Post(3, "Third post", "Fascinating information!");
        allPosts.add(post1);
        allPosts.add(post2);
        allPosts.add(post3);
        return allPosts;
    }


    @GetMapping("/posts")
    public String allPosts(Model model){
        List<Post> allPosts = generatePosts();
        model.addAttribute("allPosts", allPosts);
        return "posts/index";
    }

    @GetMapping()
    public String indexPage(){
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model){
        List<Post> allPosts = generatePosts();
        Post post = null;
        for (int i = 0; i < allPosts.size(); i++){
            if (allPosts.get(i).getId() == id){
                post = allPosts.get(i);
            }
        }
        model.addAttribute("post", post);
        return "posts/show";
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
