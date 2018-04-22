package com.graduate.laborManager.salary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:00
 */

@Controller
@RequestMapping("salary")
public class SalaryController {

    @RequestMapping("/listPage")
    public String listPage(){
        return "salary/list";
    }

}
