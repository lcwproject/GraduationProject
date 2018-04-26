package com.graduate.laborManager.pub.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/26 13:20
 */

@Entity
public class Salary {
    private String salaryId;
    private String companyId;
    private String staffId;
    private String date;
    private BigDecimal salary;
    private String tip;

    @Id
    @Column(name = "salary_id", nullable = false, length = 32)
    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
    }

    @Basic
    @Column(name = "company_id", nullable = true, length = 32)
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "staff_id", nullable = true, length = 32)
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "salary", nullable = true, precision = 2)
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "tip", nullable = true, length = 255)
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary1 = (Salary) o;
        return Objects.equals(salaryId, salary1.salaryId) &&
                Objects.equals(companyId, salary1.companyId) &&
                Objects.equals(staffId, salary1.staffId) &&
                Objects.equals(date, salary1.date) &&
                Objects.equals(salary, salary1.salary) &&
                Objects.equals(tip, salary1.tip);
    }

    @Override
    public int hashCode() {

        return Objects.hash(salaryId, companyId, staffId, date, salary, tip);
    }
}
