package com.emeldi.teachercomponent.persistence.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Entity
@Table(name = "timeSlot")
public class TimeSlotDB {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private DayOfWeek weekDay;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToOne
    private TeacherDB teacherDB;

    public TimeSlotDB(DayOfWeek weekDay, LocalDateTime startTime, LocalDateTime endTime, TeacherDB teacherDB) {
        this.weekDay = weekDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacherDB = teacherDB;
    }

    public TimeSlotDB(DayOfWeek weekDay, LocalDateTime startTime, LocalDateTime endTime) {
        this.weekDay = weekDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeSlotDB() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(DayOfWeek weekDay) {
        this.weekDay = weekDay;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public TeacherDB getTeacherDB() {
        return teacherDB;
    }

    public void setTeacherDB(TeacherDB teacherDB) {
        this.teacherDB = teacherDB;
    }
}
