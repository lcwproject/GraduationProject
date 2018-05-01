package com.graduate.laborManager.company.controller;

import com.alibaba.fastjson.JSON;
import com.graduate.laborManager.company.service.ICompanyService;
import com.graduate.laborManager.pub.bean.Admin;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@SessionAttributes(value={"currentStaff","currentCompany","admin"},types={Staff.class,Company.class, Admin.class})
@RequestMapping("company")
public class CompanyController {

    private ICompanyService companyService;

    @Autowired
    public CompanyController(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/listAdmin")
    public String listCompanyPage(){
        return "/admin/company/list";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(Company company, SessionStatus sessionStatus){
        ModelAndView mav = null;
        try{
            Company currentCompany = companyService.Login(company.getEmail(),company.getPassword());
            mav = new ModelAndView("/company/main");
            mav.addObject("currentCompany",currentCompany);
        }catch (Exception e){
            e.printStackTrace();
            mav = new ModelAndView("registerAndLogin");
            mav.addObject("loginErrorMsg",e.getMessage());
            sessionStatus.setComplete();
        }
        return mav;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(Company company){
        Company result=null;
        try {
            result = companyService.insertCompany(company);
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        return result==null?"注册失败":"0";
    }

    @RequestMapping(value = "/queryCompanyByStaff",method = RequestMethod.POST)
    @ResponseBody
    public String queryCompanyByStaff(@SessionAttribute("currentStaff") Staff staff){
        Company company = new Company();
        try{
            company = companyService.queryByStaff(staff);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(company!=null) {
            return JSON.toJSONString(company);
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/queryCompanyByAdmin" ,method = RequestMethod.POST)
    @ResponseBody
    public String queryCompanyByAdmin(@SessionAttribute("admin") Admin admin){
        List<Company> companyList = new ArrayList<>();
        try{
            companyList = companyService.queryByAdmin();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(companyList!=null && companyList.size()>0 ) {
            return JSON.toJSONString(companyList);
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/addCompany",method = RequestMethod.POST)
    @ResponseBody
    public String addCompany(@SessionAttribute("admin") Admin admin,Company company){
        Company result=null;
        try {
            result = companyService.insertCompany(company);
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        return result==null?"加入失败":"0";
    }

    @RequestMapping(value = "/deleteCompany",method = RequestMethod.POST)
    @ResponseBody
    public String deleteCompany(@SessionAttribute("admin") Admin admin,String id){
        try {
            companyService.deleteCompany(id);
        }catch (Exception e){
            e.printStackTrace();
            return "内部错误";
        }
        return "0";
    }

}
