package com.graduate.laborManager.staff.service;

import com.graduate.laborManager.pub.bean.Staff;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 13:30
 */

public interface IStaffService {

    public Staff register(Staff staff) throws Exception;

    public Staff Login(String phone,String password) throws Exception;

}
