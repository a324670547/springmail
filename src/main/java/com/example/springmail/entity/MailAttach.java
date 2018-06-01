package com.example.springmail.entity;

import com.example.springmail.utils.IOUtils;

import java.io.*;
import java.util.Base64;

public class MailAttach implements Serializable {
    private static final long serialVersionUID = -814007059460673973L;

    // 附件名
    private String name;
    // 用于存二进制的字符串
    private String file;
    // 存储输入流
    private transient InputStream input;

    public MailAttach(){}
    public MailAttach(String name,InputStream input) throws Exception {
        this.name=name;
        this.file=fileToString(input);
    }
    public MailAttach(String name,File file) throws Exception {
        this.name=name;
        this.file=fileToString(new FileInputStream(file));
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public InputStream getInput() {
        return input;
    }
    public void setInput(InputStream input) throws Exception {
        this.file = fileToString(input);
    }
    public void setInput(File file) throws Exception {
        this.file = fileToString(new FileInputStream(file));
    }
    public String getFile() {
        return file;
    }

    public String toString() {
        return "MailAttach{" +
                "name='" + name + '\'' +
                ", file='" + file + '\'' + '}';
    }

    public String fileToString(InputStream input) throws Exception{
        // 将流转换成字节数组
        byte[] data = IOUtils.readStream(input);
        // 将字节数组压缩
        data = IOUtils.compress(data);
        // 将字节数组转换成base64字符串
        data = Base64.getEncoder().encode(data);
        // 将二进制文件写入实体类字符串
        return new String(data);
    }

}
