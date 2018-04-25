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
 * @time: 2018/4/21 16:40
 */

@Repository
public class CompanyDaoImpl extends BaseDaoImpl<Company> implements ICompanyDao {

    @Override
    public Company checkCompany(Company company) throws Exception {
        List<Company> companyList = new ArrayList<>();
        Map<String,Object> param = new HashMap<String,Object>();
        StringBuilder conditions = new StringBuilder(" company_name=:company_name and password=:password");
        param.put("company_name",company.getCompanyName());
        param.put("password",company.getPassword());
        companyList = this.selectList(conditions.toString(),param,null);
        if(companyList.size()!=0){
            return companyList.get(0);
        }
        return null;
    }

    @Override
    public List<Company> selectList() throws Exception {
        List<Company> companyList = new ArrayList<>();
        companyList= this.selectList();
        return null;
    }

    @Override
    public List<Company> queryByIndex(String index) throws Exception {
        List<Company> companyList = new ArrayList<>();
        StringBuilder slq = new StringBuilder("select * from COMPANY");
        Map<String,Object> param = new HashMap<String,Object>();
        StringBuilder conditions = new StringBuilder(" where company_name like :index or introduction like :index");
        param.put("index","%"+index+"%");
        companyList = (List<Company>) this.selectNativeSqlList(slq.toString()+conditions.toString(),param,Company.class);
        return companyList;
    }

    @Override
    public Company queryById(int id) throws Exception {
        return this.findById(id);
    }

    @Override
    public Company insertCompany(Company company) throws Exception {
        this.insert(company);
        return this.checkCompany(company);//id数据库递增，靠用户名和密码找到新加的company
    }

    @Override
    public void deleteCompany(int company_id) throws Exception {
        this.delete(this.findById(company_id));
    }
}
