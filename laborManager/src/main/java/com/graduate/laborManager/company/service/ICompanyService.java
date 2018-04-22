package com.graduate.laborManager.company.service;

import com.graduate.laborManager.pub.bean.Company;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 17:30
 */

public interface ICompanyService {

    public List<Company> selectList() throws Exception;

}
