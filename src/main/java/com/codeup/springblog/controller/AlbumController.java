package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    @GetMapping
    @ResponseBody
    public String allAlbums(){
        return "This where you would view all the albums";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String showOneAlbum(@PathVariable long id){
        return "This is an album, with the id " + id;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createAlbumsForm(){
        return "where you create an album";
    }

    @PostMapping
    @ResponseBody
    public String createAlbum(){
        return "This is where the logic would be for when the create album form is submitted";
    }

}
