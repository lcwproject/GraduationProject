package com.graduate.laborManager.company.controller;

import com.alibaba.fastjson.JSON;
import com.graduate.laborManager.company.service.ICompanyService;
import com.graduate.laborManager.pub.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:00
 */

@Controller
@RequestMapping("company")
public class CompanyController {

    @Autowired
    ICompanyService companyService;

    @RequestMapping("/listPage")
    public String listPage(){
        return "company/list";
    }

    @RequestMapping(value = "/selectList",method = RequestMethod.POST)
    @ResponseBody
    public String selectList(){
        List<Company> companyList = new ArrayList<>();
        try{
            companyList = companyService.selectList();
        }catch (Exception e){
            e.printStackTrace();
        }

        return JSON.toJSONString(companyList);
    }

    @RequestMapping(value = "/addCompany",method = RequestMethod.POST)
    @ResponseBody
    public String addCompany(Company company){
        return "success";
    }

    @RequestMapping("/deleteCompany")
    @ResponseBody
    public String deleteCompany(@RequestParam int id){
        if(id == 1){
            return "error";
        }
        return "success";

    }

}
