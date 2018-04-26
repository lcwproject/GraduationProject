package com.graduate.laborManager.pub.dao;

import com.graduate.laborManager.common.base.baseDao.IBaseDao;
import com.graduate.laborManager.pub.bean.Staff;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 12:55
 */

public interface IStaffDao extends IBaseDao<Staff> {

    public Staff findByMobile(String phone) throws Exception;

}
