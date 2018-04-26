package com.graduate.laborManager.staff.service.impl;

import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.IAgreementDao;
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

    private IAgreementDao agreementDao;

    @Autowired
    public StaffServiceImpl(IStaffDao staffDao, ICompanyDao companyDao, IAgreementDao agreementDao) {
        this.staffDao = staffDao;
        this.companyDao = companyDao;
        this.agreementDao = agreementDao;
    }

    @Override
    public Staff Login(String phone, String password) throws Exception {
        String condition = " phone = :phone and password = :password ";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("phone",phone);
        param.put("password",password);
        List<Staff> staffList = staffDao.selectList(condition,param,null);
        if(staffList.size()>1){
            throw new Exception("数据错误");
        }
        if(staffList.size()<1){
            throw new Exception("用户名或密码错误");
        }
        return staffList.get(0);
    }

    @Override
    public Staff insertStaff(Staff staff,String companyId) throws Exception {
        if(staffDao.findByMobile(staff.getPhone())!=null){
            throw new Exception("手机号已被注册");
        }
        if(companyId == null || companyId.equals("")) {
            if (companyDao.findById(staff.getCompanyId()) == null) {
                throw new Exception("公司未注册");
            }
        }else {
            staff.setCompanyId(companyId);
        }
        staff.setStaffId(String.valueOf(System.currentTimeMillis()));
        staffDao.insert(staff);
        return staff;
    }

    @Override
    public void deleteStaff(String id) throws Exception {
        Staff staff = staffDao.findById(id);
        Agreement agreement = agreementDao.findById(staff.getAgreementId());
        agreementDao.delete(agreement);
        staffDao.delete(staff);
    }

    @Override
    public List<Staff> selectByAdmin() throws Exception {
        return staffDao.selectList(null,null,null);
    }

    @Override
    public List<Staff> selectByCompany(Company company) throws Exception {
        String condition = " company_id = :companyId ";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("companyId",company.getCompanyId());
        return staffDao.selectList(condition,param,null);
    }
}
