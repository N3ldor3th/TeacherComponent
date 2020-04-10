package com.emeldi.teachercomponent.controller;

import com.emeldi.teachercomponent.model.Teacher;
import com.emeldi.teachercomponent.service.TeacherService;
import com.emeldi.teachercomponent.service.TeacherValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Teacher findById(@PathVariable("id") Long id) {
        return teacherService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Teacher teacher) {
        if (TeacherValidationService.validateTeacher(teacher)) {
            return teacherService.create(teacher);
        } else {
            return null;
        }

    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody Teacher teacher) {
        if (TeacherValidationService.validateTeacher(teacher)) {
            teacherService.update(id, teacher);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        teacherService.deleteById(id);
    }

}
