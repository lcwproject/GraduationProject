package com.graduate.laborManager.userCtr.controller;

import com.graduate.laborManager.company.service.ICompanyService;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.salary.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/25 22:18
 */
@Controller
@RequestMapping(value = "userCtr")
public class UserController {

    @Autowired
    ICompanyService companyService;

//    @Autowired
//    ISalaryService salaryService;

    @RequestMapping(value = "/queryCompanyByUser",method = RequestMethod.POST)
    @ResponseBody
    public Company queryCompanyByUser(){

        return null;
    }

    @RequestMapping(value = "queryAgreementByUser",method = RequestMethod.POST)
    @ResponseBody
    public Agreement queryAgreementByUser(){
        return null;
    }

    @RequestMapping(value = "querySalaryByUser",method = RequestMethod.POST)
    @ResponseBody
    public List<Salary> querySalaryByUser(){
        return null;
    }

}
