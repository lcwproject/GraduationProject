package com.graduate.laborManager.agreement.controller;

import com.alibaba.fastjson.JSON;
import com.graduate.laborManager.agreement.service.IAgreementService;
import com.graduate.laborManager.agreement.view.AgreementView;
import com.graduate.laborManager.pub.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("agreement")
public class AgreementController {
    @Autowired
    IAgreementService agreementService;

    @RequestMapping(value = "/listPage")
    public String listPage(){
        return "agreement/list";
    }
    //界面跳转
    @RequestMapping(value = "/companyAgreements")
    public ModelAndView CompanyList(@ModelAttribute("currentCompany") Company company)  {
        List<AgreementView> agreementViewList = new ArrayList<>();
        ModelAndView modelAndView;
        try {
            agreementViewList=agreementService.queryAllAgreement(company.getId());
            modelAndView =new ModelAndView("agreement/agreementList");
            modelAndView.addObject("agreementList",agreementViewList);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView =new ModelAndView("agreement/agreementList");
        }
        return modelAndView;
    }
    //新增Agreement不单独作为请求，在添加用户时实现的添加agreement
    @RequestMapping(value = "/alarmAgreements")
    public String AlarmAgreement(@ModelAttribute("currentCompany") Company company){
        List<AgreementView> alarmAgreementViewList = new ArrayList<>();
        try {
            alarmAgreementViewList = agreementService.queryAlarmAgreement(company.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(alarmAgreementViewList);
    }

}
