package com.common.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Question")
public class Question {

    public Question() {
    }

    public Question(String question, boolean required,
                    Interview interview, TypeOfQuestion type,
                    Set<Variant> variants){
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idQuestion")
    private Long idQuestion;

    @Column(name = "question")
    private String question;

    @Column(name = "required")
    private boolean required;

    @ManyToOne
    @JoinColumn(name = "idInterview")
    private Interview interview;

    @ManyToOne
    @JoinColumn(name = "idType")
    private TypeOfQuestion type;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="idQuestion")
    Set<Variant> variants;

    public Set<Variant> getVariants() {
        return variants;
    }

    public void setVariants(final Set<Variant> variants) {
        this.variants = variants;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
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
