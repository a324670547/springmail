package com.example.springmail.service;

import com.example.springmail.entity.MailMessage;

public interface MailService {
    /**
     * 发送邮件
     * @param mailMessage
     * @return
     */
    public Integer sendMail(MailMessage mailMessage);

}
