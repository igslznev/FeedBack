package com.common.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Question")
public class Question {

    public Question() {
    }

    public Question(String question, boolean required,
                    Interview interview, TypeOfQuestion type,
                    List<Variant> variants){
        this.question = question;
        this.required = required;
        this.interview = interview;
        this.type = type;

        for (Variant variant:
             variants) {
            variant.setQuestion(this);
        }
    }

    @Id
    @GeneratedValue
    @Column(name = "idQuestion")
    private int idQuestion;

    @Column(name = "question")
    private String question;

    @Column(name = "required")
    private boolean required;

    @ManyToOne
    @JoinColumn(name = "idInterview")
    private Interview interview;

    @ManyToOne
    @JoinColumn(name = "type")
    private TypeOfQuestion type;

    public void addVariant(Variant variant){
        variant.setQuestion(this);
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

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public TypeOfQuestion getType() {
        return type;
    }

    public void setType(TypeOfQuestion type) {
        this.type = type;
    }
}
