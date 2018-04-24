package com.graduate.laborManager.pub.dao;

import com.graduate.laborManager.agreement.view.AgreementView;
import com.graduate.laborManager.common.base.baseDao.IBaseDao;
import com.graduate.laborManager.pub.bean.Agreement;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:37
 */

public interface IAgreementDao extends IBaseDao<Agreement> {
    public List<AgreementView> queryAllAgreement(int c_id)throws Exception;
    public int insertAgreement(Agreement agreement);
    public List<AgreementView> queryAlarmAgreement(int c_id)throws Exception;
}
