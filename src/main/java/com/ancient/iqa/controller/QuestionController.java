package com.ancient.iqa.controller;

import com.ancient.iqa.dto.InterviewQuestionDto;
import com.ancient.iqa.service.QuestionService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    public InterviewQuestionDto createQuestion(String q, String a){
        return questionService.addQuestion(q, a);
    }

    public List<InterviewQuestionDto> getQuestions() {
        return questionService.getAllQuestions();
    }
}
