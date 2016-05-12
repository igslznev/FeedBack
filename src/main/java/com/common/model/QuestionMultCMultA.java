package com.common.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//multiple choice - multiple answer
@Entity
@Table(name = "QuestionMultCMultA")
public class QuestionMultCMultA {

    @Id
    @GeneratedValue
    @Column(name = "idQuestion")
    private int idQuestion;

    @Column(name = "QuestionText")
    private String question;

    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AnswerMultCMultA> answers = new ArrayList<AnswerMultCMultA>();

    public void addAnswer(AnswerMultCMultA answer) {
        answer.setQuestion(this);
        answers.add(answer);
    }

    public List<AnswerMultCMultA> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerMultCMultA> answers) {
        this.answers = answers;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
