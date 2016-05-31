package com.common.model;


import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "Answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAnswer")
    private Long idAnswer;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idQuestion")
    private Question question;

    @Column(name = "answer")
    String answer;

    @Column(name = "time")
    Time time;
//    **Time of answer**
//    public class MyEntity {
//        ...
//        @Temporal(TemporalType.TIMESTAMP)
//        private java.util.Date myDate;
//        ...
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Long idAnswer) {
        this.idAnswer = idAnswer;
    }
}
