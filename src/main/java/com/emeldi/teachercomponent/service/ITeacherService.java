package com.emeldi.teachercomponent.service;

import com.emeldi.teachercomponent.model.Teacher;

import java.util.List;

public interface ITeacherService {

    List<Teacher> findAll();

    Teacher findById(Long id);

    Long create(Teacher teacher);

    void update(Teacher resource);

    void deleteById(Long id);
}
