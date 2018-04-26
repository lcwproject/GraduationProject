package com.graduate.laborManager.admin.controller;

import com.graduate.laborManager.admin.service.IAdminService;
import com.graduate.laborManager.pub.bean.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 18:34
 */

@Controller
@SessionAttributes(value={"admin"},types={Admin.class})
@RequestMapping("admin")
public class AdminCtr {

    private IAdminService adminService;

    @Autowired
    public AdminCtr(IAdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(Admin admin, SessionStatus sessionStatus){
        ModelAndView mav = null;
        try{
            Admin result = adminService.Login(admin.getName(),admin.getPassword());
            mav = new ModelAndView("/admin/main");
            mav.addObject("admin",result);
        }catch (Exception e){
            e.printStackTrace();
            mav = new ModelAndView("registerAndLogin");
            sessionStatus.setComplete();
        }
        return mav;
    }

}
