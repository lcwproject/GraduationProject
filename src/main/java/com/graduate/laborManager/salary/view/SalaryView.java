package com.graduate.laborManager.salary.view;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SalaryView {
    private String name;
    private Timestamp date;
    private BigDecimal salary;
    private String tip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
