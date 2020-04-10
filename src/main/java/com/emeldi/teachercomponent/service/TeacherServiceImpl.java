package com.emeldi.teachercomponent.service;

import com.emeldi.teachercomponent.model.Teacher;
import com.emeldi.teachercomponent.persistence.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public Teacher findById(Long id) {
        return null;
    }

    @Override
    public Long create(Teacher teacher) {
        return null;
    }

    @Override
    public void update(Teacher resource) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
