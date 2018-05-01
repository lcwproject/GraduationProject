package com.graduate.laborManager.agreement.service;

import com.graduate.laborManager.agreement.view.AgreementView;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;

import java.util.List;



public interface IAgreementService {

    public Agreement queryByStaff(Staff staff) throws Exception ;

    public List<AgreementView> queryByCompany(Company company) throws Exception ;

    public List<AgreementView> queryAlarmByCompany(Company company) throws Exception ;

    public Agreement addAgreement(Agreement agreement,Company company,String staffId) throws Exception ;

    public void deleteAgreement(String id) throws Exception ;

}
