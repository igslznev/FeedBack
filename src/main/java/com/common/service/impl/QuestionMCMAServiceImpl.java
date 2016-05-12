package com.common.service.impl;


import com.common.model.QuestionMultCMultA;
import com.common.repository.QuestionMCMARepository;
import com.common.service.QuestionMCMAService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionMCMAServiceImpl implements QuestionMCMAService{

    @Autowired
    private QuestionMCMARepository questionMCMARepository;

    @Override
    public QuestionMultCMultA addQuestion(QuestionMultCMultA question) {
        QuestionMultCMultA savedQuestion = questionMCMARepository.saveAndFlush(question);
        return savedQuestion;
    }

    @Override
    public void delete(int id) {
        questionMCMARepository.delete(id);
    }

    @Override
    public QuestionMultCMultA getById(int id) {
        return questionMCMARepository.findOne(id);
    }

    @Override
    public QuestionMultCMultA editQuestion(QuestionMultCMultA question) {
        return questionMCMARepository.saveAndFlush(question);
    }

    @Override
    public List<QuestionMultCMultA> getAll() {
        return questionMCMARepository.findAll();
    }
}
