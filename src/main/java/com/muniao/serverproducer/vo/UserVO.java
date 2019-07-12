package com.muniao.serverproducer.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserVO
{
    private String userName;
    private int age;
    private Date birthday;
}
