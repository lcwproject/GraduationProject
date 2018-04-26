package com.graduate.laborManager.agreement.service;

import com.graduate.laborManager.pub.bean.Agreement;
import com.graduate.laborManager.pub.bean.Staff;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 15:33
 */

public interface IAgreementService {

    public Agreement queryByStaff(Staff staff) throws Exception ;

}
