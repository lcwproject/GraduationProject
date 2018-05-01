package com.graduate.laborManager.salary.service.impl;

import com.graduate.laborManager.common.util.ImportExcelUtil;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.ISalaryDao;
import com.graduate.laborManager.pub.dao.IStaffDao;
import com.graduate.laborManager.salary.service.ISalaryService;
import com.graduate.laborManager.salary.view.SalaryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class SalaryServiceImpl implements ISalaryService {

    private ISalaryDao salaryDao;

    private IStaffDao staffDao;

    @Autowired
    public SalaryServiceImpl(ISalaryDao salaryDao, IStaffDao staffDao) {
        this.salaryDao = salaryDao;
        this.staffDao = staffDao;
    }


    @Override
    public List<Salary> queryByStaff(Staff staff) throws Exception {
        String condition = " staff_id = :staffId ";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("staffId",staff.getStaffId());
        String order = "date";
        return salaryDao.selectList(condition,param,order);
    }

    @Override
    public List<SalaryView> queryByCompany(Company company) throws Exception {
        return salaryDao.queryByCompany(company.getCompanyId());
    }

    @Override
    public Salary addSalary(Salary salary, String staffId) throws Exception {
        Staff staff = staffDao.findById(staffId);
        if(staff == null){
            throw new Exception("该员工不存在");
        }
        salary.setStaffId(staffId);
        salary.setSalaryId(String.valueOf(System.currentTimeMillis()));
        salaryDao.insert(salary);
        return salary;
    }

    @Override
    public List<Salary> addSalaryByFile(File excle, String company_id) throws Exception {
        List<Salary> addSalaryList = new ArrayList<>();
        List<Salary> querySalaryViewList = new ArrayList<>();
        FileInputStream fis = null;
        String condition = " company_id = :conpanyId ";
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("conpanyId",company_id);
        List<Staff> staffs = staffDao.selectList(condition,param,null);
        fis = new FileInputStream(excle);
        //excel对应的字段
        Map<String, String> m = new HashMap<String, String>();
        m.put("姓名", "name");
        m.put("电话号码", "phone");
        m.put("日期", "date");
        m.put("薪水", "salary");
        m.put("备注", "tip");
        List<Map<String, Object>> ls = ImportExcelUtil.parseExcel(fis, excle.getName(), m);
        for (int i= 0; i<ls.size(); i++) {
            Salary itms = new Salary();
            itms.setSalaryId(String.valueOf(System.currentTimeMillis()));
            itms.setCompanyId(company_id);
            itms.setStaffId(staffDao.findByMobile((String) ls.get(i).get("phone")).getStaffId());
            itms.setDate((String) ls.get(i).get("date"));
            itms.setSalary(Integer.parseInt((String)ls.get(i).get("salary")));
            itms.setTip((String) ls.get(i).get("tip"));
            //itms.getSalary(ls.get(i).get("salary"));
            addSalaryList.add(itms);
        }
        salaryDao.insertList(addSalaryList);
        return addSalaryList;

    }
}
