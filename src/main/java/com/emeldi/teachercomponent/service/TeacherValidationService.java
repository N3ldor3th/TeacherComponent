package com.emeldi.teachercomponent.service;

import com.emeldi.teachercomponent.model.Teacher;
import com.emeldi.teachercomponent.model.TimeSlot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.regex.Pattern;

@Service
public class TeacherValidationService {

    private Logger logger = LoggerFactory.getLogger(TeacherValidationService.class);

    public static final String EMAIL_REGEX = "^(.+)@(.+)$";

    public boolean validateTeacher(Teacher teacher) {
        boolean isValid = true;
        if (!isEmailValid(teacher.getEmail())) {
            logger.debug("email in bad format : " + teacher.getEmail());
            isValid = false;
        }
        Set<TimeSlot> timeSlots = teacher.getTimeSlots();
        if (!CollectionUtils.isEmpty(timeSlots)) {
            for (TimeSlot timeSlot : timeSlots) {
                if (!isStartTimeBeforeEndTime(timeSlot.getStartTime(), timeSlot.getEndTime())) {
                    logger.debug("start time is after end time : " + timeSlot.getStartTime() + " > " + timeSlot.getEndTime());
                    isValid = false;
                }
            }
        }
        return isValid;
    }

    public boolean isEmailValid(String email) {
        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        return emailPattern.matcher(email).matches();
    }

    public boolean isStartTimeBeforeEndTime(LocalDateTime startTime, LocalDateTime endTime) {
        return startTime.isBefore(endTime);
    }
}
