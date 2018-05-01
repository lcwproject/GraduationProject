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


@Repository
public class SalaryDaoImpl extends BaseDaoImpl<Salary> implements ISalaryDao{
    @Override
    public List<SalaryView> queryByCompany(String company_id) throws Exception {
        List<SalaryView> SalaryViewList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select st.name name,st.phone phone,sa.date date,sa.salary salary,sa.tip tip from SALARY sa,STAFF st");
        Map<String,Object> param = new HashMap<String,Object>();
        StringBuilder conditions = new StringBuilder(" where sa.company_id = :company_id and sa.staff_id = st.staff_id order by sa.date DESC");
        param.put("company_id",company_id);
        SalaryViewList = (List<SalaryView>)this.selectNativeSqlList(sql.toString()+conditions.toString(),param,SalaryView.class);
        return SalaryViewList;
    }
}
