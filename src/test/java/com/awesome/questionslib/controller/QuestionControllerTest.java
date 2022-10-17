package com.awesome.questionslib.controller;

import com.awesome.questionslib.core.spring.config.WebSecurityConfig;
import com.awesome.questionslib.core.spring.provider.CustomIdentityAuthenticationProvider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;

@WebMvcTest({QuestionController.class})
@Import({CustomIdentityAuthenticationProvider.class, WebSecurityConfig.class})
class QuestionControllerTest {

    @Test
    void createQuestion() {
    }
}