package com.graduate.laborManager.company.service;

import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;

import java.util.List;


public interface ICompanyService {

    public Company Login(String email, String password) throws Exception;

    public Company queryByStaff(Staff staff) throws Exception ;

    public List<Company> queryByAdmin() throws Exception;

    public Company insertCompany(Company company) throws Exception ;

    public void deleteCompany(String id) throws Exception ;
}
