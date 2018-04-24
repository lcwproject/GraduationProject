package com.graduate.laborManager.pub.dao.impl;

import com.graduate.laborManager.agreement.view.AgreementView;
import com.graduate.laborManager.common.base.baseDao.impl.BaseDaoImpl;
import com.graduate.laborManager.common.util.TimeUtil;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.dao.IAgreementDao;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.*;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:37
 */

@Repository
public class AgreementDaoImpl extends BaseDaoImpl<Agreement> implements IAgreementDao {
    @Override
    public List<AgreementView> queryAllAgreement(int c_id) throws Exception {
        List<AgreementView> agreementViewList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select c.company_name companyName,s.name staffName, a.title title,a.content content,a.start_time startTime,a.end_time startTime from COMPANY c,AGREEMENT a,STAFF s");
        Map<String,Object> param = new HashMap<String,Object>();
        StringBuilder conditions = new StringBuilder(" where a.c_id = c.id and a.s_id = s.id order by a.id DESC");
        agreementViewList = (List<AgreementView>)this.selectNativeSqlList(sql.toString()+conditions.toString(),null,AgreementView.class);
        return agreementViewList;
    }

    @Override
    public int insertAgreement(Agreement agreement) {
        try {
            this.insert(agreement);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<AgreementView> queryAlarmAgreement(int c_id) throws Exception {
        List<AgreementView> agreementViewList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select c.company_name companyName,s.name staffName, a.title title,a.content content,a.start_time startTime,a.end_time startTime from COMPANY c,AGREEMENT a,STAFF s");
        Map<String,Object> param = new HashMap<String,Object>();
        StringBuilder conditions = new StringBuilder(" where a.c_id = c.id and a.s_id = s.id order by a.id DESC");
        String today = TimeUtil.getNow8();
        String later_30 = TimeUtil.getFrontDay(-30);
        conditions.append(" and :time1<=a.end_time<=time2");
        param.put("time1",today);
        param.put("time2",later_30);
        agreementViewList = (List<AgreementView>)this.selectNativeSqlList(sql.toString()+conditions.toString(),null,AgreementView.class);
        return agreementViewList;
    }
}
