package com.awesome.questionslib.core.spring.aspect;

import com.awesome.questionslib.controller.NoOpController;
import com.awesome.questionslib.exception.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = {NoOpController.class})
public class CustomExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(EntityNotFoundException exp) {
        return ResponseEntity.notFound().build();
    }

}
