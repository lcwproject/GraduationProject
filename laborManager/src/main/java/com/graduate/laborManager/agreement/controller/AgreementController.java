package com.graduate.laborManager.agreement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:00
 */

@Controller
@RequestMapping("agreement")
public class AgreementController {

    @RequestMapping("/listPage")
    public String listPage(){
        return "agreement/list";
    }

}
