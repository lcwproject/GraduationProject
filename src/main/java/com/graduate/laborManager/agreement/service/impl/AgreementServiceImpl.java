package com.graduate.laborManager.agreement.service.impl;

import com.graduate.laborManager.agreement.service.IAgreementService;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Staff;
import com.graduate.laborManager.pub.dao.IAgreementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 15:34
 */

@Service
public class AgreementServiceImpl implements IAgreementService {

    private IAgreementDao agreementDao;

    @Autowired
    public AgreementServiceImpl(IAgreementDao agreementDao) {
        this.agreementDao = agreementDao;
    }

    @Override
    public Agreement queryByStaff(Staff staff) throws Exception {
        return agreementDao.findById(staff.getAgreementId());
    }
}
