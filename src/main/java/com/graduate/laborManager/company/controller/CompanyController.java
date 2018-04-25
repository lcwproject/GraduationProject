package com.graduate.laborManager.company.controller;

import com.alibaba.fastjson.JSON;
import com.graduate.laborManager.company.service.ICompanyService;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
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

    @RequestMapping("/listPage")
    public String listPage(){
        return "company/list";
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
    @RequestMapping("/login,method = RequestMethod.POST")
    public ModelAndView login(Company companyInfo){
        Company currentCompany = new Company();
        try {
            companyInfo = companyService.checkCompany(companyInfo);
        } catch (Exception e) {
            e.printStackTrace();
            ModelAndView modelAndView = null;
            modelAndView = new ModelAndView("login");
        }
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("company/index");
        return modelAndView;
    }
    @RequestMapping("/register,method = RequestMethod.POST")
    public ModelAndView register(Company companyInfo){
        ModelAndView modelAndView = null;
        try {
             companyService.insertCompany(companyInfo);
             modelAndView = new ModelAndView("login");
             modelAndView.addObject("message","注册成功，请登录");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView = new ModelAndView("register");
            modelAndView.addObject("message","注册失败，用户已存在");
        }
        return modelAndView;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "id") int id){
        List<Company> companyList = new ArrayList<>();
        try {
            companyService.deleteCompany(id);
            companyList = companyService.selectList();
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return JSON.toJSONString(companyList);
    }
}
