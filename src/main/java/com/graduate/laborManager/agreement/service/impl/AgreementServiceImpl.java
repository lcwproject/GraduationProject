package com.graduate.laborManager.agreement.service.impl;

import com.graduate.laborManager.agreement.service.IAgreementService;
import com.graduate.laborManager.agreement.view.AgreementView;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.IAgreementDao;
import com.graduate.laborManager.pub.dao.IStaffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class AgreementServiceImpl implements IAgreementService {

    private IAgreementDao agreementDao;

    private IStaffDao staffDao;

    @Autowired
    public AgreementServiceImpl(IAgreementDao agreementDao, IStaffDao staffDao) {
        this.agreementDao = agreementDao;
        this.staffDao = staffDao;
    }

    @Override
    public Agreement queryByStaff(Staff staff) throws Exception {
        return agreementDao.findById(staff.getAgreementId());
    }

    @Override
    public List<AgreementView> queryByCompany(Company company) throws Exception {
        return agreementDao.queryCompanyAgreement(company.getCompanyId());
    }

    @Override
    public List<AgreementView> queryAlarmByCompany(Company company) throws Exception {
        return agreementDao.queryAlarmAgreement(company.getCompanyId());
    }

    @Override
    public Agreement addAgreement(Agreement agreement,Company company,String staffId) throws Exception {
        Staff staff = staffDao.findById(staffId);
        if(staff==null || !staff.getCompanyId().equals(company.getCompanyId())){
            throw new Exception("数据无效");
        }
        agreement.setCompanyId(company.getCompanyId());
        agreement.setStaffId(staffId);
        agreement.setAgreementId(String.valueOf(System.currentTimeMillis()));
        agreementDao.insert(agreement);
        staff.setAgreementId(agreement.getAgreementId());
        staffDao.update(staff);

        return agreement;
    }

    @Override
    public void deleteAgreement(String id) throws Exception {
        Agreement agreement = agreementDao.findById(id);
        String staffId = agreement.getStaffId();
        agreementDao.delete(agreement);
        Staff staff = staffDao.findById(staffId);
        staff.setAgreementId("");
        staffDao.update(staff);
    }
}
