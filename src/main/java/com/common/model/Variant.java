package com.common.model;

import javax.persistence.*;

@Entity
@Table(name = "Variant")
public class Variant {

    public Variant() {
    }

    public Variant(String variant){
        this.variant = variant;
    }

    @Id
    @GeneratedValue
    @Column(name = "idVariant")
    private Long idVariant;

    @Column(name = "variant")
    private String variant;

    @ManyToOne
    @JoinColumn(name = "idQuestion")
    private Question question;

    public Long getIdVariant() {
        return idVariant;
    }

    public void setIdVariant(Long idVariant) {
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

    public String toString() { return variant; }
}
