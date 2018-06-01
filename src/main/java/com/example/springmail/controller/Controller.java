package com.example.springmail.controller;

import com.example.springmail.vo.Content;
import com.example.springmail.entity.MailMessage;
import com.example.springmail.vo.Result;
import com.example.springmail.service.MailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private MailService mailService;

    @PostMapping("/sendMail")
    public Result MailMessage(MailMessage mailMessage){
        Result result = new Result();

        Integer n = mailService.sendMail(mailMessage);
        if(n!=Content.RESPONSE_SUCCESS){
            result.setCode(Content.RESPONSE_FAIL);
            result.setMessage("发送失败");
        }
        result.setCode(Content.RESPONSE_SUCCESS);
        result.setMessage("发送成功");
        return result;
    }
}
