package com.graduate.laborManager.pub.dao;

import com.graduate.laborManager.common.base.baseDao.IBaseDao;
import com.graduate.laborManager.pub.bean.Staff;
import sun.reflect.generics.tree.VoidDescriptor;



public interface IStaffDao extends IBaseDao<Staff> {

    public Staff findByMobile(String phone) throws Exception;


}
