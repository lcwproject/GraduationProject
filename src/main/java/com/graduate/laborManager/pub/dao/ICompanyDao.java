package com.graduate.laborManager.pub.dao;

import com.graduate.laborManager.common.base.baseDao.IBaseDao;
import com.graduate.laborManager.pub.bean.Company;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 14:52
 */

public interface ICompanyDao extends IBaseDao<Company> {

    public Company findByEmail(String email) throws Exception ;

}
