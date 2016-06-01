package com.common.service.impl;

import com.common.model.Interview;
import com.common.model.Question;
import com.common.repository.InterviewRepository;
import com.common.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("InterviewServiceImpl")
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
    public void delete(Long id) {
        List<Question> questions = questionService.findByIdInterview(id);
        //Delete of all questions
        for (Question question:
             questions) {
            questionService.delete(question.getIdQuestion());
        }

        interviewRepository.delete(id);
    }

    @Override
    public Interview getById(Long id) {
        return interviewRepository.findOne(id);
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
    public List<Interview> findByIdCreator(Long id) {
        return interviewRepository.findByCreator_IdUser(id);
    }


}
