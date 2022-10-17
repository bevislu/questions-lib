package com.awesome.questionslib;

import com.awesome.questionslib.core.spring.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SessionAutoConfiguration.class})
public class QuestionsLibApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionsLibApplication.class, args);
    }

}
