package com.codeup.springblog.controller;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.PostDetails;
import com.codeup.springblog.model.PostImage;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

//    public List<Post> generatePosts(){
//        List<Post> allPosts = new ArrayList<>();
//        Post post1 = new Post(1, "First post", "This is my first post!");
//        Post post2 = new Post(2, "Another post!", "Amazing content!");
//        Post post3 = new Post(3, "Third post", "Fascinating information!");
//        allPosts.add(post1);
//        allPosts.add(post2);
//        allPosts.add(post3);
//        return allPosts;
//    }


//    @GetMapping("/posts")
//    public String allPosts(Model model){
//        List<Post> allPosts = generatePosts();
//        model.addAttribute("allPosts", allPosts);
//        return "posts/index";
//    }

//    @GetMapping("/posts")
//    public String allPosts(Model model){
//        List<Post> allPosts = postDao.findAll();
//        model.addAttribute("allPosts", allPosts);
//        return "posts/index";
//    }

    @GetMapping("/posts")
    @ResponseBody
    public List<Post> returnPost() {
        return postDao.findAll();
    }

    @GetMapping("/posts/history/{id}")
    @ResponseBody
    public String detailsPost(@PathVariable long id, Model model){
        Post history = postDao.findById(id);
        model.addAttribute("history", history);
        return "post/show";
    }


    @GetMapping("/posts/index")
    public String indexPage(){
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model){
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String create(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreate(@RequestParam(name="title") String title, @RequestParam(name="body") String body){
        Post post = new Post(title, body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/add-image")
    public String addImage(
            @PathVariable long id,
            @RequestParam String imageTitle,
            @RequestParam String url,
            @RequestParam(defaultValue = "false") boolean isDestroyed) {

        Post pet = postDao.getById(id);
        PostImage toy = new PostImage(imageTitle, url, pet);
        List<PostImage> chewToys = pet.getPostImages();
        chewToys.add(toy);
        pet.setPostImages(chewToys);
        postDao.save(pet);
        return "redirect:/posts";
    }

}