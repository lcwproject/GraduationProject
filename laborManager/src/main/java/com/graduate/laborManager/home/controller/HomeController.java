package com.graduate.laborManager.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 15:01
 */
@Controller
@RequestMapping("home")
public class HomeController {

    @RequestMapping("/homePage")
    public String dashborad(){
        return "home/home";
    }

}
