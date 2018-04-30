package com.graduate.laborManager.pub.dao;

import com.graduate.laborManager.common.base.baseDao.IBaseDao;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.salary.view.SalaryView;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 15:41
 */

public interface ISalaryDao extends IBaseDao<Salary> {
    public List<SalaryView> queryByCompany(String company_id)throws Exception;
}
