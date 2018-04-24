package com.graduate.laborManager.pub.dao;

import com.graduate.laborManager.common.base.baseDao.IBaseDao;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.salary.view.SalaryView;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:29
 */

public interface ISalaryDao extends IBaseDao<Salary> {
    public List<SalaryView> addSalary(List<Salary> salaryList)throws Exception;

    public List<SalaryView> addSingleSalary(Salary salary)throws Exception;

    public List<SalaryView> queryMySalary(int s_id,int c_id)throws Exception;

    public List<SalaryView> queryCompanySalary(int c_id)throws Exception;
}
