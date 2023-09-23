package com.driver;

import java.util.Date;

public class mails {

    Date date;
    private String sender;
    private String sms;

    public mails(Date date, String sender, String sms) {
        this.date = date;
        this.sender = sender;
        this.sms = sms;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }
}
