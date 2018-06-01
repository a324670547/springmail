package com.example.springmail.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MailMessage implements Serializable {
    // 写信人邮箱地址
    private String from;
    // 要发送地址
    private String[] tos;
    // 抄送地址
    private String[] ccs;
    // 发送人
    private String personal;
    // 主题
    private String subject;
    // 内容
    private String content;
    // 邮件类型
    private Boolean htML;
    // 附件
    private List<MailAttach> attachs;

    public MailMessage() {}
    public MailMessage(String from, String[] tos, String[] ccs, String personal,
                       String subject, String content, Boolean htML,
                       List<MailAttach> attachs) {
        this.from = from;
        this.tos = tos;
        this.ccs = ccs;
        this.personal = personal;
        this.subject = subject;
        this.content = content;
        this.htML = htML;
        this.attachs = attachs;
    }
    public MailMessage(String from, String[] tos, String[] ccs, String personal,
                       String subject, String content, Boolean htML,
                       MailAttach[] attachs) {
        this.from = from;
        this.tos = tos;
        this.ccs = ccs;
        this.personal = personal;
        this.subject = subject;
        this.content = content;
        this.htML = htML;
        this.attachs = Arrays.asList(attachs);
    }

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String[] getTos() {
        return tos;
    }
    public void setTos(String[] tos) {
        this.tos = tos;
    }
    public String[] getCcs() {
        return ccs;
    }
    public void setCcs(String[] ccs) {
        this.ccs = ccs;
    }
    public String getPersonal() {
        return personal;
    }
    public void setPersonal(String personal) {
        this.personal = personal;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Boolean getHtML() {
        return htML;
    }
    public void setHtML(Boolean htML) {
        this.htML = htML;
    }
    public List<MailAttach> getAttach() {
        return attachs;
    }
    public void setAttachs(List<MailAttach> attachs) {
        this.attachs = attachs;
    }
    public void setAttachs(MailAttach[] attachs) {
        this.attachs = Arrays.asList(attachs);
    }

    public String toString() {
        return "MailMessage{" +
                "from='" + from + '\'' +
                ", tos=" + Arrays.toString(tos) +
                ", ccs=" + Arrays.toString(ccs) +
                ", personal='" + personal + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", htML=" + htML +
                ", attach=" + attachs +
                '}';
    }
}
