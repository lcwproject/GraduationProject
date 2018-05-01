package com.graduate.laborManager.staff.service;

import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;

import java.util.List;


public interface IStaffService {

    public Staff Login(String phone,String password) throws Exception;

    public Staff insertStaff(Staff staff,String companyId) throws Exception;

    public void deleteStaff(String id) throws Exception;

    public List<Staff> selectByAdmin() throws Exception;

    public List<Staff> selectByCompany(Company company) throws Exception;

}
