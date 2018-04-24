package com.graduate.laborManager.pub.dao.impl;

import com.graduate.laborManager.common.base.baseDao.impl.BaseDaoImpl;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.IStaffDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:41
 */

@Repository
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements IStaffDao {
    @Override
    public Staff insertStaff(Staff staff) throws Exception {
        this.insert(staff);
        return checkStaff(staff);
    }

    @Override
    public Staff checkStaff(Staff staff) throws Exception {
        List<Staff> staffList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from STAFF ");
        Map<String,Object> param = new HashMap<String,Object>();
        StringBuilder conditions = new StringBuilder(" where name= :name and password = :password");
        param.put("name",staff.getName());
        param.put("password",staff.getName());
        staffList = (List<Staff>)this.selectNativeSqlList(sql.toString()+conditions.toString(),param,Staff.class);
        if(staffList.size()!=0){
            return staffList.get(0);
        }
        return null;
    }


    @Override
    public List<Staff> queryAllStaff(int company_id) throws Exception {
        List<Staff> staffList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from STAFF ");
        Map<String,Object> param = new HashMap<String,Object>();
        StringBuilder conditions = new StringBuilder(" where c_id = :cid");
        param.put("cid",company_id);
        staffList = (List<Staff>)this.selectNativeSqlList(sql.toString()+conditions.toString(),param,Staff.class);
        return staffList;
    }

    @Override
    public List<Staff> queryStaffByIndex(String index, int company_id) throws Exception {
        List<Staff> staffList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from STAFF ");
        Map<String,Object> param = new HashMap<String,Object>();
        StringBuilder conditions = new StringBuilder(" where c_id = :cid and name like :index");
        param.put("cid",company_id);
        param.put("index",index);
        staffList = (List<Staff>)this.selectNativeSqlList(sql.toString()+conditions.toString(),param,Staff.class);
        return null;
    }

    @Override
    public void deleteStaff(int id) throws Exception {
        List<Staff> staffList = new ArrayList<>();
        StringBuilder conditions = new StringBuilder(" where id = :id");
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("id",id);
        staffList=this.selectList(conditions.toString(),param,null);
        if(staffList.size()==1)
        this.delete(staffList.get(0));
    }
}
