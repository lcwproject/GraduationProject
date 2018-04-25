package com.graduate.laborManager.company.service.impl;

import com.graduate.laborManager.agreement.view.AgreementView;
import com.graduate.laborManager.company.service.ICompanyService;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.IAgreementDao;
import com.graduate.laborManager.pub.dao.ICompanyDao;
import com.graduate.laborManager.pub.dao.ISalaryDao;
import com.graduate.laborManager.pub.dao.IStaffDao;
import com.graduate.laborManager.salary.view.SalaryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 17:30
 */

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    ICompanyDao companyDao;

    @Autowired
    ISalaryDao salaryDao;
    @Autowired
    IStaffDao staffDao;

    @Override
    public Company checkCompany(Company company) throws Exception {
        return companyDao.checkCompany(company);
    }

    @Override
    public List<Company> selectList() throws Exception {
        return companyDao.selectList(null,null,null);
    }

    @Override
    public List<Company> queryByIndex(String index) throws Exception {
        if(index!=null && !index.equals("")){
            List<Company> companyList = companyDao.queryByIndex(index);
            return companyList;
        }
        return null;
    }

    @Override
    public Company queryById(int id) throws Exception {
        return companyDao.queryById(id);
    }

    @Override
    public Company insertCompany(Company company) throws Exception {
        Company new_company = new Company();
        if(companyDao.checkCompany(company)==null){
            new_company =companyDao.insertCompany(company);
        }
        return new_company;
    }

    @Override
    public void deleteCompany(int company_id) throws Exception {
        companyDao.deleteCompany(company_id);
    }

    @Override
    public List<AgreementView> queryAgreement(int company_id) throws Exception {
        return null;
    }

    @Override
    public List<AgreementView> addAgreement(int company_id, Agreement agreement) throws Exception {
        return null;
    }

    @Override
    public List<AgreementView> alarmAgreement(int company_id) throws Exception {
        return null;
    }

    @Override
    public AgreementView queryMyAgreement(int s_id) throws Exception {
        return null;
    }

    @Override
    public List<Staff> listStaff(int company_id) throws Exception {
        return null;
    }

    @Override
    public List<Staff> addStaff(Staff staff) throws Exception {
        return null;
    }

    @Override
    public List<Staff> deleteStaff(int id) throws Exception {
        return null;
    }

    @Override
    public List<SalaryView> addSingleSalary(Salary salary) throws Exception {
        return null;
    }

    @Override
    public List<SalaryView> queryMySalary(int s_id) throws Exception {
        return null;
    }

    @Override
    public List<SalaryView> queryCompanySalary(int c_id) throws Exception {
        return null;
    }
}
