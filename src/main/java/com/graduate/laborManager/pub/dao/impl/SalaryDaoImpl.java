package com.graduate.laborManager.pub.dao.impl;

import com.graduate.laborManager.common.base.baseDao.impl.BaseDaoImpl;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.ISalaryDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 15:41
 */

@Repository
public class SalaryDaoImpl extends BaseDaoImpl<Salary> implements ISalaryDao{

    @Override
    public List<Salary> findByStaffId(String staffId) throws Exception {
        String condition = " staff_id = :staffId ";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("staffId",staffId);
        String order = "date";
        return selectList(condition,param,order);
    }
}
