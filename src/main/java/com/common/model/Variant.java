package com.common.model;

import javax.persistence.*;

@Entity
@Table(name = "Variant")
public class Variant {

    public Variant() {
    }

    public Variant(String variant, Question question){
        this.variant = variant;
        this.question = question;
    }
    @Id
    @GeneratedValue
    @Column(name = "idVariant")
    private int idVariant;

    @Column(name = "variant")
    private String variant;

    @ManyToOne
    @JoinColumn(name = "idQuestion")
    private Question question;

    public int getIdVariant() {
        return idVariant;
    }

    public void setIdVariant(int idVariant) {
        this.idVariant = idVariant;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
