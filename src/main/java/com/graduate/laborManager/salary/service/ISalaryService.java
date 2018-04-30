package com.graduate.laborManager.salary.service;

import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.salary.view.SalaryView;

import java.io.File;
import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 15:43
 */

public interface ISalaryService {

    public List<Salary> queryByStaff (Staff staff) throws Exception;

    public List<SalaryView> queryByCompany(Company company) throws Exception;

    public Salary addSalary(Salary salary,String staffId) throws Exception;

    public List<Salary> addSalaryByFile(File excle, String company) throws Exception;
}
