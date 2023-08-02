package com.example.demo.services;

import com.example.demo.models.StudentAccountModel;
import com.example.demo.repositories.StudentAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentAccountServices {
    @Autowired
    private StudentAccountRepository studentAccountRepository;
    public List<StudentAccountModel> GetStudents(){
        return studentAccountRepository.findAll();
    }

    public StudentAccountModel GetStudentById(Integer Id){
        return studentAccountRepository.findById(Id).orElse(null);
    }

    public Boolean SaveStudent(StudentAccountModel studentAccountModel){
        try {
            studentAccountRepository.save(studentAccountModel);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage()   );
            return false;
        }
    }

    public Boolean DeleteStudent(Integer Id){
        try {
            studentAccountRepository.deleteById(Id);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage()   );
            return false;
        }
    }

    public Boolean UpdateStudent(Integer Id, StudentAccountModel updatedStudent) {
        try {
            StudentAccountModel existingStudent = studentAccountRepository.findById(Id).orElse(null);
            if (existingStudent == null) {
                return false; // Student with the given Id not found
            }

            // Update the fields of the existing student with the new data
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setLastName(updatedStudent.getLastName());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setCourse(updatedStudent.getCourse());

            // Save the updated student to the database
            studentAccountRepository.save(existingStudent);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
