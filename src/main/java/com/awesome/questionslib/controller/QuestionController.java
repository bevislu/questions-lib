package com.awesome.questionslib.controller;

import com.awesome.questionslib.exception.EntityNotFoundException;
import com.awesome.questionslib.pojo.Question;
import com.awesome.questionslib.util.ImageEncoder;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    @GetMapping
    public List<Question> listQuestion() {
        return Collections.EMPTY_LIST;
    }

    @GetMapping("{questionId}")
    public Question getQuestion(@PathVariable(value = "questionId") String qId) {
        return null;
    }

    @PostMapping(consumes = "multipart/form-data")
    public Question createQuestion(
            Question question,
            @RequestParam(value = "questionAttachment") List<MultipartFile> questionAttachments,
            @RequestParam(value = "answerAttachment", required = false) List<MultipartFile> answerAttachments
    ) throws IOException {
        question.setId(UUID.randomUUID().toString());
        question.setCreatedTimestamp(Instant.now().toEpochMilli());
        question.setLastUpdatedTimestamp(question.getCreatedTimestamp());
        if (CollectionUtils.isNotEmpty(questionAttachments)) {
            MultipartFile questionFile = questionAttachments.get(0);
            byte[] compressedQImage = ImageEncoder.compressImage(questionFile.getInputStream());
            question.setQuestionImg(ImageEncoder.base64(compressedQImage, questionFile.getContentType()));
        }

        if (CollectionUtils.isNotEmpty(answerAttachments)) {
            MultipartFile answerFile = answerAttachments.get(0);
            byte[] compressedAImage = ImageEncoder.compressImage(answerFile.getInputStream());
            question.setAnswerImg(ImageEncoder.base64(compressedAImage, answerFile.getContentType()));
        }

        return question;
    }

    @PutMapping(value = "{questionId}", consumes = "multipart/form-data")
    public Question updateQuestion(
            @PathVariable(value = "questionId") String qId,
            Question question,
            @RequestParam(value = "questionAttachment") List<MultipartFile> questionAttachments,
            @RequestParam(value = "answerAttachment", required = false) List<MultipartFile> answerAttachments
    ) {
        return null;
    }

    @DeleteMapping("{questionId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestion(@PathVariable(value = "questionId") String qId) {
        if (StringUtils.isNotBlank(qId) && qId.length() < 5) {
            throw new EntityNotFoundException("entity not found");
        }
    }

}
