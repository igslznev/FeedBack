package com.common.controller;

import com.common.model.Interview;
import com.common.service.InterviewService;
import com.common.service.impl.InterviewServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Map;

@Controller
public class FeedbackController {

    @Autowired
    private InterviewService interviewService;

    /*@ModelAttribute("interviews")
    private List<Interview> getInterviews(){
        return interviewService.getAll();
    }*/

    @RequestMapping("/")
    public String initializeForm(Map model)
    {
        model.put("interviews", interviewService.getAll());
        return "feedback";

    }

    @RequestMapping(value = "/interview")
    public String interviewInitialize(@RequestParam(value = "id") Long id,Map model)
    {
        model.put("interview", interviewService.getById(id));

        return "interview";

    }

}
