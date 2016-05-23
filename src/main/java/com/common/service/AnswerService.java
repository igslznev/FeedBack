package com.common.service;


import com.common.model.Answer;

import java.util.List;

public interface AnswerService {

    Answer addAnswer(Answer answer);
    void delete(int id);
    Answer getById(int id);
    Answer editAnswer(Answer answer);
    List<Answer> getAll();
    List<Answer> findByIdQuestion(int id);
}
