package com.emeldi.teachercomponent.persistence.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class TeacherDB {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String skype;
    private String name;
    private String surname;
    private String country;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "teacher_id")
    private Set<LanguageDB> languages = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "timeSlot_id")
    private Set<TimeSlotDB> timeSlots = new HashSet<>();

    public TeacherDB(Long id, String email, String skype, String name, String surname, String country, Set<LanguageDB> languages, Set<TimeSlotDB> timeSlots) {
        this.id = id;
        this.email = email;
        this.skype = skype;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.languages = languages;
        this.timeSlots = timeSlots;
    }

    public TeacherDB() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<LanguageDB> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<LanguageDB> languages) {
        this.languages = languages;
    }

    public Set<TimeSlotDB> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(Set<TimeSlotDB> timeSlots) {
        this.timeSlots = timeSlots;
    }
}
