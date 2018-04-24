package com.graduate.laborManager.agreement.service;

import com.graduate.laborManager.agreement.view.AgreementView;
import com.graduate.laborManager.pub.bean.Agreement;

import java.util.List;

public interface IAgreementService {
    public List<AgreementView> queryAllAgreement(int c_id) throws Exception;
    public int insertAgreement(Agreement agreement);
    public List<AgreementView> queryAlarmAgreement(int c_id)throws Exception;
}
