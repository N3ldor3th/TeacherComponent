package com.emeldi.teachercomponent.config;

import com.emeldi.teachercomponent.persistence.TeacherRepository;
import com.emeldi.teachercomponent.persistence.model.LanguageDB;
import com.emeldi.teachercomponent.persistence.model.TeacherDB;
import com.emeldi.teachercomponent.persistence.model.TimeSlotDB;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Set;

@Configuration
public class RepositoryConfig {

    @Bean
    public CommandLineRunner dataInitializer(TeacherRepository teacherRepository) {
        return args -> {
            TeacherDB teacher1 = new TeacherDB();
            LanguageDB language1 = new LanguageDB("cs","Czech");
            LanguageDB language2 = new LanguageDB("da","Danish");
            LanguageDB language3 = new LanguageDB("en","English");
            TimeSlotDB timeSlot1 = new TimeSlotDB(DayOfWeek.FRIDAY, LocalDateTime.now(), LocalDateTime.now().plusMinutes(60));
            TimeSlotDB timeSlot2 = new TimeSlotDB(DayOfWeek.SATURDAY, LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusMinutes(90));
            teacher1.setName("Jan");
            teacher1.setSurname("Novak");
            teacher1.setEmail("NovakJan@gmail.com");
            teacher1.setSkype("novakjan90");
            teacher1.setCountry("Czech Republic");
            teacher1.setLanguages(Set.of(language1, language2, language3));
            teacher1.setTimeSlots(Set.of(timeSlot1, timeSlot2));

            TeacherDB teacher2 = new TeacherDB();
            LanguageDB language4 = new LanguageDB("fi","Finnish");
            LanguageDB language5 = new LanguageDB("de","German");
            TimeSlotDB timeSlot3 = new TimeSlotDB(DayOfWeek.SUNDAY, LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusMinutes(120));
            TimeSlotDB timeSlot4 = new TimeSlotDB(DayOfWeek.MONDAY, LocalDateTime.now().plusDays(3), LocalDateTime.now().plusDays(3).plusMinutes(90));
            teacher2.setName("Aneta");
            teacher2.setSurname("Ruzickova");
            teacher2.setEmail("ruzickovaAneta@gmail.com");
            teacher2.setSkype("ruzickovaAneta");
            teacher2.setCountry("Slovak");
            teacher2.setLanguages(Set.of(language4, language5));
            teacher2.setTimeSlots(Set.of(timeSlot3, timeSlot4));

            teacherRepository.save(teacher1);
            teacherRepository.save(teacher2);
        };
    }
}


