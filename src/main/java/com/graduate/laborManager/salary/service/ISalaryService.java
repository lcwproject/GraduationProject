package com.graduate.laborManager.salary.service;

import com.graduate.laborManager.pub.bean.Salary;
import com.graduate.laborManager.pub.bean.Staff;

import java.util.List;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 15:43
 */

public interface ISalaryService {

    public List<Salary> queryByStaff (Staff staff) throws Exception;

}
