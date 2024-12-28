package com.example.school.service;

import com.example.school.client.StudentClient;
import com.example.school.dto.FullSchoolResponse;
import com.example.school.dto.SchoolRecord;
import com.example.school.dto.Student;
import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public SchoolService(SchoolRepository schoolRepository, StudentClient studentClient) {
        this.schoolRepository = schoolRepository;
        this.studentClient = studentClient;
    }

    public void saveSchool(SchoolRecord school) {
     School schoolEntity = new School(school.name(), school.email());
        schoolRepository.save(schoolEntity);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findAllSchoolsWithStudents(Integer schoolId) {
        var foundSchool = schoolRepository.findById(Math.toIntExact(Long.valueOf(schoolId))).orElse(
                new School("not_found", "not_found@example.com")
        );
        List<Student> foundStudents = studentClient.findAllStudentsBySchoolId(schoolId);
        return new FullSchoolResponse(foundSchool.getName(), foundSchool.getEmail(), foundStudents);
    }
}
