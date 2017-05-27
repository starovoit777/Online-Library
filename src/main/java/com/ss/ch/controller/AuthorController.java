package com.ss.ch.controller;

import com.ss.ch.domain.Author;
import com.ss.ch.service.AuthorService;
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
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/authors"}, method = RequestMethod.GET)
    public String listAuthors(ModelMap model) {
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "authorsList";
    }


    @RequestMapping(value = {"/addAuthor"}, method = RequestMethod.GET)
    public String newAuthor(ModelMap model) {
        Author author = new Author();
        model.addAttribute("author", author);
        model.addAttribute("edit", false);
        return "addAuthor";
    }

    @RequestMapping(value = {"/addAuthor"}, method = RequestMethod.POST)
    public String saveAuthor(Author author, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "addAuthor";
        }

//      FieldError ssoError = new FieldError("user", "id", messageSource.getMessage("non.unique.id", new String[]{author.getName()}, Locale.getDefault()));
//      result.addError(ssoError);

        authorService.save(author);
        model.addAttribute("success", "User " + author.getName() + " " + author.getSurname() + " registered successfully");

        return "registrationsuccess";
    }

    @RequestMapping(value = {"/edit-author-{id}"}, method = RequestMethod.GET)
    public String editAuthor(@PathVariable int id, ModelMap model) {
        Author author = authorService.getById(id);
        model.addAttribute("author", author);
        model.addAttribute("edit", true);
        return "addAuthor";
    }

    @RequestMapping(value = {"/edit-author-{id}"}, method = RequestMethod.POST)
    public String updateAuthor(Author author, BindingResult result, ModelMap model, @PathVariable int id) {
        if (result.hasErrors()) {
            return "addAuthor";
        }

        authorService.update(author);
        model.addAttribute("success", "User " + author.getName() + " " + author.getSurname() + " updated successfully");
        return "authors";
    }

    @RequestMapping(value = {"/delete-author-{id}"}, method = RequestMethod.GET)
    public String deleteAuthor(@PathVariable int id) {
        authorService.delete(authorService.getById(id));
        return "redirect:/authors";
    }


}
