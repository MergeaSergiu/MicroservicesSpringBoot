package com.example.students.service;

import com.example.students.dto.StudentRecord;
import com.example.students.entity.Student;
import com.example.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(StudentRecord student) {
        Student newStudent = new Student(student.firstName(),student.lastName(), student.email(), student.schoolId());
        studentRepository.save(newStudent);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
