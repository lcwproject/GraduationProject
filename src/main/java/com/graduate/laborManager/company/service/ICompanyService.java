package com.graduate.laborManager.company.service;

import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 14:51
 */

public interface ICompanyService {

    public Company register(Company company) throws Exception ;

    public Company Login(String email, String password) throws Exception;

    public Boolean checkEmail(String email) throws Exception ;

    public Company queryByStaff(Staff staff) throws Exception ;

}
