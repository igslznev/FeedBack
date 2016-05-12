package com.common.controller;

import com.common.model.QuestionMultCMultA;
import com.common.service.impl.QuestionMCMAServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class FeedbackController {
    
    private QuestionMCMAServiceImpl questionMCMAService;

    @ModelAttribute("questionText")
    public String getQuestionText()
    {
        QuestionMultCMultA questionMultCMultA = questionMCMAService.getById(1);
        return questionMultCMultA.getQuestion();
    }

    @ModelAttribute("answersList")
    public List getAnswersList()
    {
        QuestionMultCMultA questionMultCMultA = questionMCMAService.getById(1);
        return questionMultCMultA.getAnswers();
    }

    @RequestMapping("/")
    public String initializeForm(Map model)
    {
        QuestionMultCMultA ca = new QuestionMultCMultA();
        model.put("ca",ca);
        return "feedback";

    }

}
