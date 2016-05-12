package com.common.model;

import javax.persistence.*;

//multiple choice - multiple answer
@Entity
@Table(name = "AnswerMultCMultA")
public class AnswerMultCMultA {

    @Id
    @GeneratedValue
    @Column(name = "idAnswer")
    private int idAnswer;

    @ManyToOne
    @JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion")
    private QuestionMultCMultA question;

    private String answer;

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public QuestionMultCMultA getQuestion() {
        return question;
    }

    public void setQuestion(QuestionMultCMultA question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
