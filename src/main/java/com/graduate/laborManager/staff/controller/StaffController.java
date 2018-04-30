package com.graduate.laborManager.staff.controller;

import com.alibaba.fastjson.JSON;
import com.graduate.laborManager.agreement.service.IAgreementService;
import com.graduate.laborManager.pub.bean.Admin;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.staff.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

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
@SessionAttributes(value={"currentStaff","currentCompany","admin"},types={Staff.class,Company.class, Admin.class})
@RequestMapping("/staff")
public class StaffController {

    private IStaffService staffService;
    private IAgreementService agreementService;


    public StaffController(IStaffService staffService, IAgreementService agreementService) {
        this.staffService = staffService;
        this.agreementService = agreementService;
    }

    @Autowired


    @RequestMapping(value = "/listAdmin")
    public String listAdminPage(){
        return "/admin/staff/list";
    }

    @RequestMapping(value = "/listCompany")
    public String listCompanyPage(){
        return "/company/staff/list";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(Staff staff, SessionStatus sessionStatus){
        ModelAndView mav = null;
        try{
            Staff currentStaff = staffService.Login(staff.getPhone(),staff.getPassword());
            mav = new ModelAndView("/user/index");
            mav.addObject("currentStaff",currentStaff);
        }catch (Exception e){
            e.printStackTrace();
            mav = new ModelAndView("registerAndLogin");
            sessionStatus.setComplete();
        }
        return mav;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(Staff staff){
        Staff result=null;
        try {
            result = staffService.insertStaff(staff,null);
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
        return result==null?"注册失败":"0";
    }

    @RequestMapping(value = "/addStaff",method = RequestMethod.POST)
    @ResponseBody
    public String addStaff(@SessionAttribute("currentCompany") Company company, Staff staff, Agreement agreement){
        Staff result=null;
        try {
            result=staffService.insertStaff(staff,company.getCompanyId());

            agreementService.addAgreement(agreement,company,result.getStaffId());
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
        return result==null?"加入失败":"0";
    }

    @RequestMapping(value = "/deleteStaff",method = RequestMethod.POST)
    @ResponseBody
    public String deleteStaff(@SessionAttribute("currentCompany") Company company,String id){
        try {
            staffService.deleteStaff(id);
        }catch (Exception e){
            e.printStackTrace();
            return "内部错误";
        }
        return "0";
    }

    @RequestMapping(value = "/queryStaffByAdmin" ,method = RequestMethod.POST)
    @ResponseBody
    public String queryCompanyByAdmin(@SessionAttribute("admin") Admin admin){
        List<Staff> staffList = new ArrayList<>();
        try{
            staffList = staffService.selectByAdmin();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(staffList!=null && staffList.size()>0 ) {
            return JSON.toJSONString(staffList);
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/queryStaffByCompany" ,method = RequestMethod.POST)
    @ResponseBody
    public String queryCompanyByCompany(@SessionAttribute("currentCompany") Company company){
        List<Staff> staffList = new ArrayList<>();
        System.out.println("1111111:");
        try{
            staffList = staffService.selectByCompany(company);
            System.out.println("1111111:"+staffList.size());
        }catch (Exception e){
            e.printStackTrace();
        }
        if(staffList!=null && staffList.size()>0 ) {
            return JSON.toJSONString(staffList);
        }else{
            return null;
        }
    }

}
