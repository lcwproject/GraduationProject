package com.graduate.laborManager.pub.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class Agreement {
    private String agreementId;
    private String companyId;
    private String staffId;
    private String title;
    private String content;
    private String startTime;
    private String endTime;

    @Id
    @Column(name = "agreement_id", nullable = false, length = 32)
    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
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
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 500)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "start_time", nullable = true)
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = true)
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agreement agreement = (Agreement) o;
        return Objects.equals(agreementId, agreement.agreementId) &&
                Objects.equals(companyId, agreement.companyId) &&
                Objects.equals(staffId, agreement.staffId) &&
                Objects.equals(title, agreement.title) &&
                Objects.equals(content, agreement.content) &&
                Objects.equals(startTime, agreement.startTime) &&
                Objects.equals(endTime, agreement.endTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(agreementId, companyId, staffId, title, content, startTime, endTime);
    }
}
