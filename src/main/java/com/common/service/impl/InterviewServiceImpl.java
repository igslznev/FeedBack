package com.common.service.impl;

import com.common.model.Interview;
import com.common.model.Question;
import com.common.repository.InterviewRepository;
import com.common.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private QuestionServiceImpl questionService;

    @Override
    public Interview addInterview(Interview interview) {
        return interviewRepository.saveAndFlush(interview);
    }

    @Override
    public void delete(int id) {
        List<Question> questions = questionService.findByIdInterview(id);
        //Delete of all questions
        for (Question question:
             questions) {
            questionService.delete(question.getIdQuestion());
        }

        interviewRepository.delete(id);
    }

    @Override
    public Interview getById(int id) {
        return interviewRepository.getOne(id);
    }

    @Override
    public Interview editInterview(Interview interview) {
        return interviewRepository.saveAndFlush(interview);
    }

    @Override
    public List<Interview> getAll() {
        return interviewRepository.findAll();
    }

    @Override
    public List<Interview> findByIdCreator(int id) {
        return interviewRepository.findByCreator_IdUser(id);
    }


}
