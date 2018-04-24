package com.graduate.laborManager.pub.dao.impl;

import com.graduate.laborManager.common.base.baseDao.impl.BaseDaoImpl;
import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.dao.ISalaryDao;
import com.graduate.laborManager.salary.view.SalaryView;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 16:36
 */

@Repository
public class SalaryDaoImpl extends BaseDaoImpl<Salary> implements ISalaryDao {


    @Override
    public List<SalaryView> addSalary(List<Salary> salaryList) throws Exception {
        this.insertList(salaryList);
        return this.queryCompanySalary(salaryList.get(0).getcId());
    }

    @Override
    public List<SalaryView> addSingleSalary(Salary salary) throws Exception {
        this.insert(salary);
        return queryCompanySalary(salary.getcId());
    }

    @Override
    public List<SalaryView> queryMySalary(int s_id, int c_id) throws Exception {
        List<SalaryView> SalaryViewList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select st.name name,sa.date date,sa.salary salary,sa.tip tip from SALARY sa,STAFF st");
        Map<String,Object> param = new HashMap<String,Object>();
        StringBuilder conditions = new StringBuilder(" where sa.c_id = :c_id and sa.s_id = :s_id order by sa.date DESC");
        param.put("c_id",c_id);
        param.put("s_id",s_id);
        SalaryViewList = (List<SalaryView>)this.selectNativeSqlList(sql.toString()+conditions.toString(),null,SalaryView.class);
        return SalaryViewList;
    }

    @Override
    public List<SalaryView> queryCompanySalary(int c_id) throws Exception {
        List<SalaryView> SalaryViewList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select st.name name,sa.date date,sa.salary salary,sa.tip tip from SALARY sa,STAFF st");
        Map<String,Object> param = new HashMap<String,Object>();
        StringBuilder conditions = new StringBuilder(" where sa.c_id = :c_id and sa.s_id = st.id order by sa.date DESC");
        param.put("c_id",c_id);
        SalaryViewList = (List<SalaryView>)this.selectNativeSqlList(sql.toString()+conditions.toString(),null,SalaryView.class);
        return SalaryViewList;
    }
}
