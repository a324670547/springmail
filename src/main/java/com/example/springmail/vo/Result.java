package com.example.springmail.vo;

import lombok.Data;

@Data
public class Result {
    private String message;
    private Integer code;
    private Object data;
}
