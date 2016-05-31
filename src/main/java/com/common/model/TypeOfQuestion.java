package com.common.model;

import javax.persistence.*;

@Entity
@Table(name = "TypeOfQuestion")
public class TypeOfQuestion{

    @Id
    @Column(name = "idType")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idType;

    @Column(name = "typeOfQuestion")
    private String type;

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
