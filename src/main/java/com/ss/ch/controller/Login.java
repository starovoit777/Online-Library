//package com.ss.ch.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * Created by Micro on 5/10/2017.
// */
//@Controller
//public class Login {
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String printWelcome() {
//        return "login";
//
//    }
//
//    @RequestMapping(value = "/security_check", method = RequestMethod.POST)
//    @ResponseBody
//    public String securityCheck(@PathVariable("j_username") String j_username, @PathVariable("j_password") String j_password) {
//
//        System.out.println(j_username);
//
//        System.out.println(j_password);
//        return "login";
//
//    }
//
//}
