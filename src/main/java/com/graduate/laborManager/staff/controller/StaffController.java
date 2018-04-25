package com.graduate.laborManager.staff.controller;

import com.alibaba.fastjson.JSON;
import com.graduate.laborManager.agreement.service.IAgreementService;
import com.graduate.laborManager.company.service.ICompanyService;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.salary.service.ISalaryService;
import com.graduate.laborManager.salary.view.SalaryView;
import com.graduate.laborManager.staff.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import sun.util.resources.cldr.ar.CalendarData_ar_OM;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:00
 */

@Controller
@SessionAttributes(value={"currentStaff"},types={Staff.class})
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    IStaffService staffService;
    @Autowired
    IAgreementService agreementService;
    @Autowired
    ICompanyService companyService;
    @Autowired
    ISalaryService salaryService;
    @RequestMapping("/listPage")
    public String listPage(){

        return "staff/list";
    }

    @RequestMapping(value = "/addStaff")
    public String addStaff(@ModelAttribute("currentCompany") Company company,
                                        @RequestParam(value = "name") String name,
                                        @RequestParam(value = "password") String password,
                                        @RequestParam(value = "phone") Integer phone,
                                        @RequestParam(value = "address") String address,
                                        @RequestParam(value = "title") String title,
                                        @RequestParam(value = "content") String content,
                                        @RequestParam(value = "start_time") Date start_time,
                                        @RequestParam(value = "end_time") Date end_time
    ) throws Exception {
        Agreement agreement = new Agreement();
        agreement.setcId(company.getId());agreement.setTitle(title);agreement.setContent(content);
        agreement.setStartTime(start_time);agreement.setStartTime(end_time);
        agreement = agreementService.insertAgreement(agreement);
        Staff staff = new Staff();
        staff.setaId(agreement.getId());staff.setcId(company.getId());
        staff.setAddress(address);staff.setPhone(phone);staff.setPassword(password);
        try {
            staff = staffService.insertStaff(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Staff> staffList = new ArrayList<>();
        staffList = staffService.queryAllStaff(company.getId());
        return JSON.toJSONString(staffList);
    }

    @RequestMapping(value = "/queryStaff")
    public String queryStaff(@ModelAttribute("currentCompany") Company company){
        List<Staff> staffList = new ArrayList<>();
        try {
            staffList = staffService.queryAllStaff(company.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(staffList);
    }

    @RequestMapping(value = "/deleteStaff")
    public String deleteStaff(@ModelAttribute("currentCompany") Company company,@RequestParam(value = "id") int id){
        List<Staff> staffList = new ArrayList<>();
        try {
            staffService.deleteStaff(id);
            staffList = staffService.queryAllStaff(company.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(staffList);
    }

    @RequestMapping(value = "/checkStaff")
    public ModelAndView checkStaff(@ModelAttribute("currentCompany") Company company, @RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
        Staff staff = new Staff();
        staff.setName(name);staff.setPassword(password);
        ModelAndView modelAndView;
        try {
            staff=staffService.checkStaff(staff);
            modelAndView = new ModelAndView("");
            modelAndView.addObject("staff",staff);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView = new ModelAndView("");
            modelAndView.addObject("error",e.getMessage());
        }
        return modelAndView;
    }
    @RequestMapping(value = "/companyInfo")
    public String companyInfo(@ModelAttribute("currentStaff") Staff staff){
        Company company = new Company();
        try {
            company= companyService.queryById(staff.getcId());
            return JSON.toJSONString(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/agreeInfo")
    public String AgreementInfo(@ModelAttribute("currentStaff") Staff staff){
        Agreement agreement = new Agreement();
        try {
            agreement= agreementService.queryById(staff.getaId());
            return JSON.toJSONString(agreement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/salaryInfo")
    public String salaryInfo(@ModelAttribute("currentStaff") Staff staff){
        List<SalaryView> salaryViewList = new ArrayList<>();
        try {
            salaryViewList= salaryService.queryMySalary(staff.getId(),staff.getcId());
            return JSON.toJSONString(salaryViewList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
