package com.ss.ch.controller;


import com.ss.ch.domain.Comment;
import com.ss.ch.service.CommentService;
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
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    MessageSource messageSource;

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/comments"}, method = RequestMethod.GET)
    public String listComment(ModelMap model) {
        List<Comment> comments = commentService.getAll();
        model.addAttribute("comments", comments);
        System.out.println(comments);
        return "commentsList";
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = {"/newComment"}, method = RequestMethod.GET)
    public String newComment(ModelMap model) {
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        model.addAttribute("edit", false);
        return "addComment";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/newComment"}, method = RequestMethod.POST)
    public String saveComment(Comment comment, BindingResult result,
                           ModelMap model) {
        if (result.hasErrors()) {
            return "registration";
        }
        if (commentService.getById(comment.getId()) != null) {
            FieldError ssoError = new FieldError("comment", "id", messageSource.getMessage("non.unique.id", new String[]{comment.getComment()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }
        commentService.save(comment);
        model.addAttribute("success", "User " + comment.getComment() + " " + " registered successfully");
        //return "success";
        return "registrationsuccess";
    }


    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/edit-comment-{id}"}, method = RequestMethod.GET)
    public String editComment(@PathVariable int id, ModelMap model) {
        Comment comment = commentService.getById(id);
        model.addAttribute("comment", comment);
        model.addAttribute("edit", true);
        return "addComment";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-comment-{id}"}, method = RequestMethod.POST)
    public String updateComment(Comment comment, BindingResult result,
                             ModelMap model, @PathVariable int id) {
        if (result.hasErrors()) {
            return "registration";
        }
        commentService.update(comment);
        model.addAttribute("success", "comment " + comment.getComment() + " " +  " updated successfully");
        return "addComment";
    }

    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = {"/delete-comment-{id}"}, method = RequestMethod.GET)
    public String deleteComment(@PathVariable int id) {
        commentService.delete(commentService.getById(id));
        return "redirect:/commentslist";
    }


}
