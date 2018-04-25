package com.graduate.laborManager.company.controller;

import com.alibaba.fastjson.JSON;
import com.graduate.laborManager.company.service.ICompanyService;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:00
 */

@Controller
@SessionAttributes(value={"currentCompany"},types={Company.class})
@RequestMapping("company")
public class CompanyController {

    @Autowired
    ICompanyService companyService;

    @RequestMapping("/listAdmin")
    public String listCompanyPage(){
        return "/admin/company/list";
    }

    @RequestMapping("/selectList")
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

    @RequestMapping("/queryByIndex")
    @ResponseBody
    public String queryByIndex(@RequestParam(value = "index") String index){
        List<Company> companyList = new ArrayList<>();
        try {
            companyList = companyService.queryByIndex(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(companyList);
    }

    @RequestMapping("/queryById")
    public ModelAndView queryById(@RequestParam(value = "id") int id){
        Company company = new Company();
        try {
            company = companyService.queryById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("company/detail");
        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(Company companyInfo){
        Company currentCompany = new Company();
        ModelAndView modelAndView;
        try {
            companyInfo = companyService.checkCompany(companyInfo);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView = new ModelAndView("registerAndLogin");
            return modelAndView;
        }
        if(companyInfo!=null){
            modelAndView = new ModelAndView("company/main");
            modelAndView.addObject("currentCompany",currentCompany);
        }else {
            modelAndView = new ModelAndView("registerAndLogin");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(Company companyInfo){
        try {
             companyService.insertCompany(companyInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
        return "0";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "id") int id){
        List<Company> companyList = new ArrayList<>();
        try {
            companyService.deleteCompany(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}
