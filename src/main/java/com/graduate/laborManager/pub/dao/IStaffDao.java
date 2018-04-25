package com.graduate.laborManager.pub.dao;

import com.graduate.laborManager.common.base.baseDao.IBaseDao;
import com.graduate.laborManager.pub.bean.Staff;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:37
 */

public interface IStaffDao extends IBaseDao<Staff> {
    public Staff insertStaff(Staff staff)throws  Exception;
    public Staff checkStaff(Staff staff)throws  Exception;
    public List<Staff> queryAllStaff(int company_id)throws Exception;
    public List<Staff> queryStaffByIndex(String index,int company_id)throws Exception;
    public void deleteStaff(int id) throws Exception;
}