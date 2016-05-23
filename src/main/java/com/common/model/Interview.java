package com.common.model;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.sql.*;
import java.util.List;

@Entity
@Table(name = "Interview")
public class Interview {

    public Interview() {
    }

    public Interview(String title, String description, List<Question> questions) {
        this.title = title;
        this.description = description;
        for (Question question:
             questions) {
            question.setInterview(this);
        }
    }

    @Id
    @GeneratedValue
    @Column(name = "idInterview")
    private int idInterview;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User creator;

    @Column(name = "startTime")
    private Time startTime;

    @Column(name = "finishTime")
    private Time finishTime;

    public void addQuestion(Question question) {
        question.setInterview(this);
    }

    public int getIdInterview() {
        return idInterview;
    }

    public void setIdInterview(int idInterview) {
        this.idInterview = idInterview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Time finishTime) {
        this.finishTime = finishTime;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
