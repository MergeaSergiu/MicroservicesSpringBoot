package com.example.school.controller;

import com.example.school.dto.FullSchoolResponse;
import com.example.school.dto.SchoolRecord;
import com.example.school.entity.School;
import com.example.school.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public ResponseEntity<String> saveSchool(@RequestBody SchoolRecord school) {
        schoolService.saveSchool(school);
        return new ResponseEntity<>("School created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        return new ResponseEntity<>(schoolService.findAllSchools(), HttpStatus.OK);
    }

    @GetMapping(value = "/with-students/{school-id}", produces = "application/json")
    public ResponseEntity<FullSchoolResponse> getAllSchools(@PathVariable("school-id") Integer schoolId) {
        FullSchoolResponse fullSchoolResponse = schoolService.findAllSchoolsWithStudents(schoolId);
        return ResponseEntity.ok(fullSchoolResponse);
    }

}
