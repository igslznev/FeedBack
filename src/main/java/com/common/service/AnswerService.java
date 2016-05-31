package com.common.service;


import com.common.model.Answer;

import java.util.List;

public interface AnswerService {

    Answer addAnswer(Answer answer);
    void delete(Long id);
    Answer getById(Long id);
    Answer editAnswer(Answer answer);
    List<Answer> getAll();
    List<Answer> findByIdQuestion(Long id);
}
