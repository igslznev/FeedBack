package com.common.service.impl;

import com.common.model.Answer;
import com.common.repository.AnswerRepository;
import com.common.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AnswerServiceImpl")
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer addAnswer(Answer answer) {
        return answerRepository.saveAndFlush(answer);
    }

    @Override
    public void delete(Long id) {
        answerRepository.delete(id);
    }

    @Override
    public Answer getById(Long id) {
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
    public List<Answer> findByIdQuestion(Long id) {
        return answerRepository.findByQuestion_IdQuestion(id);
    }


}
