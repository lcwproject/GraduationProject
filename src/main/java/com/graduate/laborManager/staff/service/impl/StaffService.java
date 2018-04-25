package com.graduate.laborManager.staff.service.impl;

import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.staff.service.IStaffService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffService implements IStaffService {
    @Override
    public Staff insertStaff(Staff staff) throws Exception {
        return null;
    }

    @Override
    public Staff checkStaff(Staff staff) throws Exception {
        return null;
    }

    @Override
    public List<Staff> queryAllStaff(int company_id) throws Exception {
        return null;
    }

    @Override
    public List<Staff> queryStaffByIndex(String index, int company_id) throws Exception {
        return null;
    }

    @Override
    public void deleteStaff(int id) throws Exception {

    }
}
