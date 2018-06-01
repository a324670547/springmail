package com.example.springmail.service.impl;

import com.example.springmail.vo.Content;
import com.example.springmail.entity.MailAttach;
import com.example.springmail.entity.MailMessage;
import com.example.springmail.service.MailService;
import com.example.springmail.utils.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Base64;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    // 发送邮件
    public Integer sendMail(MailMessage mailMessage) {
        Session session = Session.getDefaultInstance(new Properties());
        MimeMessage message = new MimeMessage(session);
        try{
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true,"GBK");
            // 设置发送地址
            if (ArrayUtils.isNotEmpty(mailMessage.getTos())) {
                InternetAddress[] tos = null;
                for (String emailAddress : mailMessage.getTos()) {
                    tos = (InternetAddress[]) ArrayUtils.add(tos, new InternetAddress(emailAddress));
                }
                helper.setTo(tos);
            }
            // 设置抄送地址
            if (ArrayUtils.isNotEmpty(mailMessage.getCcs())) {
                InternetAddress[] tos = null;
                for (String emailAddress : mailMessage.getCcs()) {
                    tos = (InternetAddress[]) ArrayUtils.add(tos, new InternetAddress(emailAddress));
                }
                message.setRecipients(Message.RecipientType.CC, tos);
            }
            // 设置抄送地址
            helper.setSubject(mailMessage.getSubject());
            // 设置写件人和写件人昵称
            helper.setFrom(mailMessage.getFrom(),mailMessage.getPersonal());
            // 设置内容
            helper.setText(mailMessage.getContent(), mailMessage.getHtML());

            // 将字符串转字节数组
            for(MailAttach mailAttach:mailMessage.getAttach()){
                byte[] byteArray = Base64.getDecoder().decode(mailAttach.getFile());
                // Gzip解压
                byteArray = IOUtils.unGZip(byteArray);
                // 添加附件
                helper.addAttachment(mailAttach.getName(), new ByteArrayResource(byteArray));
            }
            // 发送邮件
            mailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Content.RESPONSE_SUCCESS;
    }

}
