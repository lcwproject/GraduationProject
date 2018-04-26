package com.graduate.laborManager.agreement.controller;

import com.alibaba.fastjson.JSON;
import com.graduate.laborManager.agreement.service.IAgreementService;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:00
 */

@Controller
@SessionAttributes(value={"currentStaff","currentCompany"},types={Staff.class,Company.class})
@RequestMapping("agreement")
public class AgreementController {

    private IAgreementService agreementService;

    @Autowired
    public AgreementController(IAgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @RequestMapping(value = "/listAdmin")
    public String listAdminPage(){
        return "/admin/agreement/list";
    }

    @RequestMapping(value = "/listCompany")
    public String listCompanyPage(){
        return "/company/agreement/list";
    }

    @RequestMapping(value = "/queryAgreementByStaff",method = RequestMethod.POST)
    @ResponseBody
    public String queryCompanyByStaff(@SessionAttribute("currentStaff") Staff staff){
        Agreement agreement = new Agreement();
        try{
            agreement = agreementService.queryByStaff(staff);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(agreement!=null) {
            return JSON.toJSONString(agreement);
        }else{
            return null;
        }
    }

}
