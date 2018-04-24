package com.graduate.laborManager.pub.dao;

import com.graduate.laborManager.common.base.baseDao.IBaseDao;
import com.graduate.laborManager.pub.bean.Company;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:37
 */

public interface ICompanyDao extends IBaseDao<Company> {
    public Company checkCompany(Company company)throws  Exception;

    public List<Company> selectList() throws Exception;

    public List<Company> queryByIndex(String index) throws Exception;

    public Company queryById(int id) throws Exception;

    public Company insertCompany(Company company) throws  Exception;

    public void deleteCompany(int company_id)throws Exception;
}
