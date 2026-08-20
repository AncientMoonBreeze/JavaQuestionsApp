package com.ancient.iqa.initdata;

import com.ancient.iqa.dao.QuestionDao;
import com.ancient.iqa.model.InterviewQuestion;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final QuestionDao questionDao;

    public DataInitializer(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @PostConstruct
    public void init(){
        questionDao.save(new InterviewQuestion(null, "Что такое ООП?", "Объектно-ориентированное программирование"));
        questionDao.save(new InterviewQuestion(null, "Что такое JVM?", "Java Virtual Machine — виртуальная машина Java"));
        questionDao.save(new InterviewQuestion(null, "Чем String отличается от StringBuilder?", "String — immutable (неизменяемый), а StringBuilder — mutable"));
    }
}
