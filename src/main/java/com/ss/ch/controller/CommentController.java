package com.ss.ch.controller;


import com.ss.ch.domain.Comment;
import com.ss.ch.service.CommentService;
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

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/comments"}, method = RequestMethod.GET)
    public String listComment(ModelMap model) {
        List<Comment> comments = commentService.getAll();
        model.addAttribute("comments", comments);

        return "commentsList";
    }

    @RequestMapping(value = {"/newComment"}, method = RequestMethod.GET)
    public String newComment(ModelMap model) {
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        model.addAttribute("edit", false);
        return "addComment";
    }

    @RequestMapping(value = {"/newComment"}, method = RequestMethod.POST)
    public String saveComment(Comment comment, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "addComment";
        }

        comment.setCreatedDate(new Date());
        comment.setUser(userService.getById(1));
        commentService.save(comment);
        model.addAttribute("success", "Comment " + comment.getComment() + " " + " registered successfully");

        return "registrationsuccess";
    }

    @RequestMapping(value = {"/edit-comment-{id}"}, method = RequestMethod.GET)
    public String editComment(@PathVariable int id, ModelMap model) {
        Comment comment = commentService.getById(id);
        model.addAttribute("comment", comment);
        model.addAttribute("edit", true);
        return "addComment";
    }

    @RequestMapping(value = {"/edit-comment-{id}"}, method = RequestMethod.POST)
    public String updateComment(Comment comment, BindingResult result,
                             ModelMap model, @PathVariable int id) {
        if (result.hasErrors()) {
            return "registration";
        }
        commentService.update(comment);
        model.addAttribute("success", "comment " + comment.getComment() + " " +  " updated successfully");
        return "redirect:/comments";
    }

    @RequestMapping(value = {"/delete-comment-{id}"}, method = RequestMethod.GET)
    public String deleteComment(@PathVariable int id) {
        commentService.delete(commentService.getById(id));
        return "redirect:/comments";
    }


}
