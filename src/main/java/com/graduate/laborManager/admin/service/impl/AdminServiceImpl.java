package com.graduate.laborManager.admin.service.impl;

import com.graduate.laborManager.admin.service.IAdminService;
import com.graduate.laborManager.pub.bean.Admin;
import com.graduate.laborManager.pub.dao.IAdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AdminServiceImpl implements IAdminService {

    private IAdminDao adminDao;

    @Autowired
    public AdminServiceImpl(IAdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin Login(String name, String password) throws Exception {
        String condition = " name = :name and password = :password ";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("name",name);
        param.put("password",password);
        List<Admin> adminList = adminDao.selectList(condition,param,null);
        if(adminList.size()>1){
            throw new Exception("数据错误");
        }
        if(adminList.size()<1){
            throw new Exception("用户名或密码错误");
        }
        return adminList.get(0);
    }
}
