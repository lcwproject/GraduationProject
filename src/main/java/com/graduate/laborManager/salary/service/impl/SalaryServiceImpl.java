package com.graduate.laborManager.salary.service.impl;

import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.ISalaryDao;
import com.graduate.laborManager.pub.dao.IStaffDao;
import com.graduate.laborManager.salary.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 15:43
 */

@Service
public class SalaryServiceImpl implements ISalaryService {

    private ISalaryDao salaryDao;

    private IStaffDao staffDao;

    @Autowired
    public SalaryServiceImpl(ISalaryDao salaryDao) {
        this.salaryDao = salaryDao;
    }

    @Override
    public List<Salary> queryByStaff(Staff staff) throws Exception {
        String condition = " staff_id = :staffId ";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("staffId",staff.getStaffId());
        String order = "date";
        return salaryDao.selectList(condition,param,order);
    }

    @Override
    public List<Salary> queryByCompany(Company company) throws Exception {
        String condition = " company_id = :companyId ";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("companyId",company.getCompanyId());
        String order = "date";
        return salaryDao.selectList(condition,param,order);
    }

    @Override
    public Salary addSalary(Salary salary, String staffId) throws Exception {
        Staff staff = staffDao.findById(staffId);
        if(staff == null){
            throw new Exception("该员工不存在");
        }
        salary.setStaffId(staffId);
        salary.setSalaryId(String.valueOf(System.currentTimeMillis()));
        salaryDao.insert(salary);
        return salary;
    }
}
