package com.emeldi.teachercomponent.service;

import com.emeldi.teachercomponent.model.Teacher;
import com.emeldi.teachercomponent.model.TimeSlot;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.regex.Pattern;

@Service
public class TeacherValidationService {

    public static final String EMAIL_REGEX = "^(.+)@(.+)$";

    public static boolean validateTeacher(Teacher teacher) {
        boolean isValid = true;
        if (!isEmailValid(teacher.getEmail())) {
            isValid = false;
        }
        Set<TimeSlot> timeSlots = teacher.getTimeSlots();
        if (!CollectionUtils.isEmpty(timeSlots)) {
            for (TimeSlot timeSlot : timeSlots) {
                if (!isStartTimeBeforeEndTime(timeSlot.getStartTime(), timeSlot.getEndTime())) {
                    isValid = false;
                }
            }
        }
        return isValid;
    }

    public static boolean isEmailValid(String email) {
        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        return emailPattern.matcher(email).matches();
    }

    public static boolean isStartTimeBeforeEndTime(LocalDateTime startTime, LocalDateTime endTime) {
        return startTime.isBefore(endTime);
    }
}
