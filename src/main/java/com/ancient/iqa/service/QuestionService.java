package com.ancient.iqa.service;

import com.ancient.iqa.dao.QuestionDao;
import com.ancient.iqa.dto.InterviewQuestionDto;
import com.ancient.iqa.model.InterviewQuestion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionDao questionDao;

    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public InterviewQuestionDto addQuestion(String question, String answer){
        InterviewQuestion entity = new InterviewQuestion(null, question ,answer);
        InterviewQuestion saved = questionDao.save(entity);
        return new InterviewQuestionDto(saved.getId() , saved.getQuestion(), saved.getAnswer());
    }

    public List<InterviewQuestionDto> getAllQuestions(){
        return questionDao.findAll().stream().map(q -> new InterviewQuestionDto(q.getId(), q.getQuestion(), q.getAnswer())).toList();
    }
}
