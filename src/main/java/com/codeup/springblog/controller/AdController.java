package com.codeup.springblog.controller;


import com.codeup.springblog.model.Ad;
import com.codeup.springblog.model.User;
import com.codeup.springblog.repositories.AdRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {
    //Repositories below
    private final AdRepository adDao; //I need to set up a property of the data access object..
    private final UserRepository userDao;

    //Services below
    private final EmailService emailService;


    public AdController(AdRepository adDao, UserRepository userDao, EmailService emailService){
        this.adDao = adDao; //every time a controller is 'built' [instantiated], make sure you create on ad data access object. .
        this.userDao = userDao;

        this.emailService = emailService;

    }

//    @GetMapping("/ads")
//    public String getAd(Model model){
//        User loggedInUser=  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        System.out.println("Hello there! The logged in user's email is " + loggedInUser.getEmail() + ", and the logged in user's username is " + loggedInUser.getUsername());
//
//
//
//        model.addAttribute("ads", adDao.findAll());
//
//
//        return "adPage";
//    }

//    @GetMapping("/ads/single")
//    public String getSingleAd(Model model){
//
//
//        model.addAttribute("ad", adDao.findByTitle("$0 MUST SEE FJ45"));
//
//
//        return "singleAdPage";
//    }

    @GetMapping("/ads/create")
    public String showCreateForm(Model model) {
        model.addAttribute("ad", new Ad());
        return "ads/create-ad";
    }

//    @PostMapping("/ads/create")
//    public String create(
//            @ModelAttribute Ad newAd
//    ) {
////        Ad ad = new Ad();
////        ad.setTitle(title);
////        ad.setDescription(description);
//
//
//        // save the ad...
//        newAd.setOwner(userDao.getById(1L)); //Go into the DB - get my one user hardcoded style :D
//        emailService.prepareAndSend(newAd, "New ad created", "Your new Ad has been created on the Spring AdLister!");
//        adDao.save(newAd);
//
//
//        return "redirect:/ads";
//    }


}