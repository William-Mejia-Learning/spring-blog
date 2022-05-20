package com.codeup.springblog.controller;

import com.codeup.springblog.model.Movie;
import com.codeup.springblog.repositories.MoviesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private MoviesRepository moviesDao;

    public MovieController(MoviesRepository moviesDao) {
        this.moviesDao = moviesDao;
    }

    @GetMapping
    public String showMovies(Model model){

        model.addAttribute("movies", moviesDao.findAll());
        return "movies/index";
    }



    @GetMapping("/create")
    public String createMovie(Model model){
        model.addAttribute("movie", new Movie());
        return "movies/create";
    }

    @PostMapping("/create")
    public String doCreateMovie(
            @ModelAttribute Movie movie
    ){
        moviesDao.save(movie);
        return "redirect:/movies";
    }

    // Update
    @GetMapping("/update/{id}")
    public String updateMovie(
            @PathVariable long id,
            Model model) {

        model.addAttribute("movie", moviesDao.getById(id));

        // TODO: Populate a form like the Create form, such that
        // it will allow you to update an existing movie.
        return "movies/create";
    }

    @PostMapping("/update")
    public String doUpdateMovie(
            @ModelAttribute Movie movie
    ) {

        moviesDao.save(movie);

        return "redirect:/movies";
    }


    // Delete
    @PostMapping("/delete")
    public String deleteMovie(
            @RequestParam(name="id") long id
    ) {
        // TODO: Add button to the movies index page that will delete the items
        // TODO: button should be in a form, value will be the id of the item.
        // TODO: Send the user back to to the main page.

        moviesDao.deleteById(id);

        return "redirect:/movies";
    }


}
