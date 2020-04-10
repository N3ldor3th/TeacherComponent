package com.emeldi.teachercomponent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class TimeSlot {
    @JsonIgnore
    private Long id;
    private DayOfWeek weekDay;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public TimeSlot(DayOfWeek weekDay, LocalDateTime startTime, LocalDateTime endTime) {
        this.weekDay = weekDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeSlot() {
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

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", weekDay=" + weekDay +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
