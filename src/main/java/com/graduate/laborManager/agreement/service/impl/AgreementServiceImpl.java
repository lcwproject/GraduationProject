package com.graduate.laborManager.agreement.service.impl;

import com.graduate.laborManager.agreement.service.IAgreementService;
import com.graduate.laborManager.agreement.view.AgreementView;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.dao.IAgreementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AgreementServiceImpl implements IAgreementService{
    @Autowired
    IAgreementDao agreementDao;
    @Override
    public List<AgreementView> queryAllAgreement(int c_id) throws Exception {
        List<AgreementView> agreementViewList = new ArrayList<>();
        agreementViewList = agreementDao.queryAllAgreement(c_id);
        return agreementViewList;
    }

    @Override
    public Agreement insertAgreement(Agreement agreement) {
        if (agreementDao.insertAgreement(agreement)==1){
            try {
                return agreementDao.queryAgreement(agreement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<AgreementView> queryAlarmAgreement(int c_id) throws Exception {
        List<AgreementView> agreementViewList = new ArrayList<>();
        agreementViewList = agreementDao.queryAlarmAgreement(c_id);
        return agreementViewList;
    }

    @Override
    public Agreement queryById(int a_id) throws Exception {
        return agreementDao.findById(a_id);
    }


}
