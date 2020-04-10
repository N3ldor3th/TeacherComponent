package com.emeldi.teachercomponent.persistence;

import com.emeldi.teachercomponent.persistence.model.TeacherDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherDB, Long> {
}
