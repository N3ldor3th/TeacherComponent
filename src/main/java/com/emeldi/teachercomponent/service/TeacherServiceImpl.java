package com.emeldi.teachercomponent.service;

import com.emeldi.teachercomponent.model.Teacher;
import com.emeldi.teachercomponent.persistence.TeacherRepository;
import com.emeldi.teachercomponent.persistence.model.LanguageDB;
import com.emeldi.teachercomponent.persistence.model.TeacherDB;
import com.emeldi.teachercomponent.persistence.model.TimeSlotDB;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    @Cacheable("teachers")
    public List<Teacher> findAll() {
        List<TeacherDB> teachersDB = teacherRepository.findAll();
        List<Teacher> teachers = new ArrayList<>();
        teachersDB.forEach(teacherDB -> teachers.add(mapper.map(teacherDB, Teacher.class)));
        return teachers;
    }

    @Override
    @Cacheable("teacher")
    public Teacher findById(Long id) {
        Optional<TeacherDB> teacherDB = teacherRepository.findById(id);
        Teacher teacher = new Teacher();
        if (teacherDB.isPresent()) {
            teacher = mapper.map(teacherDB.get(), Teacher.class);
        }
        return teacher;
    }

    @Override
    public Long create(Teacher teacher) {
        TeacherDB teacherDB = mapper.map(teacher, TeacherDB.class);
        teacherRepository.save(teacherDB);
        return teacherDB.getId();
    }

    @Override
    public void update(Long id, Teacher teacher) {
        Optional<TeacherDB> teacherDB = teacherRepository.findById(id);
        if (teacherDB.isPresent()) {
            TeacherDB teacherUpdated = updateTeacherDB(teacher, teacherDB.get());
            teacherRepository.save(teacherUpdated);
        }
    }

    @Override
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    private TeacherDB updateTeacherDB(Teacher teacher, TeacherDB teacherDB) {
        teacherDB.setCountry(teacher.getCountry());
        teacherDB.setEmail(teacher.getEmail());
        teacherDB.setName(teacher.getName());
        teacherDB.setSurname(teacher.getSurname());
        teacherDB.setSkype(teacher.getSkype());
        if (!CollectionUtils.isEmpty(teacher.getLanguages())) {
            Set<LanguageDB> languagesUpdated = teacherDB.getLanguages();
            languagesUpdated.clear();
            teacher.getLanguages().forEach(language -> {
                LanguageDB languageUpdated = new LanguageDB();
                languageUpdated.setCode(language.getCode());
                languageUpdated.setName(language.getName());
                languagesUpdated.add(languageUpdated);
            });
            teacherDB.getLanguages().addAll(languagesUpdated);
        }
        if (!CollectionUtils.isEmpty(teacher.getTimeSlots())) {
            Set<TimeSlotDB> timeSlotsUpdated = teacherDB.getTimeSlots();
            timeSlotsUpdated.clear();
            teacher.getTimeSlots().forEach(timeSlot -> {
                TimeSlotDB timeSlotUpdated = new TimeSlotDB();
                timeSlotUpdated.setWeekDay(timeSlot.getWeekDay());
                timeSlotUpdated.setStartTime(timeSlot.getStartTime());
                timeSlotUpdated.setEndTime(timeSlot.getEndTime());
                timeSlotsUpdated.add(timeSlotUpdated);
            });
            teacherDB.getTimeSlots().addAll(timeSlotsUpdated);
        }
        return teacherDB;
    }
}
