package com.common.model;

import org.hibernate.annotations.Type;

import org.joda.time.DateTime;
import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Interview")
public class Interview {

    public Interview() {
    }

    public Interview(String title, String description, List<Question> questions) {
        this.title = title;
        this.description = description;
        for (Question question :
                questions) {
            question.setInterview(this);
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idInterview")
    private Long idInterview;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "startTime")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime startTime;

    @Column(name = "finishTime")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime finishTime;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idInterview")
    private Set<Question> questions;

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Long getIdInterview() {
        return idInterview;
    }

    public void setIdInterview(Long idInterview) {
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

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(DateTime finishTime) {
        this.finishTime = finishTime;
    }
}
