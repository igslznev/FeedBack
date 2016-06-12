package com.common.controller;

import com.common.model.Interview;
import com.common.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class FeedbackController {

    @Autowired
    private InterviewService interviewService;

    @RequestMapping("/")
    public String initializeForm(Map model)
    {
        List<Interview> activeInterviews = new ArrayList<Interview>();
        List<Interview> interviews = interviewService.getAll();

        for (Interview interview:
             interviews) {
            if(interview.getStartTime() != null && interview.getFinishTime() != null) {
                if (interview.getStartTime().isBeforeNow() && interview.getFinishTime().isAfterNow() ) {
                    activeInterviews.add(interview);
                }
            } else {
                activeInterviews.add(interview);
            }

        }
        model.put("interviews", activeInterviews);
        return "feedback";

    }

    @RequestMapping(value = "/interviews")
    public String interviewInitialize(@RequestParam(value = "id", required = true) Long id,Map model)
    {
        model.put("interview", interviewService.getById(id));

        return "interview";

    }
    @RequestMapping(value = "/successAnswer")
    public String successAnswerInitialize(Map model)
    {
        return "successAnswer";

    }
}
