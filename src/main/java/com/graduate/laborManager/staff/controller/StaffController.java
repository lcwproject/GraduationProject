package com.graduate.laborManager.staff.controller;

import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.staff.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:00
 */

@Controller
@SessionAttributes(value={"currentStaff","currentCompany"},types={Staff.class,Company.class})
@RequestMapping("/staff")
public class StaffController {

    private IStaffService staffService;

    @Autowired
    public StaffController(IStaffService staffService) {
        this.staffService = staffService;
    }

    @RequestMapping(value = "/listAdmin")
    public String listAdminPage(){
        return "/admin/staff/list";
    }

    @RequestMapping(value = "/listCompany")
    public String listCompanyPage(){
        return "/company/staff/list";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(Staff staff){
        ModelAndView mav = null;
        try{
            Staff currentStaff = staffService.Login(staff.getPhone(),staff.getPassword());
            mav = new ModelAndView("/user/index");
            mav.addObject("currentStaff",currentStaff);
        }catch (Exception e){
            e.printStackTrace();
            mav = new ModelAndView("registerAndLogin");
        }
        return mav;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(Staff staff){
        Staff result=null;
        try {
            result = staffService.register(staff);
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
        return result==null?"注册失败":"0";
    }

}
