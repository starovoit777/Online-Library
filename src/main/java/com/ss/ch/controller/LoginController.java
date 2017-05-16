package com.ss.ch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Micro on 5/10/2017.
 */

@Controller
public class LoginController {

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }


    @RequestMapping(value="userCheck", method = RequestMethod.POST)
    public String userCheck(ModelMap model, HttpServletRequest request) {
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        if("concretepage".equalsIgnoreCase(name)&&"concretepage".equalsIgnoreCase(pwd)){
            model.addAttribute("message", "Successfully logged in.");

        }else{
            model.addAttribute("message", "Username or password is wrong.");
        }
        return "redirect:success";
    }

}