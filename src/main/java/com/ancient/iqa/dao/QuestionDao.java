package com.ancient.iqa.dao;

import com.ancient.iqa.model.InterviewQuestion;

import java.util.List;

public interface QuestionDao {
    InterviewQuestion save(InterviewQuestion entity);
    List<InterviewQuestion> findAll();
}
