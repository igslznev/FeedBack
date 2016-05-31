package com.common.service;


import com.common.model.Interview;

import java.util.List;

public interface InterviewService {

    Interview addInterview(Interview interview);
    void delete(Long id);
    Interview getById(Long id);
    Interview editInterview(Interview interview);
    List<Interview> getAll();
    List<Interview> findByIdCreator(Long id);
}
