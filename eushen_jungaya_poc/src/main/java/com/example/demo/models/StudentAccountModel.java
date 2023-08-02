package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_account", schema = "student")
@Data
public class StudentAccountModel {

    @jakarta.persistence.Id

    @Column(name = "id")
    @JsonProperty(value = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "firstname")
    @JsonProperty(value = "firstname")
    private String FirstName;

    @Column(name="lastname")
    @JsonProperty(value = "lastname")
    private String LastName;

    @Column(name ="age")
    @JsonProperty(value = "age")
    private Integer Age;

    @Column(name="course")
    @JsonProperty(value = "course")
    private String Course;
}
