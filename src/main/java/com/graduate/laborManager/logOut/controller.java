package com.graduate.laborManager.logOut;

import com.graduate.laborManager.pub.bean.Admin;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
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
 * @time: 2018/4/27 1:19
 */

@Controller
@SessionAttributes(value={"currentStaff","currentCompany","admin"},types={Staff.class,Company.class, Admin.class})
@RequestMapping(value = "allUser")
public class controller {

    @RequestMapping(value = "/logOut",method = RequestMethod.GET)
    public ModelAndView loginOut(SessionStatus sessionStatus){
        ModelAndView mav = new ModelAndView("registerAndLogin");
        sessionStatus.setComplete();
        return mav;
    }

}
