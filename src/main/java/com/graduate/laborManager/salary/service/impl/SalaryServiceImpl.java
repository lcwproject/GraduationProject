package com.graduate.laborManager.salary.service.impl;

import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.ISalaryDao;
import com.graduate.laborManager.salary.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 15:43
 */

@Service
public class SalaryServiceImpl implements ISalaryService {

    private ISalaryDao salaryDao;

    @Autowired
    public SalaryServiceImpl(ISalaryDao salaryDao) {
        this.salaryDao = salaryDao;
    }

    @Override
    public List<Salary> queryByStaff(Staff staff) throws Exception {
        return salaryDao.findByStaffId(staff.getStaffId());
    }
}
