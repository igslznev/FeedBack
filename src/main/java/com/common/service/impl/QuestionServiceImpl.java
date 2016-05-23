package com.common.service.impl;

import com.common.model.Question;
import com.common.repository.InterviewRepository;
import com.common.repository.QuestionRepository;
import com.common.repository.VariantRepository;
import com.common.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.saveAndFlush(question);
    }

    @Override
    public void delete(int id) {
        questionRepository.delete(id);
    }

    @Override
    public Question getById(int id) {
        return questionRepository.getOne(id);
    }

    @Override
    public Question editQuestion(Question question) {
        return questionRepository.saveAndFlush(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> findByIdInterview(int id) {
        return questionRepository.findByInterview_IdInterview(id);
    }
}
