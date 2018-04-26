package com.graduate.laborManager.salary.controller;

import com.alibaba.fastjson.JSON;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.salary.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:00
 */

@Controller
@SessionAttributes(value={"currentStaff","currentCompany"},types={Staff.class,Company.class})
@RequestMapping("salary")
public class SalaryController {

    ISalaryService salaryService;

    @Autowired
    public SalaryController(ISalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @RequestMapping("/listCompany")
    public String listCompanyPage(){
        return "/company/salary/list";
    }

    @RequestMapping("/querySalaryByStaff")
    @ResponseBody
    public String querySalaryByStaff(@SessionAttribute("currentStaff") Staff staff){
        List<Salary> salaryList = new ArrayList<>();
        try{
            salaryList = salaryService.queryByStaff(staff);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JSON.toJSONString(salaryList);
    }

    @RequestMapping("/querySalaryByCompany")
    @ResponseBody
    public String querySalaryByCompany(@SessionAttribute("currentCompany") Company company){
        List<Salary> salaryList = new ArrayList<>();
        try{
            salaryList = salaryService.queryByCompany(company);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JSON.toJSONString(salaryList);
    }

    @RequestMapping("/addSalary")
    @ResponseBody
    public String addSalary(@SessionAttribute("currentCompany") Company company,
                            Salary salary, @RequestParam(value = "staffId") String staffId){
        Salary result = null;
        try{
            result = salaryService.addSalary(salary,staffId);
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
        return result==null?"新增失败":"0";
    }

}
