package com.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FeedbackController {

    @RequestMapping("/")
    public String initializeForm(Map model)
    {
        return "createInterview";

    }

}
