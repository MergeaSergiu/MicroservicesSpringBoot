package com.example.school.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@Setter
@Getter
public class FullSchoolResponse {

    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("students")
    List<Student> students;

    public FullSchoolResponse(String name, String email, List<Student> students) {
        this.name = name;
        this.email = email;
        this.students = students;
    }

}
