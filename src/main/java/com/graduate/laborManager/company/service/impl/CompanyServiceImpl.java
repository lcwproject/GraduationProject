package com.graduate.laborManager.company.service.impl;

import com.graduate.laborManager.company.service.ICompanyService;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.ICompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    public CompanyServiceImpl(ICompanyDao companyDao) {
        this.companyDao = companyDao;
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
    public Company register(Company company) throws Exception {
        company.setCompanyId(String.valueOf(System.currentTimeMillis()));
        companyDao.insert(company);
        return company;
    }

    @Override
    public Boolean checkEmail(String email) throws Exception {
        String condition = " email = :email";
        Map<String,Object> param = new HashMap<>();
        param.put("email",email);
        return companyDao.selectList(condition,param,null).size() == 0;
    }

    @Override
    public Company queryByStaff(Staff staff) throws Exception {
        return companyDao.findById(staff.getCompanyId());
    }
}
