package com.common.controller;

import com.common.model.Interview;
import com.common.service.impl.InterviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class FeedbackController {

    @Autowired
    private InterviewServiceImpl interviewService;

    @ModelAttribute("interviews")
    private List<Interview> getInterviews(){
        return interviewService.getAll();
    }

    @RequestMapping("/")
    public String initializeForm(Map model)
    {
        return "feedback";

    }

    @RequestMapping("/{idInterveiw}")
    public String interviewInitalize(@RequestParam("idInterveiw") Long id)
    {

        return "feedback";

    }

}
