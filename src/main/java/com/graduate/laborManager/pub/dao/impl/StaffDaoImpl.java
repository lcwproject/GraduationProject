package com.graduate.laborManager.pub.dao.impl;

import com.graduate.laborManager.common.base.baseDao.impl.BaseDaoImpl;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.IStaffDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 12:56
 */

@Repository
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements IStaffDao {

    @Override
    public Staff findByMobile(String phone) throws Exception {
        String condition = " phone = :phone";
        Map<String,Object> param = new HashMap<>();
        param.put("phone",phone);
        List<Staff> staffList = this.selectList(condition,param,null);
        if(staffList.size()>1){
            throw new Exception("数据错误");
        }
        if(staffList.size()==0){
            return null;
        }
        return staffList.get(0);
    }
}
