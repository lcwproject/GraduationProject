package com.graduate.laborManager.company.service.impl;

import com.graduate.laborManager.agreement.service.IAgreementService;
import com.graduate.laborManager.company.service.ICompanyService;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.ICompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 14:51
 */

@Service
public class CompanyServiceImpl implements ICompanyService {

    private ICompanyDao companyDao;

    private IAgreementService agreementService;

    @Autowired
    public CompanyServiceImpl(ICompanyDao companyDao, IAgreementService agreementService) {
        this.companyDao = companyDao;
        this.agreementService = agreementService;
    }

    @Override
    public Company Login(String email, String password) throws Exception {
        String sql = " email = :email and password = :password ";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("email",email);
        param.put("password",password);
        List<Company> staffList = companyDao.selectList(sql,param,null);
        if(staffList.size()>1){
            throw new Exception("数据错误");
        }
        if(staffList.size()<1){
            throw new Exception("用户名或密码错误");
        }
        return staffList.get(0);
    }

    @Override
    public Company insertCompany(Company company) throws Exception {
        if(companyDao.findByEmail(company.getEmail())!=null){
            throw new Exception("邮箱已经被注册");
        }
        company.setCompanyId(String.valueOf(System.currentTimeMillis()));
        companyDao.insert(company);
        return company;
    }

    @Override
    public void deleteCompany(String id) throws Exception {
        Company company = companyDao.findById(id);
        List<Agreement> agreementList = agreementService.queryByCompany(company);
        for (Agreement agreement : agreementList){
            agreementService.deleteAgreement(agreement.getAgreementId());
        }
        companyDao.delete(company);
    }

    @Override
    public Company queryByStaff(Staff staff) throws Exception {
        return companyDao.findById(staff.getCompanyId());
    }

    @Override
    public List<Company> queryByAdmin() throws Exception {
        return companyDao.selectList(null,null,null);
    }
}
