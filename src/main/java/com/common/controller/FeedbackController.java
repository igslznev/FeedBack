package com.common.controller;

import com.common.model.Interview;
import com.common.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class FeedbackController {

    @Autowired
    private InterviewService interviewService;

    @RequestMapping("/")
    public String initializeForm(Map model)
    {
        model.put("interviews", interviewService.getAll());
        return "feedback";

    }

    @RequestMapping(value = "/interviews")
    public String interviewInitialize(@RequestParam(value = "id", required = true) Long id,Map model)
    {
        model.put("interview", interviewService.getById(id));

        return "interview";

    }
    @RequestMapping(value = "/successAnswer")
    public String successAnswerInitialize(/*@RequestParam(value = "id", required = true) Long id, */Map model)
    {
        //model.put("interview", interviewService.getById(id));

        return "successAnswer";

    }
}
