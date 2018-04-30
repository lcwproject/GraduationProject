package com.graduate.laborManager.pub.dao;

import com.graduate.laborManager.agreement.view.AgreementView;
import com.graduate.laborManager.common.base.baseDao.IBaseDao;
import com.graduate.laborManager.pub.bean.Agreement;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 15:36
 */

public interface IAgreementDao extends IBaseDao<Agreement> {
    public List<AgreementView> queryCompanyAgreement(String c_id) throws Exception;
    public List<AgreementView> queryAlarmAgreement(String c_id) throws Exception;
}
