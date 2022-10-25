package com.demo.model;

import lombok.Data;

@Data

public class EmailDetails {
    private String recipent; //nguoi nhan
    private String msgBody; //noi dung mail
    private String subject; //tiêu đề
    private String attachment; //tai liệu đính kèm

    public EmailDetails() {
    }

    public String getRecipent() {
        return recipent;
    }

    public void setRecipent(String recipent) {
        this.recipent = recipent;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
