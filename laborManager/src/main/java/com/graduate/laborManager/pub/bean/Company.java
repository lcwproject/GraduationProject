package com.graduate.laborManager.pub.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @project: laborManager
 * @description: here to type description
 * @author: Dustin
 * @time: 2018/4/21 14:16
 */

@Entity
public class Company {
    private int id;
    private String companyName;
    private String password;
    private String address;
    private String email;
    private Integer hotlint;
    private String introduction;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "company_name", nullable = true, length = 20)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 20)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "hotlint", nullable = true)
    public Integer getHotlint() {
        return hotlint;
    }

    public void setHotlint(Integer hotlint) {
        this.hotlint = hotlint;
    }

    @Basic
    @Column(name = "introduction", nullable = true, length = 255)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id &&
                Objects.equals(companyName, company.companyName) &&
                Objects.equals(password, company.password) &&
                Objects.equals(address, company.address) &&
                Objects.equals(email, company.email) &&
                Objects.equals(hotlint, company.hotlint) &&
                Objects.equals(introduction, company.introduction);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, companyName, password, address, email, hotlint, introduction);
    }
}
