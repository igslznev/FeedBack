package com.common.service;


import com.common.model.Interview;

import java.util.List;

public interface InterviewService {

    Interview addInterview(Interview interview);
    void delete(int id);
    Interview getById(int id);
    Interview editInterview(Interview interview);
    List<Interview> getAll();
    List<Interview> findByIdCreator(int id);
}
