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
    @ManyToOne
    private TeacherDB teacherDB;

    public LanguageDB(String code, String name, TeacherDB teacherDB) {
        this.code = code;
        this.name = name;
        this.teacherDB = teacherDB;
    }

    public LanguageDB(String code, String name) {
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

    public TeacherDB getTeacherDB() {
        return teacherDB;
    }

    public void setTeacherDB(TeacherDB teacherDB) {
        this.teacherDB = teacherDB;
    }
}
