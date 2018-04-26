package com.graduate.laborManager.pub.dao.impl;

import com.graduate.laborManager.agreement.service.IAgreementService;
import com.graduate.laborManager.common.base.baseDao.impl.BaseDaoImpl;
import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.dao.IAgreementDao;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 15:36
 */

@Repository
public class AgreementDaoImpl extends BaseDaoImpl<Agreement> implements IAgreementDao {
}
