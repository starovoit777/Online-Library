package com.ss.ch.controller;


import com.ss.ch.domain.Genre;
import com.ss.ch.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Locale;

@Controller
public class GenreController {

    @Autowired
    GenreService genreService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/genres"}, method = RequestMethod.GET)
    public String listGenres(ModelMap model) {
        List<Genre> genres = genreService.getAll();
        model.addAttribute("genres", genres);
        System.out.println(genres);
        return "genresList";
    }

    @RequestMapping(value = {"/newgenre"}, method = RequestMethod.GET)
    public String newGenre(ModelMap model) {
        Genre genre = new Genre();
        model.addAttribute("genre", genre);
        model.addAttribute("edit", false);
        return "addGenre";
    }

    @RequestMapping(value = {"/newgenre"}, method = RequestMethod.POST)
    public String saveGenre(Genre genre, BindingResult result,
                           ModelMap model) {
        if (result.hasErrors()) {
            return "newgenre";
        }

        genreService.save(genre);
        model.addAttribute("success", "Genre " + genre.getName() + " "  + " add successfully");
        //return "success";
        return "registrationsuccess";
    }

    @RequestMapping(value = {"/edit-genre-{id}"}, method = RequestMethod.GET)
    public String editGenre(@PathVariable int id, ModelMap model) {
        Genre genre = genreService.getById(id);
        model.addAttribute("genre", genre);
        model.addAttribute("edit", true);
        return "addGenre";
    }

    @RequestMapping(value = {"/edit-genre-{id}"}, method = RequestMethod.POST)
    public String updateGenre(Genre genre, BindingResult result,
                             ModelMap model, @PathVariable int id) {
        if (result.hasErrors()) {
            return "addGenre";
        }
        genreService.update(genre);
        model.addAttribute("success", "Genre " + genre.getName() + " " + " updated successfully");
        return "registrationsuccess";
    }

    @RequestMapping(value = {"/delete-genre-{id}"}, method = RequestMethod.GET)
    public String deleteGenre(@PathVariable int id) {
        genreService.delete(genreService.getById(id));
        return "redirect:/genres";
    }


}
