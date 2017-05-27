package com.ss.ch.controller;


import com.ss.ch.domain.User;
import com.ss.ch.service.UserService;
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
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        System.out.println(users);
        return "userslist";
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = {"/newuser"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/newuser"}, method = RequestMethod.POST)
    public String saveUser(User user, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(user);
        model.addAttribute("success", "User " + user.getName() + " " + user.getSurname() + " registered successfully");
        //return "success";
        return "registrationsuccess";
    }


    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/edit-user-{id}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable int id, ModelMap model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-user-{id}"}, method = RequestMethod.POST)
    public String updateUser(User user, BindingResult result,
                             ModelMap model, @PathVariable int id) {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.update(user);
        model.addAttribute("success", "User " + user.getName() + " " + user.getSurname() + " updated successfully");
        return "registrationsuccess";
    }

    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = {"/delete-user-{id}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id) {
        userService.delete(userService.getById(id));
        return "redirect:/list";
    }


}
