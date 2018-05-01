package com.graduate.laborManager.salary.view;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryView {
    private String name;
    private String phone;
    private Date date;
    private String dateToShow;
    private Integer salary;
    private String tip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        this.dateToShow = new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getDateToShow() {
        return dateToShow;
    }

    public void setDateToShow(String dateToShow) {
        this.dateToShow = dateToShow;
    }
}
