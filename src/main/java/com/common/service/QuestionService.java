package com.common.service;


import com.common.model.Question;

import java.util.List;

public interface QuestionService {
    Question addQuestion(Question question);
    void delete(int id);
    Question getById(int id);
    Question editQuestion(Question question);
    List<Question> getAll();
    List<Question> findByIdInterview(int id);
}
