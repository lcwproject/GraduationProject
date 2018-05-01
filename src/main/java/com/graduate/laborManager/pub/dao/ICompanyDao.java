package com.graduate.laborManager.pub.dao;

import com.graduate.laborManager.common.base.baseDao.IBaseDao;
import com.graduate.laborManager.pub.bean.Company;



public interface ICompanyDao extends IBaseDao<Company> {

    public Company findByEmail(String email) throws Exception ;

}
