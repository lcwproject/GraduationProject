package com.graduate.laborManager.pub.dao.impl;

import com.graduate.laborManager.common.base.baseDao.impl.BaseDaoImpl;
import com.graduate.laborManager.pub.bean.Company;
import com.graduate.laborManager.pub.dao.ICompanyDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 14:53
 */

@Repository
public class CompanyDaoImpl extends BaseDaoImpl<Company> implements ICompanyDao {

    @Override
    public Company findByEmail(String email) throws Exception {
        String condition = " email = :email";
        Map<String,Object> param = new HashMap<>();
        param.put("email",email);
        List<Company> companyList = this.selectList(condition,param,null);
        if(companyList.size()>1){
            throw new Exception("数据错误");
        }
        if(companyList.size()<1){
            return null;
        }
        return companyList.get(0);
    }
}
