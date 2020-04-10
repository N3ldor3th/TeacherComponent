package com.emeldi.teachercomponent.model;

import java.util.Set;

public class Teacher {
    private Long id;
    private String email;
    private String name;
    private String surname;
    private String country;
    private Set<Language> languages;
    private Set<TimeSlot> timeSlots;

    public Teacher(Long id, String email, String name, String surname, String country, Set<Language> languages, Set<TimeSlot> timeSlots) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.languages = languages;
        this.timeSlots = timeSlots;
    }

    public Teacher() {
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

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Set<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(Set<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", languages=" + languages +
                ", timeSlots=" + timeSlots +
                '}';
    }
}
