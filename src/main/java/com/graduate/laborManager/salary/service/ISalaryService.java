package com.graduate.laborManager.salary.service;

import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.salary.view.SalaryView;

import java.util.List;

public interface ISalaryService {
    public List<SalaryView> addSalary(List<SalaryView> salaryList)throws Exception;

    public List<SalaryView> addSingleSalary(Salary salary)throws Exception;

    public List<SalaryView> queryMySalary(int s_id,int c_id)throws Exception;

    public List<SalaryView> queryCompanySalary(int c_id)throws Exception;
}
