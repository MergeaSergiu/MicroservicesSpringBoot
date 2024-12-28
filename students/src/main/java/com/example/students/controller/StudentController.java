package com.example.students.controller;

import com.example.students.dto.StudentRecord;
import com.example.students.entity.Student;
import com.example.students.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody StudentRecord student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> getAllStudentsBySchoolId(@PathVariable("school-id") Integer schoolId) {
        List<Student> list =studentService.findAllStudentsBySchool(schoolId);
        return ResponseEntity.ok(list);
    }

}
