package com.codeup.springblog.controller;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String allPosts(Model model){
        List<Post> allPosts = postDao.findAll();
        model.addAttribute("allPosts", allPosts);
        return "posts/index";
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
    public String create(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreate(@Valid @ModelAttribute Post post, Errors validation, Model model){

        if(post.getTitle().length() < 3 || post.getBody().isEmpty()){
            validation.rejectValue(
                    "title",
                    "post.title",
                    "Error creating post"
            );
            }
            if (validation.hasErrors()) {
                model.addAttribute("errors", validation);
                model.addAttribute("post", post);
                return "posts/create";
            }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long userId = user.getId();

                // save the ad...
        post.setUser(userDao.getById(userId)); //Go into the DB - get my one user hardcoded style :D
        emailService.prepareAndSend(post, "New Post was created", "Your new Post has been created on the Spring AdLister!");

        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String postPost(@ModelAttribute Post post){
        postDao.save(post);

        return "redirect:/posts";
    }

    // Delete
    @PostMapping("/posts/{id}/delete")
    public String deletePost(
            @PathVariable long id
    ) {
        postDao.deleteById(id);

        return "redirect:/posts";
    }

}
