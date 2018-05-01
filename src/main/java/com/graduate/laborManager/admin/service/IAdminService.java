package com.graduate.laborManager.admin.service;

import com.graduate.laborManager.pub.bean.Admin;



public interface IAdminService {

    public Admin Login(String name,String password) throws Exception ;

}
