package com.awesome.questionslib.pojo;

import lombok.Data;

@Data
public class User {
    private String id;
    private String accountId;
    private String firstName;
    private String lastName;
    private int grade;
}
