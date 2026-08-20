package com.ancient.iqa.dao;

import com.ancient.iqa.model.InterviewQuestion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryQuestionDao implements QuestionDao{
    private final List<InterviewQuestion> storage = new ArrayList<>();
    private int currentId = 1;

    @Override
    public InterviewQuestion save(InterviewQuestion entity) {
        entity.setId(currentId++);
        storage.add(entity);
        return entity;
    }

    @Override
    public List<InterviewQuestion> findAll() {
        return new ArrayList<>(storage);
    }
}
