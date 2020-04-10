package com.emeldi.teachercomponent.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class LanguageDB {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String code;
    private String name;

    public LanguageDB(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public LanguageDB() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
