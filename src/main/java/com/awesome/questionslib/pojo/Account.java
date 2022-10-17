package com.awesome.questionslib.pojo;

import lombok.Data;

@Data
public class Account {
    private String id;
    private String mobileNumber;
    private String email;
    private String firstName;
    private String lastName;
    private int gender;
    private long createdTimestamp;
    private String createdChannel; // wechat, alipay
}
