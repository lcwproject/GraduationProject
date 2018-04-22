package com.graduate.laborManager.company.service.impl;

import com.graduate.laborManager.company.service.ICompanyService;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.dao.ICompanyDao;
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

    @Override
    public List<Company> selectList() throws Exception {
        return companyDao.selectList(null,null,null);
    }
}
