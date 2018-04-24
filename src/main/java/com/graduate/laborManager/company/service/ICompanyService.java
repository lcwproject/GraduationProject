package com.graduate.laborManager.company.service;

import com.graduate.laborManager.agreement.view.AgreementView;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.salary.view.SalaryView;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 17:30
 */

public interface ICompanyService {
    //公司相关操作
    public Company checkCompany(Company company)throws  Exception;
    public List<Company> selectList() throws Exception;
    public List<Company> queryByIndex(String index) throws Exception;
    public Company queryById(int id) throws Exception;
    public Company insertCompany(Company company) throws  Exception;
    public void deleteCompany(int company_id)throws Exception;

    //劳务派遣协议相关
    public List<AgreementView> queryAgreement (int company_id)throws Exception;
    public List<AgreementView> addAgreement(int company_id,Agreement agreement) throws  Exception;
    public List<AgreementView> alarmAgreement(int company_id)throws Exception;
    public AgreementView queryMyAgreement(int s_id)throws Exception;

    //员工信息相关
    public List<Staff> listStaff(int company_id) throws Exception;
    public List<Staff> addStaff(Staff staff) throws Exception;
    public List<Staff> deleteStaff(int id) throws Exception;

    //薪水相关
    public List<SalaryView> addSingleSalary(Salary salary)throws Exception;
    public List<SalaryView> queryMySalary(int s_id)throws Exception;
    public List<SalaryView> queryCompanySalary(int c_id)throws Exception;
}
