package com.graduate.laborManager.salary.controller;

import com.alibaba.fastjson.JSON;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.salary.service.ISalaryService;
import com.graduate.laborManager.salary.view.SalaryView;
import com.graduate.laborManager.staff.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
@RequestMapping("/salary")
public class SalaryController {

    ISalaryService salaryService;
    IStaffService staffService;

    public SalaryController(ISalaryService salaryService, IStaffService staffService) {
        this.salaryService = salaryService;
        this.staffService = staffService;
    }

    @Autowired


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
        List<SalaryView> salaryList = new ArrayList<>();
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
                            Salary salary, @RequestParam(value = "phone") String phone){
        Salary result = null;
        try{
            salary.setCompanyId(company.getCompanyId());
            List<Staff> staffs = staffService.selectByCompany(company);
            for(Staff s:staffs){
                if(s.getPhone().equals(phone)){
                    result = salaryService.addSalary(salary,s.getStaffId());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        return result==null?"新增失败":"0";
    }

    @RequestMapping("/addSalaryByFile")
    @ResponseBody
    public String addSalaryByFile(@SessionAttribute("currentCompany") Company company,HttpServletRequest request,
                            @RequestParam("file") MultipartFile file){
        List <Salary> result = new ArrayList<>();
        if (!file.isEmpty()){
            String path = request.getServletContext().getRealPath(File.separator+"upload"+File.separator);
            String filename = file.getOriginalFilename();
            File myfile = new File(path,filename);
            //判断文件是否存在
            if (!myfile.getParentFile().exists()) {
                myfile.getParentFile().mkdirs();
            }
            try {
                file.transferTo(myfile);
                result=salaryService.addSalaryByFile(myfile,company.getCompanyId());
            } catch (Exception e) {
                e.printStackTrace();
                return "新增失败";
            }
        }
        return result==null?"新增失败":"0";
    }

}
