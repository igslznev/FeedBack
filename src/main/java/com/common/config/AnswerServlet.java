package com.common.config;


import com.common.model.Answer;
import com.common.model.Interview;
import com.common.model.Question;
import com.common.service.AnswerService;
import com.common.service.InterviewService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

@WebServlet("/registerAnswer")
public class AnswerServlet extends HttpServlet {

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private AnswerService answerService;

    private WebApplicationContext springContext;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
        beanFactory.autowireBean(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Interview interview = interviewService.getById(Long.parseLong(request.getParameter("id")));



        for (Question question:
                interview.getQuestions()) {
            String str[] = request.getParameterValues("answer-" + question.getIdQuestion());
            if(str != null) {
                for (String s :
                        str) {
                    if(!s.equals("")) {
                        addAnswer(question, s);
                    } else {
                        addAnswer(question,"Not selected");
                    }
                }
            }  else {
                addAnswer(question,"Not selected");
            }
        }

        response.sendRedirect("successAnswer");
    }

    private void addAnswer(Question question, String ans) {
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setAnswer(ans);
        answer.setTime(new DateTime());
        answerService.addAnswer(answer);
    }
}
