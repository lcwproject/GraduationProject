package com.graduate.laborManager.salary.service.impl;

import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.dao.ISalaryDao;
import com.graduate.laborManager.salary.service.ISalaryService;
import com.graduate.laborManager.salary.view.SalaryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalaryServiceImpl implements ISalaryService{
    @Autowired
    ISalaryDao salaryDao;
    @Override
    public List<SalaryView> addSalary(List<SalaryView> salaryList) throws Exception {
        return null;
    }

    @Override
    public List<SalaryView> addSingleSalary(Salary salary) throws Exception {
        return null;
    }

    @Override
    public List<SalaryView> queryMySalary(int s_id, int c_id) throws Exception {
        return salaryDao.queryMySalary(s_id,c_id);
    }

    @Override
    public List<SalaryView> queryCompanySalary(int c_id) throws Exception {
        return null;
    }
}
