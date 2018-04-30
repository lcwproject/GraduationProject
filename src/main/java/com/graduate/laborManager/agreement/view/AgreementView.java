package com.graduate.laborManager.agreement.view;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class AgreementView {
    private String agreementId;
    private String companyName;
    private String staffName;
    private String title;
    private String content;
    private java.sql.Timestamp startTime;
    private String startTimeToShow;
    private java.sql.Timestamp endTime;
    private String endTimeToShow;

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
        this.startTimeToShow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime);
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
        this.endTimeToShow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endTime);
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEndTimeToShow() {
        return endTimeToShow;
    }

    public void setEndTimeToShow(String endTimeToShow) {
        this.endTimeToShow = endTimeToShow;
    }

    public String getStartTimeToShow() {
        return startTimeToShow;
    }

    public void setStartTimeToShow(String startTimeToShow) {
        this.startTimeToShow = startTimeToShow;
    }
}
