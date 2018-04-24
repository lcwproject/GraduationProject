package com.graduate.laborManager.staff.service;

import com.graduate.laborManager.pub.bean.Staff;

import java.util.List;

public interface IStaffService {
    public Staff insertStaff(Staff staff)throws  Exception;
    public Staff checkStaff(Staff staff)throws  Exception;
    public List<Staff> queryAllStaff(int company_id)throws Exception;
    public List<Staff> queryStaffByIndex(String index,int company_id)throws Exception;
    public void deleteStaff(int id) throws Exception;
}
