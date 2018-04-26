package com.graduate.laborManager.admin.service;

import com.graduate.laborManager.pub.bean.Admin;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 18:35
 */

public interface IAdminService {

    public Admin Login(String name,String password) throws Exception ;

}
