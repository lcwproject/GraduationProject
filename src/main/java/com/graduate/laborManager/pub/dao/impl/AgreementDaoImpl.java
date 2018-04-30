package com.graduate.laborManager.pub.dao.impl;

import com.graduate.laborManager.agreement.service.IAgreementService;
import com.graduate.laborManager.agreement.view.AgreementView;
import com.graduate.laborManager.common.base.baseDao.impl.BaseDaoImpl;
import com.graduate.laborManager.common.util.TimeUtil;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.dao.IAgreementDao;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 15:36
 */

@Repository
public class AgreementDaoImpl extends BaseDaoImpl<Agreement> implements IAgreementDao {
    @Override
    public List<AgreementView> queryCompanyAgreement(String company_id) throws Exception{
        List<AgreementView> agreementViewList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select a.agreement_id agreementId, c.company_name companyName,s.name staffName, a.title title,a.content content,a.start_time startTime,a.end_time endTime from COMPANY c,AGREEMENT a,STAFF s");
        Map<String,Object> param = new HashMap<String,Object>();
        StringBuilder conditions = new StringBuilder(" where a.company_id=c.company_id and a.company_id = :company_id and a.staff_id = s.staff_id order by a.agreement_id DESC");
        param.put("company_id",company_id);
        agreementViewList = (List<AgreementView>)this.selectNativeSqlList(sql.toString()+conditions.toString(),param,AgreementView.class);
        return agreementViewList;
    }

    @Override
    public List<AgreementView> queryAlarmAgreement(String c_id) throws Exception {
        List<AgreementView> agreementViewList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select a.agreement_id agreementId, c.company_name companyName,s.name staffName, a.title title,a.content content,a.start_time startTime,a.end_time endTime from COMPANY c,AGREEMENT a,STAFF s");
        Map<String,Object> param = new HashMap<String,Object>();
        StringBuilder conditions = new StringBuilder(" where a.company_id=c.company_id and a.company_id = :c_id and a.staff_id = s.staff_id ");
        conditions.append("and :today<= a.end_time<= :laterDay");
        param.put("c_id",c_id);
        param.put("today", TimeUtil.getNow8());//今天
        param.put("laterDay", TimeUtil.getFrontDay(-30));//一个月后
        agreementViewList = (List<AgreementView>)this.selectNativeSqlList(sql.toString()+conditions.toString(),param,AgreementView.class);
        return agreementViewList;
    }
}
