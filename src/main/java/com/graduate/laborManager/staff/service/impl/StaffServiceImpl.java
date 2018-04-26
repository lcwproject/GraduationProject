package com.graduate.laborManager.staff.service.impl;

import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.ICompanyDao;
import com.graduate.laborManager.pub.dao.IStaffDao;
import com.graduate.laborManager.staff.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 13:30
 */

@Service
public class StaffServiceImpl implements IStaffService {

    private IStaffDao staffDao;

    private ICompanyDao companyDao;

    @Autowired
    public StaffServiceImpl(IStaffDao staffDao, ICompanyDao companyDao) {
        this.staffDao = staffDao;
        this.companyDao = companyDao;
    }

    @Override
    public Staff Login(String phone, String password) throws Exception {
        String sql = " phone = :phone and password = :password ";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("phone",phone);
        param.put("password",password);
        List<Staff> staffList = staffDao.selectList(sql,param,null);
        if(staffList.size()>1){
            throw new Exception("数据错误");
        }
        if(staffList.size()<1){
            throw new Exception("用户名或密码错误");
        }
        return staffList.get(0);
    }

    @Override
    public Staff register(Staff staff) throws Exception {
        if(staffDao.findByMobile(staff.getPhone())!=null){
            throw new Exception("手机号已被注册");
        }
        if(companyDao.findById(staff.getCompanyId())==null){
            throw new Exception("公司未注册");
        }
        staff.setStaffId(String.valueOf(System.currentTimeMillis()));
        staffDao.insert(staff);
        return staff;
    }

}
