package com.example.springmail.service.impl;


import com.example.springmail.entity.MailAttach;
import com.example.springmail.service.MailService;
import com.example.springmail.entity.MailMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.Assert.*;

/**
 * 发送邮件测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendMail() throws Exception {
        MailMessage mailMessage = new MailMessage();
        mailMessage.setPersonal("小哈");//发送人
        mailMessage.setFrom("324670547@qq.com");//发件地址
        mailMessage.setSubject("测试邮件");//主题
        mailMessage.setTos(new String[] { "mynamedlq@163.com" });//收件地址
        mailMessage.setCcs(new String[]{"dingliqiang@aspirecn.com"});//抄送地址
        mailMessage.setContent("这是一段测试内容");//内容
        mailMessage.setHtML(false);//设置是否为HTML形式

        File file1 = new File("d://test1.jpg");//文件1
        File file2 = new File("d://test2.jpg");//文件2
        mailMessage.setAttachs(new MailAttach[]{
                new MailAttach(file1.getName(),file1),
                new MailAttach(file1.getName(),file2)}
                );
        mailService.sendMail(mailMessage);
    }
}