package com.emeldi.teachercomponent.persistence;

import com.emeldi.teachercomponent.persistence.model.TeacherDB;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<TeacherDB, Long> {
}
