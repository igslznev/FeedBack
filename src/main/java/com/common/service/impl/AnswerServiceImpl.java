package com.common.service.impl;

import com.common.model.Answer;
import com.common.repository.AnswerRepository;
import com.common.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer addAnswer(Answer answer) {
        return answerRepository.saveAndFlush(answer);
    }

    @Override
    public void delete(int id) {
        answerRepository.delete(id);
    }

    @Override
    public Answer getById(int id) {
        return answerRepository.getOne(id);
    }

    @Override
    public Answer editAnswer(Answer answer) {
        return answerRepository.saveAndFlush(answer);
    }

    @Override
    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    @Override
    public List<Answer> findByIdQuestion(int id) {
        return answerRepository.findByQuestion_IdQuestion(id);
    }


}
