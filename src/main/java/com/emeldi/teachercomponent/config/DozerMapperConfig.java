package com.emeldi.teachercomponent.config;

import com.emeldi.teachercomponent.model.Language;
import com.emeldi.teachercomponent.model.Teacher;
import com.emeldi.teachercomponent.model.TimeSlot;
import com.emeldi.teachercomponent.persistence.model.LanguageDB;
import com.emeldi.teachercomponent.persistence.model.TeacherDB;
import com.emeldi.teachercomponent.persistence.model.TimeSlotDB;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DozerMapperConfig {

    @Bean
    public BeanMappingBuilder beanMappingBuilder() {
        return new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(TeacherDB.class, Teacher.class);
                mapping(LanguageDB.class, Language.class);
                mapping(TimeSlotDB.class, TimeSlot.class);
            }
        };
    }

    @Bean
    public DozerBeanMapper beanMapper() {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        List<String> mappingFiles = new ArrayList();
        mappingFiles.add("dozerJdk8Converters.xml");
        dozerBeanMapper.setMappingFiles(mappingFiles);
        dozerBeanMapper.addMapping(beanMappingBuilder());
        return dozerBeanMapper;
    }
}
