package com.example.demo.controllers;

import com.example.demo.models.StudentAccountModel;
import com.example.demo.services.StudentAccountServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    private StudentAccountServices studentAccountServices;

    //    Get All Student
    @GetMapping
    @RequestMapping("get-all-student")
    public ResponseEntity<?> GetStudents(){
        return ResponseEntity.ok(studentAccountServices.GetStudents());
    }

    //    Get Student by Id
    @GetMapping
    @RequestMapping("get-student-by-id")
    public ResponseEntity<?> GetStudentById(@RequestParam(value = "Id") Integer Id){
        return ResponseEntity.ok(studentAccountServices.GetStudentById(Id));
    }

    //  Save Student
    @PostMapping
    @RequestMapping("save-student")
    public ResponseEntity<?> SaveStudent(@RequestBody() StudentAccountModel studentAccountModel){
        return ResponseEntity.ok(studentAccountServices.SaveStudent(studentAccountModel));
    }

    //  Delete Student
    @DeleteMapping
    @RequestMapping("delete-student")
    public ResponseEntity<?> DeleteStudent(@RequestParam(value = "Id") Integer Id){
        return ResponseEntity.ok(studentAccountServices.DeleteStudent(Id));
    }

    //   Update Student
    @PutMapping
    @RequestMapping("update-student")
    public ResponseEntity<?> UpdateStudent(@RequestParam(value = "Id") Integer Id, @RequestBody StudentAccountModel updatedStudent) {
        return ResponseEntity.ok("Student with Id " + Id + " has been updated successfully.");
    }
}
