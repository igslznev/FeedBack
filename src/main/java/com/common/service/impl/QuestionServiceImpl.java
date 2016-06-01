package com.common.service.impl;

import com.common.model.Answer;
import com.common.model.Question;
import com.common.model.Variant;
import com.common.repository.QuestionRepository;
import com.common.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("QuestionServiceImpl")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerServiceImpl answerService;

    @Autowired
    private VariantServiceImpl variantService;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.saveAndFlush(question);
    }

    @Override
    public void delete(Long id) {

        List<Answer> answers = answerService.findByIdQuestion(id);
        //Delete of all answers
        for (Answer answer:
             answers) {
            answerService.delete(answer.getIdAnswer());
        }

        List<Variant> variants = variantService.findByIdQuestion(id);
        //Delete of all variant
        for (Variant variant:
                variants) {
            answerService.delete(variant.getIdVariant());
        }

        questionRepository.delete(id);
    }

    @Override
    public Question getById(Long id) {
        return questionRepository.findOne(id);
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
    public List<Question> findByIdInterview(Long id) {
        return questionRepository.findByInterview_IdInterview(id);
    }
}
