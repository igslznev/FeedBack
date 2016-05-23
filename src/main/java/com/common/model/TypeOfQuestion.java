package com.common.model;

import javax.persistence.*;

@Entity
@Table(name = "Type of question")
public class TypeOfQuestion {

    @Id
    @Column(name = "typeOfQuestion")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
