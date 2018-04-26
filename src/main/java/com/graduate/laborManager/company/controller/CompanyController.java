package com.graduate.laborManager.company.controller;

import com.alibaba.fastjson.JSON;
import com.graduate.laborManager.company.service.ICompanyService;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:00
 */

@Controller
@SessionAttributes(value={"currentStaff","currentCompany"},types={Staff.class,Company.class})
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
    public ModelAndView login(Company company){
        ModelAndView mav = null;
        try{
            Company currentCompany = companyService.Login(company.getEmail(),company.getPassword());
            mav = new ModelAndView("/company/main");
            mav.addObject("currentCompany",currentCompany);
        }catch (Exception e){
            e.printStackTrace();
            mav = new ModelAndView("registerAndLogin");
        }
        return mav;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(Company company){
        Company result=null;
        try {
            if(!companyService.checkEmail(company.getEmail())){
                return "手机号被注册";
            }
            result = companyService.register(company);
        }catch (Exception e){
            e.printStackTrace();
            return "内部错误";
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


}
