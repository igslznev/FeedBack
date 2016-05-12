package com.common.service;

import com.common.model.QuestionMultCMultA;

import java.util.List;


public interface QuestionMCMAService {
    QuestionMultCMultA addQuestion(QuestionMultCMultA question);
    void delete(int id);
    QuestionMultCMultA getById(int id);
    QuestionMultCMultA editQuestion(QuestionMultCMultA question);
    List<QuestionMultCMultA> getAll();
}
