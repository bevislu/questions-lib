package com.awesome.questionslib.pojo;

import lombok.Data;

@Data
public class Question {
    private String id;
    private String userId;
    private String summary;
    private String questionImg; // base64 format
    private String questionImgContentType;
    private String answerImg; // base64 format
    private String answerImgContentType;
    private long createdTimestamp;
    private long lastUpdatedTimestamp;
    private String subjectId;
    private int grade;
    private boolean mastered;
}
