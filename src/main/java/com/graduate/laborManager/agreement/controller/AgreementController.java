package com.graduate.laborManager.agreement.controller;

import com.alibaba.fastjson.JSON;
import com.graduate.laborManager.agreement.service.IAgreementService;
import com.graduate.laborManager.agreement.view.AgreementView;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
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
@RequestMapping("/agreement")
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
        return JSON.toJSONString(agreement);
    }

    @RequestMapping("/queryAgreementByCompany")
    @ResponseBody
    public String queryAgreementByCompany(@SessionAttribute("currentCompany") Company company){

        List<AgreementView> agreementList = new ArrayList<>();
        try{
            agreementList = agreementService.queryByCompany(company);
            System.out.println(agreementList.get(0).getStaffName());
        }catch (Exception e){
            e.printStackTrace();
        }
        return JSON.toJSONString(agreementList);
    }

    @RequestMapping("/queryAlarmAgreementByCompany")
    @ResponseBody
    public String queryAlarmAgreementByCompany(@SessionAttribute("currentCompany") Company company){
        List<AgreementView> agreementList = new ArrayList<>();
        try{
            agreementList = agreementService.queryByCompany(company);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JSON.toJSONString(agreementList);
    }

    @RequestMapping("/addAgreement")
    @ResponseBody
    public String addAgreement(@SessionAttribute("currentCompany") Company company,
                  Agreement agreement, @RequestParam(value = "staffId") String staffId){
        Agreement result = null;
        try{
            result = agreementService.addAgreement(agreement,company,staffId);
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
        return result==null?"创建失败":"0";
    }

    @RequestMapping(value = "/deleteCompany",method = RequestMethod.POST)
    @ResponseBody
    public String deleteAgreement(@SessionAttribute("currentCompany") Company company,String id){
        try {
            agreementService.deleteAgreement(id);
        }catch (Exception e){
            e.printStackTrace();
            return "内部错误";
        }
        return "0";
    }

}
