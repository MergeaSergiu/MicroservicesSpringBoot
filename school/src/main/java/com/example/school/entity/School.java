package com.example.school.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Setter
@AllArgsConstructor
@Table(name = "_school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private String email;

    public School(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public School() {
        super();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
